# Word Hunt Solver

Word Hunt Solver is a Java-based application designed to solve word hunt puzzles of any grid dimension. The application uses a Trie data structure for efficient word searching and can handle grids of varying sizes, from 2x2 to larger grids like 5x5 or 6x6.

## Features

- **Flexible Grid Handling**: Supports square grids of any dimension (e.g., 2x2, 3x3, ..., nxn).
- **Efficient Word Search**: Uses a Trie data structure to quickly find valid words.
- **Customizable Word List**: Easily update the word list by modifying the `wordlist.txt` file.
- **Top 100 Longest Words**: Outputs the top 100 longest words found in the grid, however this can be easily changed in the `Main.java` file.
- **Console-Based Interface**: Simple CLI interface for easy use.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Git (for cloning the repository)

### Installation

1. **Clone the repository**:
    ```sh
    git clone https://github.com/gfranklin1/WordHunt-Solver.git
    cd WordHunt-Solver
    ```

2. **Compile the project**:
    ```sh
    javac -d bin src/WordHuntSolver/*.java
    ```

3. **Run the application**:
    ```sh
    java -cp bin WordHuntSolver.Main
    ```

## Usage

1. **Enter the letters for the grid**:
    - The application will prompt you to enter the letters for the grid. Enter the letters as a single string without spaces.
    - Example for a 4x4 grid: `oatrihpshtnrenei`

2. **View the results**:
    - The application will print the top 100 longest words found in the grid.

### Example

```diff
Enter letters for the grid:
> oatrihpshtnrenei

4x4 Board:
o a t r 
i h p s 
h t n r 
e n e i 

Top 100 longest words:
TENNERS
PTERINS
HENNERS
HAPTENS
...
```

### Customizing the Word List
The default word list is located in `src/resources/wordlist.txt`. You can modify this file to include your own list of words. Each word should be on a new line.
