package sortingalgorithms;

import pojos.BlackFridayPojo;

import java.util.List;

public class InsertionSort {

    public void sort(List<BlackFridayPojo> items) {
        for (int i = 1; i < 10; i++) {
            int j = i;
            while (j > 0 && items.get(j-1).getProductId().compareTo(items.get(j).getProductId()) > 0) {
                String productId = items.get(j).getProductId();
                items.get(j).setProductId(items.get(j-1).getProductId());
                items.get(j-1).setProductId(productId);
                j--;
            }
        }
    }
}
