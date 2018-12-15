package sortingalgorithms;

import java.util.List;

public class SelectionSort<T extends Comparable<T>> extends BaseSort<T> {

    @Override
    public void sort(List<T> items) {
        super.sort(items);

        int size = items.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                T firstProductId = items.get(i);
                T iterationProductId = items.get(j);

                if (firstProductId.compareTo(iterationProductId) > 0) {
                    items.set(i, iterationProductId);
                    items.set(j, firstProductId);
                }
            }
        }
    }
}
