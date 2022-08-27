package dynamicprogramming;

public class KadaneAlgorithm {

    public static int findMaxSumOfSubArray(int[] array) {
        int localMax = 0;
        int globalMax = 0;

        for (int i = 0; i < array.length; i++) {
            localMax = Math.max(array[i], localMax + array[i]);

            if (localMax > globalMax) {
                globalMax = localMax;
            }
        }

        return globalMax;
    }

    public static void main(String[] args) {
        int[] array = {11, 2, 3, -2, -30, 4, 10};

        System.out.println(findMaxSumOfSubArray(array));
    }
}
