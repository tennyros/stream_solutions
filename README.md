# Useful Tasks Using Stream API in Java

[English](README.md) | [Русский](README_RUS.md)

## Description

This project contains solutions to various tasks related to using the **Stream API** in the Java programming language. Each solution is presented as a separate class that solves one task using a functional approach. The tasks involve processing data collections, such as lists of employees, departments, salaries, and other objects.

The project focuses on solving real-world problems using Stream API features like filtering, grouping, aggregation, sorting, and other functional operations.

## Project Structure

The project consists of two main parts:

1. **Core Task Solutions** — The code implementing each task's solution is located in the `src/main/java/com/github/tennyros/solutions/stream_api/grouping/` directory. Each task is represented by a separate class.
2. **Tests** — Unit tests for each task are located in the `src/test/java/` directory. The tests verify the correctness of the task solutions.

### Directories

- **grouping** — Solved tasks (e.g., calculating salaries, grouping employees, etc.).
- **util** — Helper classes, such as `Employee.java`, which contain data structures used in the tasks.

## Installation and Setup

1. Clone the repository:

    ```bash
    git clone https://github.com/yourusername/solutions.git
    ```

2. Navigate to the project directory:

    ```bash
    cd solutions
    ```

3. Import the project into your IDE (e.g., IntelliJ IDEA).

4. You will need Java 8+ to work with the project.

## Testing

The project uses JUnit 5 for testing. Tests are located in the `src/test/java/` folder, and each task class has its own test. To run the tests, use the command:

   ```bash
   ./gradlew test
   ```

or run them through your IDE (e.g., IntelliJ IDEA).
