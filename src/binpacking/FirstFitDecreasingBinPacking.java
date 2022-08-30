package binpacking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FirstFitDecreasingBinPacking {
    private int binCapacity;
    private List<Bin> bins;
    private List<Integer> items;
    private int binCounter = 1;

    public FirstFitDecreasingBinPacking(int binCapacity, List<Integer> items) {
        this.binCapacity = binCapacity;
        this.items = items;
        this.bins = new ArrayList<>(items.size());
    }

    public void solve() {
        // first fit decreasing algorithm
        // Step 1: sort items into decreasing order
        Collections.sort(items, Collections.reverseOrder());

        // Step 2: Check if largest item can fit into bins
        if (this.items.get(0) > this.binCapacity) {
            System.out.println("No feasible solution...");
            return;
        }

        // create first bin and add it to the bins
        this.bins.add(new Bin(this.binCapacity, this.binCounter));


        for (Integer item : items) {
            boolean isOk = false;
            int currentBin = 0;

            while (!isOk) {
                // item does not fit in last bin - try new bin
                if (currentBin == this.bins.size()) {
                    this.binCounter++;
                    Bin newBin = new Bin(this.binCapacity, this.binCounter);
                    newBin.put(item);
                    bins.add(newBin);
                    isOk = true;
                } else if (bins.get(currentBin).put(item)) {
                    isOk = true;
                } else {
                    currentBin++;
                }
            }
        }
    }

    public void showResults() {
        for (Bin bin : bins) {
            System.out.println(bin);
        }
    }
}
