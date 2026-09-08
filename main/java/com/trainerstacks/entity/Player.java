package com.trainerstacks.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Player Entity - Represents a game player
 */
@Entity
@Table(name = "PLAYER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String carType; // sports, truck, sedan, formula1

    @Column(nullable = false)
    private Integer totalScore = 0;

    @Column(nullable = false)
    private Integer gamesPlayed = 0;

    @Column(nullable = false)
    private Integer gamesWon = 0;

    @Column(nullable = false)
    private String role; // PLAYER, ADMIN

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false)
    private LocalDateTime lastLogin = LocalDateTime.now();

    private Boolean active = true;

}
