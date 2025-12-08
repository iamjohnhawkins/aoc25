# Advent of Code 2025 - Kotlin Solutions

A Kotlin/Gradle project template for solving Advent of Code challenges using test-first and functional programming methodologies.

## Project Structure

```
aoc25/
├── src/
│   ├── main/
│   │   ├── kotlin/com/aoc/
│   │   │   ├── Main.kt              # Runner for all days
│   │   │   └── days/
│   │   │       ├── Day.kt           # Interface for daily challenges
│   │   │       └── Day01.kt         # Example: Day 1 solution
│   │   └── resources/inputs/
│   │       └── day01.txt            # Input data for Day 1
│   └── test/
│       └── kotlin/com/aoc/days/
│           └── Day01Test.kt         # Unit tests for Day 1
├── build.gradle.kts
└── settings.gradle.kts
```

## Features

- **Test-First Approach**: Comprehensive unit tests for each solution
- **Functional Programming**: Pure functions, immutability, and declarative transformations
- **Reusable Interface**: Simple `Day` interface for consistent solution structure
- **Organized Inputs**: Separate resource files for puzzle inputs

## Running Tests

```bash
./gradlew test
```

## Running Solutions

```bash
./gradlew run
```

## Adding a New Day

1. Create `src/main/kotlin/com/aoc/days/DayXX.kt` implementing the `Day` interface
2. Create `src/test/kotlin/com/aoc/days/DayXXTest.kt` with your tests
3. Add input data to `src/main/resources/inputs/dayXX.txt`
4. Register the day in `Main.kt`

## Example Solution (Day 1)

The sample implements the "Sonar Sweep" challenge:
- **Part 1**: Count measurements larger than the previous one
- **Part 2**: Count sliding window sums that increase

Both solutions use functional approaches with `windowed()`, `map()`, and `count()`.
