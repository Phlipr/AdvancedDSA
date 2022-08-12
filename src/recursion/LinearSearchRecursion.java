package recursion;

import java.util.Arrays;

public class LinearSearchRecursion {
    public static int linearSearchRecursion(int[] container, int search, int index) {
        if (index >= container.length) return -1;

        if (container[index] == search) return index;

        return linearSearchRecursion(container, search, index + 1);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};

        System.out.println();
        System.out.println("Array: " + Arrays.toString(array));
        System.out.println();

        System.out.println("The value 5 is at the index of " + linearSearchRecursion(array, 5, 0));
        System.out.println("The value 3 is at the index of " + linearSearchRecursion(array, 3, 0));
        System.out.println("The value 8 is at the index of " + linearSearchRecursion(array, 8, 0));
    }
}
