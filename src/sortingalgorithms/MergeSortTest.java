package sortingalgorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MergeSortTest {

    private MergeSort<Integer> mergeSort;

    @BeforeEach
    public void setup() {
        mergeSort = new MergeSort<>();
    }

    @Test
    void sort() {
        List<Integer> items = new ArrayList<>();
        items.add(5);
        items.add(1);
        items.add(7);

        mergeSort.sort(items);
        assertEquals(Integer.valueOf(1), items.get(0));
    }
}