package com.trainerstacks.controller;

import com.trainerstacks.entity.Player;
import com.trainerstacks.service.GameScoreService;
import com.trainerstacks.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * ApiController - REST API endpoints for game data
 */
@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class ApiController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private GameScoreService gameScoreService;

    /**
     * Get leaderboard
     */
    @GetMapping("/leaderboard")
    public List<Player> getLeaderboard() {
        return playerService.getLeaderboard();
    }

    /**
     * Get top 10 players
     */
    @GetMapping("/top-10")
    public List<Player> getTopTen() {
        return playerService.getTopTenPlayers();
    }

    /**
     * Get player details
     */
    @GetMapping("/player/{id}")
    public Map<String, Object> getPlayerDetails(@PathVariable Long id) {
        var player = playerService.getPlayerById(id);
        Map<String, Object> response = new HashMap<>();
        
        if (player.isPresent()) {
            response.put("player", player.get());
            response.put("avgScore", gameScoreService.getPlayerAverageScore(id));
            response.put("wins", gameScoreService.getPlayerWins(id));
            response.put("gameHistory", gameScoreService.getPlayerGameHistory(id));
        }
        
        return response;
    }

    /**
     * Get game statistics
     */
    @GetMapping("/stats")
    public Map<String, Object> getGameStats() {
        Map<String, Object> stats = new HashMap<>();
        
        List<Player> topPlayers = playerService.getTopTenPlayers();
        stats.put("totalPlayers", playerService.getLeaderboard().size());
        stats.put("topPlayers", topPlayers);
        
        return stats;
    }

    /**
     * Health check
     */
    @GetMapping("/health")
    public Map<String, String> health() {
        Map<String, String> health = new HashMap<>();
        health.put("status", "UP");
        health.put("service", "TrainerStacks Car Racing Game");
        health.put("version", "1.0.0");
        return health;
    }

}
