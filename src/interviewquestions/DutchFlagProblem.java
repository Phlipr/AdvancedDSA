package interviewquestions;

import java.util.Arrays;

public class DutchFlagProblem {
    private int[] arrayToSort;
    private int pivot;

    public DutchFlagProblem(int[] arrayToSort, int pivot) {
        this.arrayToSort = arrayToSort;
        this.pivot = pivot;
    }

    public void solveProblem() {
        int low = 0;
        int idx = 0;
        int high = this.arrayToSort.length - 1;

        while (idx <= high) {
            // if value at idx is greater than pivot
            //  must move value to high and decrement high
            if (this.arrayToSort[idx] > this.pivot) {
                swap(idx, high);
                high--;
            // if value at idx is less than pivot
            //  must move value to low idx and increment both
            //  low and idx values
            } else if (this.arrayToSort[idx] < this.pivot) {
                swap(idx, low);
                idx++;
                low++;
            // if value is equal to pivot
            //  just increment idx
            } else {
                idx++;
            }
        }

        this.showSolution();
    }

    private void swap(int source, int dest) {
        int temp = this.arrayToSort[source];
        this.arrayToSort[source] = this.arrayToSort[dest];
        this.arrayToSort[dest] = temp;
    }

    private void showSolution() {
        System.out.println(Arrays.toString(this.arrayToSort));
    }
}
