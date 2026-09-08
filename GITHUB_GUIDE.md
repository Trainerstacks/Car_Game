# 🚀 GitHub Guide - Complete Instructions

**How to Use This Repository in Your Classes**

---

## 📋 Table of Contents

1. [Create Your GitHub Repository](#create-your-github-repository)
2. [Clone and Setup](#clone-and-setup)
3. [Push to Your Repository](#push-to-your-repository)
4. [Share with Students](#share-with-students)
5. [Student Workflow](#student-workflow)
6. [Contributing Guidelines](#contributing-guidelines)

---

## Create Your GitHub Repository

### Step 1: Create GitHub Account (If Needed)

1. Visit https://github.com
2. Click **Sign up**
3. Create account with email
4. Verify email

### Step 2: Create New Repository

1. Click **+** icon in top right
2. Select **New repository**
3. Fill in:
   - **Repository name:** `trainerstacks-car-racing-game` (or similar)
   - **Description:** `Full-Stack Java Car Racing Game with Spring Boot`
   - **Public/Private:** Choose (Public recommended for classes)
   - **README:** Check "Add a README file"
4. Click **Create repository**

### Step 3: Get Clone Link

1. Click **<> Code** button
2. Select **HTTPS** or **SSH**
3. Copy URL
   - HTTPS: `https://github.com/username/repo.git`
   - SSH: `git@github.com:username/repo.git`

---

## Clone and Setup

### Option A: From Empty GitHub Repository

```bash
# 1. Clone your empty repo
git clone https://github.com/YOUR-USERNAME/trainerstacks-car-racing-game.git
cd trainerstacks-car-racing-game

# 2. Copy all files from this project into that folder
# (Copy all files from CarGame-trainerstacks into your new folder)

# 3. Initialize git and push
git add .
git commit -m "Initial commit: TrainerStacks Car Racing Game"
git branch -M main
git push -u origin main
```

### Option B: Clone This Repository First

```bash
# 1. Clone this repository
git clone https://github.com/source-username/CarGame-trainerstacks.git
cd CarGame-trainerstacks

# 2. Remove original remote
git remote remove origin

# 3. Add your repository as remote
git remote add origin https://github.com/YOUR-USERNAME/your-repo-name.git

# 4. Push to your repository
git branch -M main
git push -u origin main
```

---

## Push to Your Repository

### Complete Push Workflow

```bash
# 1. Navigate to project
cd trainerstacks-car-racing-game

# 2. Check status
git status

# 3. Add all files
git add .

# 4. Commit with message
git commit -m "Initial commit: TrainerStacks Car Racing Game v1.0"

# 5. Push to GitHub
git push -u origin main

# Verify: Check GitHub.com - files should appear
```

### Update Existing Repository

```bash
# 1. Make changes to files
# (Edit, add, delete files)

# 2. Check what changed
git status

# 3. Stage changes
git add .
# Or specific files:
git add src/main/java/com/trainerstacks/controller/GameController.java

# 4. Commit
git commit -m "Fix: Game speed calculation"

# 5. Push
git push

# Verify: Changes appear on GitHub.com
```

---

## Share with Students

### Method 1: GitHub Classroom (Recommended for Classes)

1. Go to https://classroom.github.com
2. Create new assignment
3. Select this repository as template
4. Students get their own copy
5. Track submissions automatically

### Method 2: Direct Repository Link

1. Create public repository
2. Share link with students: `https://github.com/YOUR-USERNAME/repo-name`
3. Students clone: `git clone https://github.com/YOUR-USERNAME/repo-name.git`

### Method 3: Distribute Archive

```bash
# Create ZIP file
git clone https://github.com/YOUR-USERNAME/repo-name.git
cd repo-name
zip -r CarGame.zip . -x ".git/*"

# Share CarGame.zip with students
# Students extract and use locally
```

---

## Student Workflow

### For Students Learning from This Repository

#### Step 1: Clone Repository

```bash
# Clone your teacher's repository
git clone https://github.com/TEACHER-USERNAME/trainerstacks-car-racing-game.git
cd trainerstacks-car-racing-game
```

#### Step 2: First Time Setup

```bash
# Install dependencies
./mvnw clean dependency:resolve

# Build application
./mvnw clean package -DskipTests

# Run the game
./mvnw spring-boot:run
```

#### Step 3: Run the Game

Open browser: http://localhost:8080/

Register account → Select car → Play!

#### Step 4: Explore Code

```bash
# Read key files
cat README.md          # Project overview
cat SETUP.md          # Setup instructions
cat API_DOCUMENTATION.md  # API reference

# Browse code
src/main/java/com/trainerstacks/controller/  # Controllers
src/main/java/com/trainerstacks/entity/      # Data models
src/main/java/com/trainerstacks/service/     # Business logic

# Browse UI
src/main/resources/templates/   # HTML pages
src/main/resources/static/      # CSS, JavaScript
```

#### Step 5: Make Changes (For Learning)

```bash
# Create your own branch
git checkout -b feature/your-feature-name

# Make changes to files
# Edit src/main/java/...

# Test your changes
./mvnw spring-boot:run

# Commit changes
git add .
git commit -m "Feature: Your description of changes"

# Push branch (if you have write access)
git push origin feature/your-feature-name

# Create Pull Request on GitHub (optional)
```

#### Step 6: Keep Updated

```bash
# Get latest changes from teacher's repository
git pull origin main

# If you have conflicts, resolve them:
git status
# Edit conflicting files
git add .
git commit -m "Resolved merge conflicts"
git push
```

---

## Contributing Guidelines

### For Students Contributing to Project

#### 1. Setup Development Environment

```bash
git clone https://github.com/YOUR-USERNAME/trainerstacks-car-racing-game.git
cd trainerstacks-car-racing-game
./mvnw clean package -DskipTests
```

#### 2. Create Feature Branch

```bash
# Always create new branch for new features
git checkout -b feature/my-new-feature
# or
git checkout -b bugfix/fix-game-speed
# or
git checkout -b docs/update-readme
```

#### 3. Make Your Changes

- Edit relevant files
- Keep changes focused on one feature
- Add comments for complex code
- Test your changes: `./mvnw spring-boot:run`

#### 4. Commit Changes

```bash
# Check what changed
git status

# Stage your changes
git add .

# Commit with descriptive message
git commit -m "Feature: Add difficulty selection screen"
# or
git commit -m "Fix: Correct coin collection detection"
# or
git commit -m "Docs: Add API documentation"
```

#### 5. Push and Create Pull Request

```bash
# Push your branch
git push origin feature/my-new-feature

# Go to GitHub.com
# Click "Create Pull Request"
# Add description
# Click "Create Pull Request"
# Wait for review
```

#### 6. Code Review

- Teacher/maintainer reviews your code
- May request changes
- Update commits based on feedback
- Once approved, your code is merged!

---

## Commit Message Guidelines

### Good Commit Messages

```
✅ "Fix: Correct collision detection in game loop"
✅ "Feature: Add pause button to game"
✅ "Docs: Update API documentation"
✅ "Refactor: Simplify GameScore service"
```

### Bad Commit Messages

```
❌ "changes"
❌ "fixed stuff"
❌ "asdf"
❌ "update"
```

### Format

```
<type>: <short description>

<optional longer description>
<optional explanation of why>

Type can be:
- Feature: New functionality
- Fix: Bug fix
- Docs: Documentation changes
- Refactor: Code improvements
- Test: Test additions
- Style: Formatting changes
```

---

## GitHub Workflows for Your Class

### Setup 1: Teacher Repository (Your Setup)

```
GitHub: Your Teacher Account
  └─ trainerstacks-car-racing-game (Your repository)
     ├─ main (protected, only teacher merges)
     ├─ student1-feature-branch (student work)
     └─ student2-bugfix-branch (student work)
```

### Setup 2: GitHub Classroom (Recommended)

```
GitHub Classroom Assignment
  └─ For each student:
     └─ trainerstacks-car-racing-game (student copy)
        ├─ main branch
        └─ student's work
```

### Setup 3: Fork & Pull Request (Open Source Style)

```
Your Repository (Teacher)
  └─ trainerstacks-car-racing-game

Student's Fork (Student Account)
  └─ student-username/trainerstacks-car-racing-game
     └─ Pull Request → Teacher's Repository
```

---

## Protecting Main Branch

### Recommended Protection Rules

Go to **Settings** → **Branches** → **Add Rule**

```
Branch name: main

Rules:
☑ Require pull request reviews before merging
☑ Dismiss stale pull request approvals
☑ Require status checks to pass before merging
☑ Require branches to be up to date before merging
☑ Include administrators
```

This ensures:
- All changes go through review
- Main branch stays stable
- No accidental direct pushes

---

## Managing Student Submissions

### Using GitHub Classroom

1. Create assignment with this template
2. Students get individual repositories
3. Auto-detect when they push
4. You can grade directly
5. See commit history

### Using Pull Requests

1. Students work on branches
2. Create pull request to main
3. You review code
4. Provide feedback in comments
5. Approve and merge

### Using Issues

1. Create issues for assignments
2. Students assign to themselves
3. Link pull requests to issues
4. Track progress
5. Close issues when done

---

## Useful GitHub Features for Teaching

### 1. Project Board

```
Settings → Projects
Create board to track assignments
Columns: To Do, In Progress, In Review, Done
```

### 2. GitHub Pages

```
Settings → Pages
Deploy your repository documentation
Automatic hosting at: username.github.io/repo-name
```

### 3. Releases

```
Create releases for each assignment
Tag versions: v1.0, v1.1, etc.
Students can clone specific versions
```

### 4. Discussions

```
Enable discussions for Q&A
Students ask questions
Community discusses solutions
```

### 5. Wiki

```
Add wiki for documentation
Supplementary guides
Links to external resources
```

---

## Common GitHub Commands

```bash
# Setup
git config --global user.name "Your Name"
git config --global user.email "your@email.com"
git clone <repository-url>

# Check Status
git status
git log --oneline

# Stage and Commit
git add .
git add <filename>
git commit -m "message"

# Branches
git branch                    # List branches
git branch -a                # List all branches
git checkout -b new-branch   # Create new branch
git checkout main            # Switch to main
git merge feature-branch     # Merge branch into current

# Push and Pull
git push                     # Push to remote
git push origin branch-name  # Push specific branch
git pull                     # Pull from remote
git pull --rebase           # Pull and rebase

# Undo Changes
git reset HEAD~1            # Undo last commit
git revert <commit-hash>    # Revert specific commit
git checkout -- <filename>  # Discard changes in file

# Remote
git remote -v               # View remotes
git remote add origin <url> # Add remote
git remote remove origin    # Remove remote
```

---

## Troubleshooting GitHub

### Authentication Failed

**Problem:** `fatal: Authentication failed`

**Solution:**
```bash
# Use Personal Access Token instead of password
# GitHub → Settings → Developer settings → Personal access tokens
# Create new token with repo access
# Use token as password when prompted
```

### Permission Denied

**Problem:** `permission denied (publickey)`

**Solution:**
```bash
# Generate SSH key
ssh-keygen -t ed25519 -C "your@email.com"

# Add to GitHub
GitHub → Settings → SSH and GPG keys → New SSH key
```

### Merge Conflicts

**Problem:** Conflicts when pulling changes

**Solution:**
```bash
# Resolve conflicts manually
# Edit conflicting files
# Remove conflict markers: <<<<, ====, >>>>

git add .
git commit -m "Resolved merge conflicts"
git push
```

---

## Resources

- **GitHub Docs:** https://docs.github.com
- **GitHub Learning:** https://github.com/skills
- **Git Documentation:** https://git-scm.com/doc
- **GitHub Classroom:** https://classroom.github.com

---

## Summary

✅ Create GitHub repository
✅ Clone locally
✅ Push project files
✅ Share with students
✅ Manage contributions
✅ Protect main branch
✅ Review code
✅ Track progress

---

**You're ready to use GitHub for your classes! 🎉**
