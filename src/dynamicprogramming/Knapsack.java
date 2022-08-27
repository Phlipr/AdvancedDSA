package dynamicprogramming;

public class Knapsack {
    public static int solveKnapsack(int[] weights, int[] values, int capacity) {
        return considerSolution(capacity, weights, values, weights.length-1);
    }

    private static int considerSolution(int m, int[] w, int[] v, int n) {
        // base cases
        if (n < 0) return 0; // no items to put in knapsack
        if (m == 0) return 0; // knapsack does not have any more room

        // consider options
        // Option 1: the knapsack can hold the next item, so we include it
        int currWeight = w[n];
        int valueWithItem = 0, valueWithoutItem = 0;

        if (currWeight <= m) {
            valueWithItem = v[n] + considerSolution(m - currWeight, w, v, n - 1);
        }

        // Option 2: do not include item in knapsack
        valueWithoutItem = considerSolution(m, w, v, n - 1);

        // return max value from options
        int maxValue = Math.max(valueWithItem, valueWithoutItem);

        return maxValue;
    }

    public static void main(String[] args) {
        int capacity = 7;
        int[] weights = {1, 3, 4, 5};
        int[] values = {1, 4, 5, 7};

        int maxValue = solveKnapsack(weights, values, capacity);

        System.out.println("Maxvalue = " + maxValue);
    }
}
