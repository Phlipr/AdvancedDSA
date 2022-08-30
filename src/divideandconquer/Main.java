package divideandconquer;

public class Main {

    public static void main(String[] args) {
        int[] array = {2, 3, 4, 1, -1, 1};

        MergeSortDesc mergeArray = new MergeSortDesc(array);
        mergeArray.sort();
        mergeArray.showSortedArray();
    }
}
