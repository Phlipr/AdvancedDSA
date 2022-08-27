package dynamicprogramming;

import java.util.Arrays;

public class SubsetSum {
    private int sum;
    private int[] values;
    private boolean[][] solutions;

    public SubsetSum(int sum, int[] values) {
        this.sum = sum;
        this.values = values;

        // initialize table with initial values
        this.solutions = new boolean[values.length + 1][sum + 1];
        // rows = number of values to include
        // columns = possible sums
        // first row should be false since if no values included, cannot
        // reach any sums (already initialized

        // first column (trying to reach sum of 0) is always true regardless of which values to consider
        for (int i = 0; i < values.length; i++) {
            this.solutions[i][0] = true;
        }
    }

    public void findSolution() {
        for (int valueIdx = 1; valueIdx < this.values.length + 1; valueIdx++) {
            for (int currSum = 1; currSum < sum + 1; currSum++) {
                if (currSum < this.values[valueIdx - 1]) {
                    this.solutions[valueIdx][currSum] = this.solutions[valueIdx - 1][currSum];
                } else {
                    if (this.solutions[valueIdx - 1][currSum]) {
                        this.solutions[valueIdx][currSum] = this.solutions[valueIdx - 1][currSum];
                    } else {
                        this.solutions[valueIdx][currSum] = this.solutions[valueIdx - 1][currSum - this.values[valueIdx - 1]];
                    }
                }
            }
        }
    }

    public void showSolution() {
        System.out.println("It is " + (this.solutions[this.values.length][this.sum] ? "possible" : "not possible")
                                    + " to obtain the sum "
                                    + this.sum + " given values of "
                                    + Arrays.toString(this.values));
        if (!this.solutions[this.values.length][this.sum]) return;

        int currValue = this.values.length;
        int currSum = this.sum;

        while (currValue > 0 || currSum > 0) {
            if (this.solutions[currValue][currSum] != this.solutions[currValue - 1][currSum]) {
                System.out.println("Include value " + this.values[currValue - 1]);
                currSum -= this.values[currValue - 1];
            }
            currValue--;
        }
    }

    public static void main(String[] args) {
        int sum = 14;
        int[] values = {5, 3, 1, 2, 3, 1, 5};

        SubsetSum subsetSum = new SubsetSum(sum, values);
        subsetSum.findSolution();
        subsetSum.showSolution();
    }
}
