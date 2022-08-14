package backtracking;

public class NQueens {

    private int numOfQueens;

    private int[][] board;

    public NQueens(int numOfQueens) {
        this.numOfQueens = numOfQueens;
        this.board = new int[numOfQueens][numOfQueens];
    }

    public void solve() {
        if (solveProblem(0)) {
            this.showSolution();
        } else {
            System.out.printf("There is no solution for placing %d queens on a %d x %d board.", this.numOfQueens, this.numOfQueens, this.numOfQueens);
        }
    }

    private boolean solveProblem(int columnIndex) {
        for (int row = 0; row < this.numOfQueens; row++) {
            // base case: placed a queen in all columns on the board
            if (columnIndex == this.numOfQueens) {
                return true;
            }

            // check if it is possible to place a queen in current position
            if (isValidPosition(row, columnIndex)) {
                this.board[row][columnIndex] = 1;
                if (solveProblem(columnIndex +1 )) {
                    return true;
                };
            }

            // backtrack
            this.board[row][columnIndex] = 0;
        }
        // no valid solutions
        return false;
    }

    private boolean isValidPosition(int rowIndex, int columnIndex) {
        // three ways that position is not valid:
        // 1. another queen in the same row
        for (int column = 0; column < columnIndex; column++) {
            if (this.board[rowIndex][column] == 1) {
                return false;
            }
        }

        // 2. another queen in the same column
        // no need to test this scenario since we are only placing
        // one queen per column

        // 3. another queen in the diagonal
        for (int offset = columnIndex; offset >= 0; offset--) {
            int topLeftRow = rowIndex - offset;
            int bottomLeftRow = rowIndex + offset;
            int newColumn = columnIndex - offset;

            if (newColumn < 0) {
                continue;
            }

            if ((topLeftRow >= 0 && this.board[topLeftRow][newColumn] == 1) || (bottomLeftRow < numOfQueens && this.board[bottomLeftRow][newColumn] == 1)) {
                return false;
            }
        }

        // no need to check top-right or bottom-right diagonals since
        // no queens have been placed in the columns to the right yet

        // if these three criteria are not true, position is valid
        return true;
    }

    private void showSolution() {
        for (int row = 0; row < this.numOfQueens; row++) {
            for (int column = 0; column < this.numOfQueens; column++) {
                System.out.print(this.board[row][column] == 1 ? "* " : "- ");
            }
            System.out.println();
        }
    }
}
