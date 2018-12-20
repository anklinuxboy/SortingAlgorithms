package sortingalgorithms;

import java.util.ArrayList;
import java.util.List;

public class MergeSort<T extends Comparable<T>> extends BaseSort<T> {

    private List<T> items;
    private List<T> buffer;

    @Override
    public void sort(List<T> items) {
        super.sort(items);
        this.items = items;
        int size = items.size();
        this.buffer = new ArrayList<>(size);

        int low = 0;
        int high = size - 1;
        mergesort(low, high);
    }

    private void mergesort(int low, int high) {
        int middle;

        if (low < high) {
            middle = low + (high - low) / 2;   // to prevent buffer overflow
            mergesort(low, middle);
            mergesort(middle + 1, high);
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {
        int i, j, k;
        for (i = low; i <= high; i++) {
            buffer.add(i, items.get(i));
        }

        i = low;
        j = middle + 1;
        k = low;

        while (i <= middle && j <= high) {
            if (buffer.get(i).compareTo(buffer.get(j)) <= 0) {
                items.set(k, buffer.get(i));
                i++;
            } else {
                items.set(k, buffer.get(j));
                j++;
            }
            k++;
        }

        while (i <= middle) {
            items.set(k, buffer.get(i));
            k++;
            i++;
        }
    }
}
