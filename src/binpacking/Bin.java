package binpacking;

import java.util.ArrayList;
import java.util.List;

public class Bin {
    // a unique id
    private int id;

    // the volume of items the bin can hold
    private int capacity;

    // the volume of items the bin currently has in it
    private int actualSize;

    // a list of the items currently in the bin
    // the int represents the volume of the item
    List<Integer> items;

    public Bin(int capacity, int id) {
        this.capacity = capacity;
        this.id = id;
        this.items = new ArrayList<>();
    }

    public boolean put(Integer item) {
        if (this.actualSize + item > this.capacity) {
            return false;
        }

        this.items.add(item);
        this.actualSize += item;

        return true;
    }

    @Override
    public String toString() {
        String contentsOfBin = "Items contained in bin #" + this.id + ": ";

        for (Integer item : items) {
            contentsOfBin += (item + " ");
        }

        return contentsOfBin;
    }
}
