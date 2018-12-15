package sortingalgorithms;

import pojos.BlackFridayPojo;

import java.util.List;

public class SelectionSort extends BaseSort {

    @Override
    public void sort(List<BlackFridayPojo> items) {
        super.sort(items);

        int size = items.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                String firstProductId = items.get(i).getProductId();
                String iterationProductId = items.get(j).getProductId();

                if (firstProductId.compareTo(iterationProductId) > 0) {
                    items.get(i).setProductId(iterationProductId);
                    items.get(j).setProductId(firstProductId);
                }
            }
        }
    }
}
