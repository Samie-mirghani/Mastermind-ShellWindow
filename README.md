# Mastermind — Shell Window Edition

A classic code-breaking logic game implemented in Java, where players deduce a randomly generated secret color pattern through iterative guessing and structured feedback.

---

## Overview

Mastermind is a strategic deduction game that challenges players to crack a hidden four-peg color code within a limited number of attempts. The program randomly generates a secret pattern from six possible colors and provides two distinct feedback metrics after each guess — **pattern-correct** (right color in the right position) and **color-correct** (right color in the wrong position) — enabling players to systematically narrow down the solution.

This shell-based implementation delivers the full Mastermind experience through an interactive command-line interface, making it lightweight, portable, and easy to run on any system with a Java runtime.

## Key Features

- **Randomized Secret Code Generation** — Each game produces a unique four-peg pattern from six colors, ensuring high replayability across 1,296 possible combinations.
- **Dual-Metric Feedback System** — Distinguishes between exact positional matches and correct-color-wrong-position matches, mirroring the classic Mastermind scoring rules.
- **Input Validation** — Enforces a strict four-character guess format, prompting re-entry on invalid input to maintain game integrity.
- **Configurable Attempt Limit** — Players have up to 10 attempts to deduce the code, balancing challenge and accessibility.
- **Modular Architecture** — Separates game orchestration (`MasterMind`) from pattern logic (`SecretPattern`), following single-responsibility design principles.
- **Six-Color Palette** — Supports Red (R), Green (G), Blue (B), Cyan (C), Yellow (Y), and Magenta (M) for a rich set of possible patterns.

## Tech Stack

| Component       | Technology       |
|-----------------|------------------|
| Language        | Java             |
| Runtime         | JDK 8+           |
| I/O             | `java.util.Scanner` (stdin/stdout) |
| Randomization   | `java.util.Random` |
| Build           | Direct `javac` compilation |

## System Architecture

```
┌─────────────────────────────────────────────┐
│                MasterMind                    │
│  (Game Loop & User Interaction)             │
│                                             │
│  1. Initialize Scanner & generate secret    │
│  2. Prompt user for 4-character guess       │
│  3. Validate input length                   │
│  4. Delegate scoring to SecretPattern       │
│  5. Display feedback & repeat or end game   │
└──────────────────┬──────────────────────────┘
                   │ creates / queries
                   ▼
┌─────────────────────────────────────────────┐
│              SecretPattern                   │
│  (Code Generation & Evaluation Engine)      │
│                                             │
│  • generateSecretCode() — random 4-peg code │
│  • countPattern()       — exact matches     │
│  • countColors()        — color-only matches│
│  • intToColour()        — maps int → color  │
└─────────────────────────────────────────────┘
```

## Setup & Installation

### Prerequisites

- **Java Development Kit (JDK) 8** or later installed on your system.
- Verify with: `java -version` and `javac -version`.

### Build & Run

```bash
# Clone the repository
git clone https://github.com/samie-mirghani/mastermind-shellwindow.git
cd mastermind-shellwindow

# Compile
javac MasterMind.java SecretPattern.java

# Run
java MasterMind
```

### Gameplay

1. The program displays a welcome message and color legend.
2. Enter a 4-letter guess using the color codes: **R**, **B**, **G**, **Y**, **C**, **M**.
3. After each guess, the program reports:
   - **Colors correct** — how many guessed colors appear in the secret code but in a different position.
   - **Pattern correct** — how many guessed colors are in the exact correct position.
4. Use the feedback to refine your next guess.
5. Crack the code within **10 attempts** to win!

### Example Session

```
Welcome to MasterMind!
Enter a string consisting of 4 letters, which can be
R (Red), B (Blue), G (Green), Y (Yellow), C (Cyan) or M (Magenta).
Enjoy!

Enter your guess: RGBY
Colors correct: 1; Pattern correct: 2

Enter your guess: RGCY
Colors correct: 0; Pattern correct: 3

Enter your guess: RGCM
Colors correct: 0; Pattern correct: 4
You Won! Congratulations
```

## License

This project is available for educational and personal use.

---

<p align="center">Built with Java — A classic logic game for the command line.</p>
