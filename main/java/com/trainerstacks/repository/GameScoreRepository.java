package com.trainerstacks.repository;

import com.trainerstacks.entity.GameScore;
import com.trainerstacks.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * GameScore Repository - Database access for GameScore entity
 */
@Repository
public interface GameScoreRepository extends JpaRepository<GameScore, Long> {
    
    List<GameScore> findByPlayer(Player player);
    
    List<GameScore> findByPlayerOrderByPlayedAtDesc(Player player);
    
    List<GameScore> findAllByOrderByScoreDesc();
    
    List<GameScore> findByDifficulty(String difficulty);
    
    List<GameScore> findByWonTrue();
    
    @Query("SELECT COUNT(g) FROM GameScore g WHERE g.player = ?1 AND g.won = true")
    Long countWinsByPlayer(Player player);
    
    @Query("SELECT AVG(g.score) FROM GameScore g WHERE g.player = ?1")
    Double getAverageScoreByPlayer(Player player);
}
