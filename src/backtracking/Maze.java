package backtracking;

public class Maze {
    private int mazeSize;
    private int[][] maze; // 0 = blocked squares; 1 = open squares
    private int[][] solution; // goal = reach bottom right (can only move right and down); start = top left corner

    public Maze(int[][] maze) {
        this.mazeSize = maze[0].length;
        this.maze = maze;
        this.solution = new int[mazeSize][mazeSize];
    }

    public void solve() {
        this.solution[0][0] = 1;

        if (solveProblem(0, 0)) {
            this.showSolution();
        } else {
            System.out.println("There is no valid path to reach the goal for this maze.");
        }
    }

    private boolean solveProblem(int row, int column) {
        // base-case: the bottom-right corner has been reached
        if (row == mazeSize - 1  && column == mazeSize - 1) {
            return true;
        }

        // try going to the right
        if (this.isValidMove(row, column + 1)) {
            this.solution[row][column + 1] = 1;

            if (solveProblem(row, column + 1)) {
                return true;
            }

            this.solution[row][column + 1] = 0;
        }

        // try going down
        if (this.isValidMove(row + 1, column)) {
            this.solution[row+1][column] = 1;

            if (solveProblem(row+1, column)) {
                return true;
            }

            this.solution[row+1][column] = 0;
        }

        return false;
    }

    private boolean isValidMove(int row, int column) {
        // move will be valid if:
        // 1. it is not off the board
        if (row >= mazeSize || column >= mazeSize) {
            return false;
        }

        // 2. it is not blocked
        if (this.maze[row][column] != 1) {
            return false;
        }


        return true;
    }

    private void showSolution() {
        for (int row = 0; row < mazeSize; row++) {
            for (int column = 0; column < mazeSize; column++) {
                System.out.print(this.solution[row][column] == 1 ? "S  " : "-  ");
            }
            System.out.println();
        }
    }
}
