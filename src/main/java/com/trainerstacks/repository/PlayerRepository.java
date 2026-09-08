package com.trainerstacks.repository;

import com.trainerstacks.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

/**
 * Player Repository - Database access for Player entity
 */
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    
    Optional<Player> findByUsername(String username);
    
    Optional<Player> findByEmail(String email);
    
    List<Player> findByRole(String role);
    
    List<Player> findAllByOrderByTotalScoreDesc();
    
    List<Player> findByCarType(String carType);
}
