package com.trainerstacks.controller;

import com.trainerstacks.entity.Player;
import com.trainerstacks.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * HomeController - Handles home page and authentication
 */
@Controller
public class HomeController {

    @Autowired
    private PlayerService playerService;

    /**
     * Home page
     */
    @GetMapping("/")
    public String home(HttpSession session, Model model) {
        Player player = (Player) session.getAttribute("player");
        if (player != null) {
            model.addAttribute("player", player);
            return "redirect:/dashboard";
        }
        return "index";
    }

    /**
     * Show login page
     */
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    /**
     * Handle login
     */
    @PostMapping("/login")
    public String login(@RequestParam String username, 
                       @RequestParam String password,
                       HttpSession session,
                       Model model) {
        var player = playerService.authenticate(username, password);
        if (player.isPresent()) {
            session.setAttribute("player", player.get());
            return "redirect:/dashboard";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    /**
     * Show registration page
     */
    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    /**
     * Handle registration
     */
    @PostMapping("/register")
    public String register(@RequestParam String username,
                          @RequestParam String email,
                          @RequestParam String password,
                          @RequestParam String carType,
                          Model model) {
        if (playerService.usernameExists(username)) {
            model.addAttribute("error", "Username already exists!");
            return "register";
        }
        
        try {
            Player player = playerService.registerPlayer(username, email, password, carType);
            model.addAttribute("success", "Registration successful! Please login.");
            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("error", "Registration failed: " + e.getMessage());
            return "register";
        }
    }

    /**
     * Dashboard
     */
    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        Player player = (Player) session.getAttribute("player");
        if (player == null) {
            return "redirect:/login";
        }
        
        // Refresh player data
        var freshPlayer = playerService.getPlayerById(player.getId());
        if (freshPlayer.isPresent()) {
            model.addAttribute("player", freshPlayer.get());
            session.setAttribute("player", freshPlayer.get());
        }
        
        return "dashboard";
    }

    /**
     * Leaderboard
     */
    @GetMapping("/leaderboard")
    public String leaderboard(Model model) {
        List<Player> topPlayers = playerService.getLeaderboard();
        model.addAttribute("players", topPlayers.size() > 10 ? 
                                     topPlayers.subList(0, 10) : topPlayers);
        return "leaderboard";
    }

    /**
     * Logout
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}
