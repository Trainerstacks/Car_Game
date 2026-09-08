package com.trainerstacks.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * GameScore Entity - Tracks individual game results
 */
@Entity
@Table(name = "GAME_SCORE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @Column(nullable = false)
    private Integer score;

    @Column(nullable = false)
    private Integer levelCompleted;

    @Column(nullable = false)
    private Long timeSpent; // in seconds

    @Column(nullable = false)
    private String trackName;

    @Column(nullable = false)
    private String difficulty; // easy, medium, hard, extreme

    @Column(nullable = false)
    private Boolean won = false;

    @Column(nullable = false)
    private Integer obstaclesAvoided = 0;

    @Column(nullable = false)
    private Integer coinsCollected = 0;

    @Column(nullable = false)
    private LocalDateTime playedAt = LocalDateTime.now();

}
