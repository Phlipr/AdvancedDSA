package divideandconquer;

import java.util.Arrays;

public class MergeSortDesc {
    private int[] arrayToSort;
    private int[] tempArray;

    public MergeSortDesc(int[] arrayToSort) {
        this.arrayToSort = arrayToSort;
        this.tempArray = new int[arrayToSort.length];
    }

    public void showSortedArray() {
        System.out.println("Sorted array = " + Arrays.toString(this.arrayToSort));
    }

    private void merge(int low, int middle, int high) {
        // make a copy of the arrayToSort
        for (int c = low; c <= high; c++) {
            this.tempArray[c] = this.arrayToSort[c];
        }

        // merge subarrays
        int i = low;
        int j = middle + 1;
        int k = low;

        while (i <= middle && j <= high) {
            if (this.tempArray[i] >= this.tempArray[j]) {
                this.arrayToSort[k] = this.tempArray[i];
                i++;
            } else {
                this.arrayToSort[k] = this.tempArray[j];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            this.arrayToSort[k] = this.tempArray[i];
            i++;
            k++;
        }

        while (j <= high) {
            this.arrayToSort[k] = this.tempArray[j];
            j++;
            k++;
        }
    }

    private void mergeSort(int low, int high) {
        if (low >= high) return;

        int middle = (low + high) / 2;

        mergeSort(low, middle);
        mergeSort(middle + 1, high);

        merge(low, middle, high);
    }

    public void sort() {
        this.mergeSort(0, this.arrayToSort.length-1);
    }
}
