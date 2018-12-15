package sortingalgorithms;

import java.util.List;

public class InsertionSort<T extends Comparable<T>> extends BaseSort<T> {

    @Override
    public void sort(List<T> items) {
        super.sort(items);

        for (int i = 1; i < items.size(); i++) {
            int j = i;
            while (j > 0 && items.get(j - 1).compareTo(items.get(j)) > 0) {
                T product = items.get(j);
                items.set(j, items.get(j - 1));
                items.set(j - 1, product);
                j--;
            }
        }
    }
}
