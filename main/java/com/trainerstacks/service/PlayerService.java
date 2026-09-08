package com.trainerstacks.service;

import com.trainerstacks.entity.Player;
import com.trainerstacks.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * PlayerService - Business logic for player management
 */
@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    /**
     * Register a new player
     */
    public Player registerPlayer(String username, String email, String password, String carType) {
        Player player = new Player();
        player.setUsername(username);
        player.setEmail(email);
        player.setPassword(password); // In production, use BCryptPasswordEncoder
        player.setCarType(carType);
        player.setRole("PLAYER");
        player.setActive(true);
        return playerRepository.save(player);
    }

    /**
     * Authenticate player
     */
    public Optional<Player> authenticate(String username, String password) {
        Optional<Player> player = playerRepository.findByUsername(username);
        if (player.isPresent() && player.get().getPassword().equals(password)) {
            // Update last login
            player.get().setLastLogin(LocalDateTime.now());
            playerRepository.save(player.get());
            return player;
        }
        return Optional.empty();
    }

    /**
     * Get player by username
     */
    public Optional<Player> getPlayerByUsername(String username) {
        return playerRepository.findByUsername(username);
    }

    /**
     * Get player by ID
     */
    public Optional<Player> getPlayerById(Long id) {
        return playerRepository.findById(id);
    }

    /**
     * Get all players (leaderboard)
     */
    public List<Player> getLeaderboard() {
        return playerRepository.findAllByOrderByTotalScoreDesc();
    }

    /**
     * Update player score after game
     */
    public Player updatePlayerScore(Long playerId, Integer points) {
        Optional<Player> player = playerRepository.findById(playerId);
        if (player.isPresent()) {
            Player p = player.get();
            p.setTotalScore(p.getTotalScore() + points);
            p.setGamesPlayed(p.getGamesPlayed() + 1);
            return playerRepository.save(p);
        }
        return null;
    }

    /**
     * Update player wins
     */
    public Player updatePlayerWins(Long playerId) {
        Optional<Player> player = playerRepository.findById(playerId);
        if (player.isPresent()) {
            Player p = player.get();
            p.setGamesWon(p.getGamesWon() + 1);
            return playerRepository.save(p);
        }
        return null;
    }

    /**
     * Get top 10 players
     */
    public List<Player> getTopTenPlayers() {
        List<Player> all = playerRepository.findAllByOrderByTotalScoreDesc();
        return all.size() > 10 ? all.subList(0, 10) : all;
    }

    /**
     * Check if username exists
     */
    public Boolean usernameExists(String username) {
        return playerRepository.findByUsername(username).isPresent();
    }

}
