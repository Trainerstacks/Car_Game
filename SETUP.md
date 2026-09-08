# 🏎️ TrainerStacks Car Racing Game - Complete Setup Guide

**For Students and Developers**

---

## 📋 Table of Contents

1. [Prerequisites](#prerequisites)
2. [Installation Steps](#installation-steps)
3. [Running the Application](#running-the-application)
4. [First Time Setup](#first-time-setup)
5. [Deployment Options](#deployment-options)
6. [Testing](#testing)
7. [Troubleshooting](#troubleshooting)

---

## Prerequisites

### Minimum Requirements

- **Java 11+** (OpenJDK or Oracle JDK)
- **Maven 3.9+** (OR use included mvnw)
- **Git** (for cloning the repository)
- **Web Browser** (Chrome, Firefox, Safari, Edge)

### Optional

- **Docker** (for containerization)
- **kubectl** (for Kubernetes deployment)
- **IDE** (IntelliJ IDEA, Eclipse, VS Code with Java extensions)

### Verify Installation

```bash
# Check Java
java -version
# Expected: Java 11 or higher

# Check Maven (if installed)
mvn -version
# Expected: Maven 3.9+
```

---

## Installation Steps

### Step 1: Clone the Repository

```bash
# HTTPS
git clone https://github.com/YOUR-USERNAME/CarGame-trainerstacks.git

# OR SSH
git clone git@github.com:YOUR-USERNAME/CarGame-trainerstacks.git

# Navigate to project
cd CarGame-trainerstacks
```

### Step 2: Verify Project Structure

```bash
# Check if files are present
ls -la

# Should see: pom.xml, src/, Dockerfile, README.md, etc.
```

### Step 3: Download Dependencies

```bash
# Using Maven wrapper (no Maven install needed!)
./mvnw clean dependency:resolve

# OR if Maven is installed
mvn clean dependency:resolve

# Windows users:
mvnw.cmd clean dependency:resolve
```

**This may take 2-5 minutes on first run**

### Step 4: Build the Application

```bash
# Clean build
./mvnw clean package -DskipTests

# OR
mvn clean package -DskipTests

# Output: target/trainerstacks_car_racing_game-1.0.0-SNAPSHOT.jar
```

---

## Running the Application

### Option 1: Using Maven (Easiest for Development)

```bash
# Start the application
./mvnw spring-boot:run

# OR
mvn spring-boot:run

# Expected output:
# Tomcat started on port(s): 8080 (http)
# Started TrainerStacksCarGameApplication
```

**Then open:** http://localhost:8080/

### Option 2: Using Java JAR (Best for Testing)

```bash
# First, build if not already done
./mvnw clean package -DskipTests

# Run the JAR
java -jar target/trainerstacks_car_racing_game-1.0.0-SNAPSHOT.jar

# Expected output:
# Tomcat started on port(s): 8080 (http)
```

**Then open:** http://localhost:8080/

### Option 3: Using Docker (If Docker Installed)

```bash
# Build Docker image
docker build -t trainerstacks-cargame:1.0 .

# Run container
docker run -d -p 8080:8080 --name cargame trainerstacks-cargame:1.0

# View logs
docker logs -f cargame

# Stop container
docker stop cargame
```

**Then open:** http://localhost:8080/

---

## First Time Setup

### 1. Start the Application

Use any method from above. Application starts at `http://localhost:8080/`

### 2. Check if it's Running

```bash
# You should see:
# - Green/purple homepage
# - "Play Now" button
# - "Register" button
# - "Leaderboard" button
```

### 3. Create Your Account

1. Click **Register**
2. Fill in:
   - Username: `your_username`
   - Email: `your@email.com`
   - Password: `your_password`
   - Car Type: Choose one (Sports, Truck, Sedan, Formula1)
3. Click **Submit**
4. Redirected to login page
5. Login with your credentials

### 4. Play Your First Game

1. Click **Play Now** on dashboard
2. Select difficulty (Start with **Easy**)
3. Click **Start Game**
4. Use arrow keys or WASD to move
5. Avoid red obstacles 🚧
6. Collect yellow coins 💰
7. Survive as long as possible

### 5. Check Leaderboard

1. Go back to home page
2. Click **Leaderboard**
3. See your score and ranking

---

## Deployment Options

### Local Development
**Best for:** Learning and testing

```bash
./mvnw spring-boot:run
```

### Production - Docker

**Step 1: Build Image**
```bash
docker build -t cargame-app:1.0.0 .
```

**Step 2: Run Container**
```bash
docker run -d \
  --name cargame \
  -p 8080:8080 \
  -e JAVA_OPTS="-Xms512m -Xmx1024m" \
  cargame-app:1.0.0
```

**Step 3: Access**
- URL: http://localhost:8080/

**Step 4: Stop Container**
```bash
docker stop cargame
docker rm cargame
```

### Production - Kubernetes

**Step 1: Build and Push Docker Image**
```bash
docker build -t your-registry/cargame:1.0.0 .
docker push your-registry/cargame:1.0.0
```

**Step 2: Deploy to Kubernetes**
```bash
# Update deployment-service.yaml with your image
kubectl apply -f deployment-service.yaml
```

**Step 3: Check Deployment**
```bash
kubectl get pods
kubectl get svc
```

**Step 4: Access Service**
```bash
kubectl port-forward svc/trainerstacks-cargame-service 8080:80
# Then: http://localhost:8080/
```

---

## Testing

### Test Pre-loaded Accounts

| Username | Password | Car | Score |
|----------|----------|-----|-------|
| testuser | password123 | Sports | 5,500 |
| racer | racer123 | Formula 1 | 8,750 |
| trucktitan | truck123 | Truck | 4,200 |
| sedanking | sedan123 | Sedan | 6,800 |

### Test the Game

```bash
# 1. Start app
./mvnw spring-boot:run

# 2. Login with test user
# Username: testuser
# Password: password123

# 3. Play a game
# Click: Play Now → Easy → Start Game

# 4. Test game mechanics
# - Move left/right with arrow keys
# - Collect coins (yellow)
# - Avoid obstacles (red)
# - Play for 1-2 minutes
# - Game Over

# 5. Check stats
# - Dashboard shows updated score
# - Leaderboard updated
# - Game history recorded
```

### Run Unit Tests

```bash
# Run all tests
./mvnw test

# Run specific test class
./mvnw test -Dtest=PlayerServiceTest

# Run with coverage
./mvnw clean test jacoco:report
```

---

## Troubleshooting

### Problem: "mvn: command not found"

**Solution 1:** Use Maven Wrapper
```bash
./mvnw clean package -DskipTests
```

**Solution 2:** Install Maven
```bash
# macOS
brew install maven

# Linux
sudo apt-get install maven

# Windows - Download from https://maven.apache.org/
```

### Problem: "Port 8080 already in use"

**Solution 1:** Use different port
```bash
./mvnw spring-boot:run -Dserver.port=9090
```

**Solution 2:** Kill process using port 8080
```bash
# macOS/Linux
lsof -i :8080
kill -9 <PID>

# Windows
netstat -ano | findstr :8080
taskkill /PID <PID> /F
```

### Problem: "Cannot find jar file"

**Solution:** Build first
```bash
./mvnw clean package -DskipTests
# Then run:
java -jar target/trainerstacks_car_racing_game-1.0.0-SNAPSHOT.jar
```

### Problem: Database error "Database not found"

**Solution:** Database auto-creates. Just restart:
```bash
# Stop the app (Ctrl+C)
# Start again:
./mvnw spring-boot:run
```

### Problem: Game runs slowly

**Solution:**
- Close other browser tabs
- Reduce browser extensions
- Try lower difficulty level
- Clear browser cache

### Problem: Login fails

**Solution:**
- Verify username/password spelling
- Create new account with Register
- Use test account: testuser / password123

### Problem: Cannot build - "compilation error"

**Solution:** Check Java version
```bash
java -version
# Should be 11 or higher

# If older, install Java 11+
```

### Problem: Maven build timeout

**Solution:** Skip tests for faster build
```bash
./mvnw clean package -DskipTests
```

---

## File Structure Explained

```
CarGame-trainerstacks/
│
├── src/main/java/com/trainerstacks/
│   ├── TrainerStacksCarGameApplication.java      ← Main entry point
│   ├── controller/
│   │   ├── HomeController.java                   ← Pages & authentication
│   │   ├── GameController.java                   ← Game logic & scoring
│   │   └── ApiController.java                    ← REST API endpoints
│   ├── entity/
│   │   ├── Player.java                           ← Player data model
│   │   └── GameScore.java                        ← Score data model
│   ├── service/
│   │   ├── PlayerService.java                    ← Player business logic
│   │   └── GameScoreService.java                 ← Scoring logic
│   └── repository/
│       ├── PlayerRepository.java                 ← Database access
│       └── GameScoreRepository.java              ← Score database access
│
├── src/main/resources/
│   ├── templates/
│   │   ├── index.html                            ← Home page
│   │   ├── login.html                            ← Login page
│   │   ├── register.html                         ← Registration page
│   │   ├── game.html                             ← Game canvas page
│   │   ├── dashboard.html                        ← Player dashboard
│   │   ├── leaderboard.html                      ← Rankings page
│   │   └── stats.html                            ← Statistics page
│   ├── static/
│   │   ├── css/                                  ← Stylesheets
│   │   └── js/                                   ← JavaScript files
│   ├── application.properties                    ← Configuration
│   └── data.sql                                  ← Test data
│
├── src/test/java/                                ← Unit tests
│
├── .mvn/wrapper/                                 ← Maven wrapper (no install needed!)
├── pom.xml                                       ← Maven dependencies
├── Dockerfile                                    ← Docker container config
├── deployment-service.yaml                       ← Kubernetes config
├── .gitignore                                    ← Git ignore rules
│
├── README.md                                     ← Project overview
├── QUICK_START.md                                ← 5-minute guide
├── SETUP.md                                      ← This file
├── API_DOCUMENTATION.md                          ← API endpoints
└── PROJECT_STRUCTURE.md                          ← Code structure details
```

---

## Important Notes

⚠️ **Development vs Production:**
- H2 database (in-memory) = Development only
- For production: Configure MySQL or PostgreSQL
- Update `application.properties` with production database

⚠️ **Security:**
- Test password storage (plain text) = DEV ONLY
- Production: Use BCryptPasswordEncoder
- Enable HTTPS for production

⚠️ **Performance:**
- H2 auto-creates tables on startup
- First run takes longer (database initialization)
- Subsequent runs are faster

---

## Useful Commands

```bash
# Clean everything
./mvnw clean

# Build only
./mvnw compile

# Run tests
./mvnw test

# Build package
./mvnw package

# Skip tests (faster)
./mvnw package -DskipTests

# Run application
./mvnw spring-boot:run

# Build Docker image
docker build -t cargame:1.0 .

# Deploy to Kubernetes
kubectl apply -f deployment-service.yaml

# View application logs
./mvnw spring-boot:run -X  # Detailed logs

# Check port 8080
lsof -i :8080  # macOS/Linux
netstat -ano | findstr :8080  # Windows
```

---

## Next Steps After Setup

1. ✅ Get application running locally
2. ✅ Play a game and understand mechanics
3. ✅ Review code in `src/main/java/`
4. ✅ Study database entities
5. ✅ Explore REST API endpoints
6. ✅ Try modifying game difficulty
7. ✅ Deploy to Docker
8. ✅ Deploy to Kubernetes

---

## Getting Help

1. Check **README.md** for overview
2. Read **QUICK_START.md** for fast start
3. See **API_DOCUMENTATION.md** for endpoints
4. Review **PROJECT_STRUCTURE.md** for code details
5. Check console output for error messages
6. Google the error message
7. Ask in class or discussions

---

## Success Criteria

Your setup is complete when:

✅ Application starts without errors
✅ Home page loads at http://localhost:8080/
✅ Can register new account
✅ Can login with credentials
✅ Can play a game
✅ Game responds to keyboard input
✅ Score updates correctly
✅ Leaderboard displays players
✅ No database errors in console

---

**Version:** 1.0.0  
**Last Updated:** September 2024  
**Status:** ✅ Ready to Use

**Happy Learning! 🎮🏎️**
