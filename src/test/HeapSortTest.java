package test;

import org.junit.jupiter.api.Test;
import sortingalgorithms.HeapSort;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeapSortTest {

    @Test
    public void testSort() {
        HeapSort<Integer> heapSort = new HeapSort<>();

        List<Integer> items = Arrays.asList(1, 5, 6, 78, 12, 11, 10, 0, 3, 4, 34, 45, 2, 3);

        heapSort.sort(items);
        assertEquals(Integer.valueOf(0), items.get(0));
    }
}
