package com.trainerstacks.service;

import com.trainerstacks.entity.GameScore;
import com.trainerstacks.entity.Player;
import com.trainerstacks.repository.GameScoreRepository;
import com.trainerstacks.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * GameScoreService - Business logic for game scoring and statistics
 */
@Service
public class GameScoreService {

    @Autowired
    private GameScoreRepository gameScoreRepository;

    @Autowired
    private PlayerRepository playerRepository;

    /**
     * Save game score after a game completes
     */
    public GameScore saveGameScore(Long playerId, Integer score, Integer level, 
                                   Long timeSpent, String trackName, String difficulty,
                                   Boolean won, Integer obstaclesAvoided, Integer coinsCollected) {
        Optional<Player> player = playerRepository.findById(playerId);
        if (player.isEmpty()) {
            return null;
        }

        GameScore gameScore = new GameScore();
        gameScore.setPlayer(player.get());
        gameScore.setScore(score);
        gameScore.setLevelCompleted(level);
        gameScore.setTimeSpent(timeSpent);
        gameScore.setTrackName(trackName);
        gameScore.setDifficulty(difficulty);
        gameScore.setWon(won);
        gameScore.setObstaclesAvoided(obstaclesAvoided);
        gameScore.setCoinsCollected(coinsCollected);

        // Update player stats
        if (won) {
            player.get().setGamesWon(player.get().getGamesWon() + 1);
        }
        player.get().setGamesPlayed(player.get().getGamesPlayed() + 1);
        player.get().setTotalScore(player.get().getTotalScore() + score);
        playerRepository.save(player.get());

        return gameScoreRepository.save(gameScore);
    }

    /**
     * Get player game history
     */
    public List<GameScore> getPlayerGameHistory(Long playerId) {
        Optional<Player> player = playerRepository.findById(playerId);
        if (player.isEmpty()) {
            return null;
        }
        return gameScoreRepository.findByPlayerOrderByPlayedAtDesc(player.get());
    }

    /**
     * Get global leaderboard
     */
    public List<GameScore> getTopScores() {
        List<GameScore> scores = gameScoreRepository.findAllByOrderByScoreDesc();
        return scores.size() > 20 ? scores.subList(0, 20) : scores;
    }

    /**
     * Get average score for player
     */
    public Double getPlayerAverageScore(Long playerId) {
        Optional<Player> player = playerRepository.findById(playerId);
        if (player.isEmpty()) {
            return 0.0;
        }
        return gameScoreRepository.getAverageScoreByPlayer(player.get());
    }

    /**
     * Get total wins for player
     */
    public Long getPlayerWins(Long playerId) {
        Optional<Player> player = playerRepository.findById(playerId);
        if (player.isEmpty()) {
            return 0L;
        }
        return gameScoreRepository.countWinsByPlayer(player.get());
    }

    /**
     * Get difficulty statistics
     */
    public List<GameScore> getScoresByDifficulty(String difficulty) {
        return gameScoreRepository.findByDifficulty(difficulty);
    }

}
