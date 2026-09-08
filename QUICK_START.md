# 🏎️ Car Racing Game - Quick Start

**Get the game running in 5 minutes!**

## ⚡ Ultra-Quick Start

```bash
cd CarGame-trainerstacks
mvn clean package -DskipTests
java -jar target/trainerstacks_car_racing_game-1.0.0-SNAPSHOT.jar
```

Then open: **http://localhost:8080/**

## 🎮 First Time Playing?

### Step 1: Start the Game
```bash
java -jar target/trainerstacks_car_racing_game-1.0.0-SNAPSHOT.jar
```

### Step 2: Create Account
- Go to http://localhost:8080/
- Click "Register"
- Choose a car type (Sports, Truck, Sedan, or Formula 1)
- Submit

### Step 3: Login
- Use your new credentials
- Click "Play Now"
- Select difficulty

### Step 4: Drive!
- Use **Arrow Keys** or **WASD** to move
- **Avoid red cars** 🚧
- **Collect yellow coins** 💰
- **Survive as long as possible** ⏱️

## 🧪 Test Accounts (Pre-loaded)

| Username | Password | Car |
|----------|----------|-----|
| testuser | password123 | Sports |
| racer | racer123 | Formula 1 |
| trucktitan | truck123 | Truck |
| sedanking | sedan123 | Sedan |

## 🐳 Docker

```bash
docker build -t car-game:1.0 .
docker run -p 8080:8080 car-game:1.0
```

## ☸️ Kubernetes

```bash
kubectl apply -f deployment-service.yaml
kubectl port-forward svc/trainerstacks-cargame-service 8080:80
```

## 🎯 Game Controls

| Key | Action |
|-----|--------|
| ⬅️ Arrow Left / A | Move Left |
| ➡️ Arrow Right / D | Move Right |
| Space | Pause/Resume |
| ESC | Quit Game |

## 📊 Scoring

- **Survive Time** = Base Score
- **Collect Coin 💰** = +50 Points
- **Avoid Obstacle 🚧** = Increase Score
- **Game Win** = Score Multiplier

## 🏆 Difficulty Levels

- **Easy** - Slow obstacles, few spawns
- **Medium** - Normal speed, normal spawns
- **Hard** - Fast obstacles, many spawns
- **Extreme** - Ultra-fast, constant spawns

## ⚙️ Requirements

- **Java 11+**
- **Maven 3.9+** (or use included mvnw)
- **Browser** (Chrome, Firefox, Safari, Edge)

## 🆘 Troubleshooting

### "Port 8080 already in use"
```bash
# Use different port
java -jar -Dserver.port=9090 target/trainerstacks_car_racing_game-1.0.0-SNAPSHOT.jar
```

### "Cannot find jar file"
```bash
# Make sure you built it
mvn clean package -DskipTests
```

### "Game runs slowly"
- Close other tabs/applications
- Lower difficulty level
- Try different browser

## 📚 File Structure

```
CarGame-trainerstacks/
├── src/main/java/com/trainerstacks/     ← Game code
├── src/main/resources/
│   ├── templates/                        ← HTML pages
│   └── static/                           ← CSS, JS
├── pom.xml                               ← Maven config
├── Dockerfile                            ← Container
├── deployment-service.yaml               ← Kubernetes
└── README.md                             ← Full docs
```

## 🚀 Next Steps

1. **Play the game** - Get familiar with it
2. **Explore leaderboard** - See top players
3. **Check stats** - View your game history
4. **Deploy to Docker** - Container your app
5. **Deploy to Kubernetes** - Scale it up

## 🎓 Learning

This game teaches:
- ✅ Spring Boot Backend
- ✅ Thymeleaf Templates
- ✅ HTML5 Canvas Game Dev
- ✅ JavaScript Game Logic
- ✅ Database Design (JPA)
- ✅ REST APIs
- ✅ Docker Containerization
- ✅ Kubernetes Deployment

## 📞 Need Help?

Check these:
1. **README.md** - Full documentation
2. **Code comments** - In the source files
3. **Console output** - Check for error messages

## 🎉 Ready to Play?

```bash
mvn spring-boot:run
# Then visit: http://localhost:8080/
```

**Good luck and have fun! 🏁**

---

Version: 1.0.0 | Built with Spring Boot | By TrainerStacks
