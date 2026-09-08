# 🚀 TrainerStacks Car Racing Game - API Documentation

**Complete REST API Reference**

---

## API Overview

All API endpoints return JSON responses. The application runs on `http://localhost:8080` by default.

---

## Authentication Endpoints

### User Registration
```http
POST /register
Content-Type: application/x-www-form-urlencoded

username=testuser&email=test@example.com&password=password123&carType=sports
```

**Response:** Redirect to /login on success

**Parameters:**
- `username` (String, required) - Unique username
- `email` (String, required) - User email
- `password` (String, required) - User password
- `carType` (String, required) - One of: sports, truck, sedan, formula1

---

### User Login
```http
POST /login
Content-Type: application/x-www-form-urlencoded

username=testuser&password=password123
```

**Response:** Redirect to /dashboard on success

**Parameters:**
- `username` (String, required) - Username
- `password` (String, required) - Password

---

### User Logout
```http
GET /logout
```

**Response:** Redirect to /

---

## Game Endpoints

### Start Game
```http
GET /game/play?difficulty=easy
```

**Response:** Renders game.html with game canvas

**Parameters:**
- `difficulty` (String, optional) - Difficulty level: easy, medium, hard, extreme (default: easy)

**Requires:** User must be logged in (session required)

---

### Save Game Score (API)
```http
POST /game/save-score
Content-Type: application/x-www-form-urlencoded

playerId=1&score=1200&level=3&timeSpent=245&trackName=City%20Track&difficulty=easy&won=true&obstacles=15&coins=25
```

**Response:** 
```json
{
  "id": 1,
  "player": { "id": 1, "username": "testuser" },
  "score": 1200,
  "levelCompleted": 3,
  "timeSpent": 245,
  "trackName": "City Track",
  "difficulty": "easy",
  "won": true,
  "obstaclesAvoided": 15,
  "coinsCollected": 25,
  "playedAt": "2024-09-08T12:34:56"
}
```

**Parameters:**
- `playerId` (Long, required) - Player ID
- `score` (Integer, required) - Final score
- `level` (Integer, required) - Levels completed
- `timeSpent` (Long, required) - Time in seconds
- `trackName` (String, required) - Track name
- `difficulty` (String, required) - Difficulty level
- `won` (Boolean, required) - Did player win
- `obstacles` (Integer, optional) - Obstacles avoided
- `coins` (Integer, optional) - Coins collected

---

### Get Player Statistics
```http
GET /game/stats
```

**Response:** Renders stats.html with player game history

**Requires:** User must be logged in

---

### Choose Difficulty
```http
GET /game/difficulty
```

**Response:** Renders difficulty selection page

---

## REST API Endpoints (JSON Responses)

### Get Leaderboard (All Players)
```http
GET /api/v1/leaderboard
Accept: application/json
```

**Response:**
```json
[
  {
    "id": 2,
    "username": "racer",
    "email": "racer@example.com",
    "carType": "formula1",
    "totalScore": 8750,
    "gamesPlayed": 25,
    "gamesWon": 18,
    "role": "PLAYER"
  },
  {
    "id": 4,
    "username": "sedanking",
    "email": "sedan@example.com",
    "carType": "sedan",
    "totalScore": 6800,
    "gamesPlayed": 15,
    "gamesWon": 9,
    "role": "PLAYER"
  }
]
```

---

### Get Top 10 Players
```http
GET /api/v1/top-10
Accept: application/json
```

**Response:** Same format as leaderboard, max 10 players

---

### Get Player Details
```http
GET /api/v1/player/{id}
Accept: application/json
```

**Response:**
```json
{
  "player": {
    "id": 1,
    "username": "testuser",
    "email": "test@example.com",
    "carType": "sports",
    "totalScore": 5500,
    "gamesPlayed": 10,
    "gamesWon": 4,
    "role": "PLAYER"
  },
  "avgScore": 550.0,
  "wins": 4,
  "gameHistory": [
    {
      "id": 1,
      "score": 1200,
      "levelCompleted": 3,
      "difficulty": "easy",
      "won": true,
      "coinsCollected": 25
    }
  ]
}
```

**Parameters:**
- `id` (Long, required) - Player ID

---

### Get Game Statistics
```http
GET /api/v1/stats
Accept: application/json
```

**Response:**
```json
{
  "totalPlayers": 5,
  "topPlayers": [
    {
      "id": 2,
      "username": "racer",
      "totalScore": 8750,
      "gamesWon": 18
    }
  ]
}
```

---

### Health Check
```http
GET /api/v1/health
Accept: application/json
```

**Response:**
```json
{
  "status": "UP",
  "service": "TrainerStacks Car Racing Game",
  "version": "1.0.0"
}
```

---

## Page Routes (HTML Responses)

| Route | Method | Description | Auth Required |
|-------|--------|-------------|---|
| `/` | GET | Home page | No |
| `/login` | GET | Login page | No |
| `/login` | POST | Process login | No |
| `/register` | GET | Registration page | No |
| `/register` | POST | Process registration | No |
| `/logout` | GET | Logout user | Yes |
| `/dashboard` | GET | Player dashboard | Yes |
| `/leaderboard` | GET | Global leaderboard | No |
| `/game/play` | GET | Play game | Yes |
| `/game/difficulty` | GET | Choose difficulty | Yes |
| `/game/stats` | GET | Player statistics | Yes |

---

## Error Responses

### 404 - Not Found
```json
{
  "error": "Resource not found"
}
```

### 401 - Unauthorized
```json
{
  "error": "Authentication required"
}
```

### 400 - Bad Request
```json
{
  "error": "Invalid parameters"
}
```

---

## Request/Response Examples

### Example 1: Register New Player

**Request:**
```bash
curl -X POST http://localhost:8080/register \
  -d "username=newplayer&email=new@example.com&password=pass123&carType=sports"
```

**Response:** Redirect to login page

---

### Example 2: Login Player

**Request:**
```bash
curl -X POST http://localhost:8080/login \
  -d "username=newplayer&password=pass123"
```

**Response:** Redirect to dashboard + Session cookie set

---

### Example 3: Get Leaderboard

**Request:**
```bash
curl -H "Accept: application/json" \
  http://localhost:8080/api/v1/leaderboard
```

**Response:** JSON array of all players sorted by score

---

### Example 4: Save Game Score

**Request:**
```bash
curl -X POST http://localhost:8080/game/save-score \
  -d "playerId=1&score=2500&level=5&timeSpent=450&trackName=Desert&difficulty=hard&won=true&obstacles=40&coins=50"
```

**Response:** JSON object with saved game score

---

### Example 5: Get Player Details

**Request:**
```bash
curl -H "Accept: application/json" \
  http://localhost:8080/api/v1/player/1
```

**Response:** Player details with statistics and game history

---

## Testing with Postman

### 1. Import these endpoints into Postman:

**GET** - http://localhost:8080/api/v1/leaderboard
**GET** - http://localhost:8080/api/v1/top-10
**GET** - http://localhost:8080/api/v1/player/1
**GET** - http://localhost:8080/api/v1/stats
**GET** - http://localhost:8080/api/v1/health

### 2. Test Game Score Endpoint:

**Method:** POST
**URL:** http://localhost:8080/game/save-score
**Body (form-data):**
```
playerId: 1
score: 1500
level: 4
timeSpent: 300
trackName: Test Track
difficulty: medium
won: true
obstacles: 20
coins: 30
```

---

## Authentication Notes

- **Session-based:** Uses HTTP sessions (cookie-based)
- **No API keys:** Required for HTML endpoints
- **REST API:** Currently open to all (no API key in v1.0)
- **Cookies:** JSESSIONID cookie maintains session

---

## Rate Limiting

Currently no rate limiting implemented. For production, consider:
- Adding Spring Security rate limiters
- Using API Gateway (AWS API Gateway, Kong, etc.)
- Implementing per-IP rate limiting

---

## CORS Policy

**Current:** No CORS restrictions (allows all origins)

**Production:** Update SecurityConfig to restrict origins:
```java
@Override
protected void configure(HttpSecurity http) throws Exception {
    http.cors().and()...
}
```

---

## Data Models

### Player Entity
```java
{
  "id": Long,
  "username": String,
  "password": String,
  "email": String,
  "carType": String,
  "totalScore": Integer,
  "gamesPlayed": Integer,
  "gamesWon": Integer,
  "role": String,
  "createdAt": LocalDateTime,
  "lastLogin": LocalDateTime,
  "active": Boolean
}
```

### GameScore Entity
```java
{
  "id": Long,
  "player": Player,
  "score": Integer,
  "levelCompleted": Integer,
  "timeSpent": Long,
  "trackName": String,
  "difficulty": String,
  "won": Boolean,
  "obstaclesAvoided": Integer,
  "coinsCollected": Integer,
  "playedAt": LocalDateTime
}
```

---

## Testing Accounts

| Username | Password | Car |
|----------|----------|-----|
| testuser | password123 | sports |
| racer | racer123 | formula1 |
| trucktitan | truck123 | truck |
| sedanking | sedan123 | sedan |

---

## Common Use Cases

### 1. Display Leaderboard in Mobile App
```bash
GET /api/v1/leaderboard
# Returns all players sorted by score
```

### 2. Get Player Profile Data
```bash
GET /api/v1/player/{playerId}
# Returns player info + statistics + game history
```

### 3. Save Game Score After Playing
```bash
POST /game/save-score
# With form data containing game results
```

### 4. Check Server Health
```bash
GET /api/v1/health
# Returns service status
```

---

## Version Info

- **API Version:** 1.0
- **Game Version:** 1.0.0
- **Spring Boot:** 2.7.15
- **Database:** H2 (dev), MySQL (production)

---

**Last Updated:** September 2024
