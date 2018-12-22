package test;

import org.junit.jupiter.api.Test;
import sortingalgorithms.QuickSort;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuickSortTest {

    @Test
    public void testSort() {
        QuickSort<Integer> quickSort = new QuickSort<>();

        List<Integer> items = Arrays.asList(1, 5, 6, 78, 12, 11, 10, 0, 3, 4, 34, 45, 2, 3);

        quickSort.sort(items);
        assertEquals(Integer.valueOf(0), items.get(0));
        assertEquals(Integer.valueOf(78), items.get(items.size() - 1));
    }
}
