package binpacking;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> items = Arrays.asList(3, 2, 4);
        int binCapacity = 10;

        FirstFitDecreasingBinPacking binPacking = new FirstFitDecreasingBinPacking(binCapacity, items);
        binPacking.solve();
        binPacking.showResults();
    }
}
