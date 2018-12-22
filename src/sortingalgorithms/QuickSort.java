package sortingalgorithms;

import java.util.List;

public class QuickSort<T extends Comparable<T>> extends BaseSort<T> {

    @Override
    public void sort(List<T> items) {
        super.sort(items);

        quicksort(items, 0, items.size() - 1);
    }

    private void quicksort(List<T> items, int low, int high) {
        int partition;

        if ((high - low) > 0) {
            partition = partition(items, low, high);
            quicksort(items, low, partition - 1);
            quicksort(items, partition + 1, high);
        }
    }

    private int partition(List<T> items, int low, int high) {
        int i, pivot, firsthigh;

        pivot = high;
        firsthigh = low;
        for (i = low; i < high; i++) {
            if (items.get(i).compareTo(items.get(pivot)) < 0) {
                swap(items, i, firsthigh);
                firsthigh++;
            }
        }

        swap(items, pivot, firsthigh);
        return firsthigh;
    }

    private void swap(List<T> items, int first, int second) {
        T item = items.get(first);
        items.set(first, items.get(second));
        items.set(second, item);
    }
}
