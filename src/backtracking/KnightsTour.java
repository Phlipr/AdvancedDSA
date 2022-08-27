package backtracking;

public class KnightsTour {
    private int boardSize;
    private int[][] tour;
    private final int[] movesX = {2, 1, 2, 1, -2, -1, -2, -1};
    private final int[] movesY = {1, 2, -1, -2, 1, 2, -1, -2};

    public KnightsTour(int boardSize) {
        this.boardSize = boardSize;
        this.tour = new int[boardSize][boardSize];
    }

    public void solve() {
        this.tour[0][0] = 1;
        if (solveProblem(2, 0, 0)) {
            this.showSolution();
        } else {
            System.out.println("There is no solution for this size of board starting at top, left corner of board.");
        }
    }

    private boolean solveProblem(int step, int rank, int file) {
        // base case: position is equal to the total number of squares on the board, which is boardSize x boardSize
        if (step == (boardSize * boardSize + 1)) {
            return true;
        }

        int newRank, newFile;

        // iterate through all possible moves to check the next move in the tour
        for (int move = 0; move < movesX.length; move++) {
            newRank = rank + movesY[move];
            newFile = file + movesX[move];
            if (isMoveValid(newRank, newFile)) {
                this.tour[newRank][newFile] = step;

                if (solveProblem(step + 1, newRank, newFile)) {
                    return true;
                }

                // backtrack
                this.tour[newRank][newFile] = 0;
            }
        }

        return false;
    }

    private boolean isMoveValid(int rank, int file) {
        // move is valid if it is:
        // 1. on the board
        if (rank < 0 || file < 0 || rank >= boardSize || file >= boardSize) {
            return false;
        }

        // 2. the square has not been visited yet
        if (this.tour[rank][file] != 0) {
            return false;
        }

        return true;
    }

    private void showSolution() {
        for (int row = 0; row < boardSize; row++) {
            for (int column = 0; column < boardSize; column++) {
                System.out.print(this.tour[row][column] + " ");
            }
            System.out.println();
        }
    }
}
