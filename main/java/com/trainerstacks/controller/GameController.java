package com.trainerstacks.controller;

import com.trainerstacks.entity.GameScore;
import com.trainerstacks.entity.Player;
import com.trainerstacks.service.GameScoreService;
import com.trainerstacks.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

/**
 * GameController - Handles game play and scoring
 */
@Controller
@RequestMapping("/game")
public class GameController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private GameScoreService gameScoreService;

    /**
     * Show game page
     */
    @GetMapping("/play")
    public String playGame(@RequestParam(required = false) String difficulty, 
                          HttpSession session, 
                          Model model) {
        Player player = (Player) session.getAttribute("player");
        if (player == null) {
            return "redirect:/login";
        }

        if (difficulty == null) {
            difficulty = "easy";
        }

        model.addAttribute("difficulty", difficulty);
        model.addAttribute("player", player);
        return "game";
    }

    /**
     * Save game score (API endpoint)
     */
    @PostMapping("/save-score")
    @ResponseBody
    public GameScore saveGameScore(@RequestParam Long playerId,
                                  @RequestParam Integer score,
                                  @RequestParam Integer level,
                                  @RequestParam Long timeSpent,
                                  @RequestParam String trackName,
                                  @RequestParam String difficulty,
                                  @RequestParam Boolean won,
                                  @RequestParam(defaultValue = "0") Integer obstacles,
                                  @RequestParam(defaultValue = "0") Integer coins) {
        return gameScoreService.saveGameScore(playerId, score, level, timeSpent, 
                                            trackName, difficulty, won, obstacles, coins);
    }

    /**
     * Get player statistics
     */
    @GetMapping("/stats")
    public String getStats(HttpSession session, Model model) {
        Player player = (Player) session.getAttribute("player");
        if (player == null) {
            return "redirect:/login";
        }

        model.addAttribute("player", player);
        model.addAttribute("gameHistory", gameScoreService.getPlayerGameHistory(player.getId()));
        model.addAttribute("avgScore", gameScoreService.getPlayerAverageScore(player.getId()));
        model.addAttribute("wins", gameScoreService.getPlayerWins(player.getId()));
        
        return "stats";
    }

    /**
     * Choose difficulty
     */
    @GetMapping("/difficulty")
    public String chooseDifficulty(HttpSession session) {
        Player player = (Player) session.getAttribute("player");
        if (player == null) {
            return "redirect:/login";
        }
        return "difficulty";
    }

    /**
     * Game over - show results
     */
    @PostMapping("/game-over")
    @ResponseBody
    public String gameOver(@RequestParam Integer score,
                          @RequestParam String difficulty,
                          @RequestParam Boolean won,
                          HttpSession session) {
        Player player = (Player) session.getAttribute("player");
        if (player != null) {
            gameScoreService.saveGameScore(player.getId(), score, 1, 0L, 
                                          "Track 1", difficulty, won, 0, 0);
        }
        return "{\"status\":\"success\"}";
    }

}
