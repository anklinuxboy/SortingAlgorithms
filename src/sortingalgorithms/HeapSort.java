package sortingalgorithms;

import java.util.List;

public class HeapSort<T extends Comparable<T>> extends BaseSort<T> {

    @Override
    public void sort(List<T> items) {
        super.sort(items);

        Heap<T> heap = new Heap<>();
        heap.buildHeap(items);

        for (int i = 0; i < items.size(); i++) {
            T item = heap.extractMin();
            if (item != null) {
                items.set(i, item);
            }
        }
    }
}
