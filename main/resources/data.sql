-- Insert test data for TrainerStacks Car Racing Game

-- Test Players
INSERT INTO PLAYER (id, username, password, email, car_type, total_score, games_played, games_won, role, active) 
VALUES (1, 'testuser', 'password123', 'test@trainerstacks.com', 'sports', 5500, 10, 4, 'PLAYER', true);

INSERT INTO PLAYER (id, username, password, email, car_type, total_score, games_played, games_won, role, active) 
VALUES (2, 'racer', 'racer123', 'racer@trainerstacks.com', 'formula1', 8750, 25, 18, 'PLAYER', true);

INSERT INTO PLAYER (id, username, password, email, car_type, total_score, games_played, games_won, role, active) 
VALUES (3, 'trucktitan', 'truck123', 'truck@trainerstacks.com', 'truck', 4200, 8, 2, 'PLAYER', true);

INSERT INTO PLAYER (id, username, password, email, car_type, total_score, games_played, games_won, role, active) 
VALUES (4, 'sedanking', 'sedan123', 'sedan@trainerstacks.com', 'sedan', 6800, 15, 9, 'PLAYER', true);

INSERT INTO PLAYER (id, username, password, email, car_type, total_score, games_played, games_won, role, active) 
VALUES (5, 'admin', 'admin123', 'admin@trainerstacks.com', 'formula1', 0, 0, 0, 'ADMIN', true);

-- Test Game Scores
INSERT INTO GAME_SCORE (id, player_id, score, level_completed, time_spent, track_name, difficulty, won, obstacles_avoided, coins_collected) 
VALUES (1, 1, 1200, 3, 245, 'City Track', 'easy', true, 15, 25);

INSERT INTO GAME_SCORE (id, player_id, score, level_completed, time_spent, track_name, difficulty, won, obstacles_avoided, coins_collected) 
VALUES (2, 1, 980, 2, 180, 'Mountain Pass', 'medium', false, 8, 12);

INSERT INTO GAME_SCORE (id, player_id, score, level_completed, time_spent, track_name, difficulty, won, obstacles_avoided, coins_collected) 
VALUES (3, 2, 2500, 5, 450, 'Desert Highway', 'hard', true, 40, 50);

INSERT INTO GAME_SCORE (id, player_id, score, level_completed, time_spent, track_name, difficulty, won, obstacles_avoided, coins_collected) 
VALUES (4, 2, 2100, 4, 380, 'Forest Road', 'hard', true, 35, 42);

INSERT INTO GAME_SCORE (id, player_id, score, level_completed, time_spent, track_name, difficulty, won, obstacles_avoided, coins_collected) 
VALUES (5, 3, 800, 2, 150, 'City Track', 'easy', false, 5, 8);
