package sortingalgorithms;

import java.util.ArrayList;
import java.util.List;

class Heap<T extends Comparable<T>> {

    private PriorityQueue priorityQueue;

    Heap() {
        priorityQueue = new PriorityQueue();
        priorityQueue.items = new ArrayList<>();
        priorityQueue.nodes = 0;
    }

    private class PriorityQueue {
        List<T> items;
        int nodes;
    }

    void buildHeap(List<T> items) {
        priorityQueue.items = new ArrayList<>(items.size() + 1);
        priorityQueue.items.add(0, items.get(0));

        for (T item : items) {
            insert(item);
        }
    }

    T extractMin() {
        T min;

        if (priorityQueue.nodes <= 0) {
            return null;
        } else {
            min = priorityQueue.items.get(1);
            priorityQueue.nodes -= 1;
            bubbleDown(1);
        }

        return min;
    }

    private void insert(T item) {
        priorityQueue.nodes += 1;
        priorityQueue.items.add(priorityQueue.nodes, item);
        bubbleUp(priorityQueue.nodes);
    }

    private void bubbleUp(int position) {
        if (parentIndex(position) == -1) return;

        if (priorityQueue.items.get(parentIndex(position)).compareTo(priorityQueue.items.get(position)) > 0) {
            swap(position, parentIndex(position));
            bubbleUp(parentIndex(position));
        }
    }

    private void swap(int position, int parentIndex) {
        T item = priorityQueue.items.get(position);
        priorityQueue.items.set(position, priorityQueue.items.get(parentIndex));
        priorityQueue.items.set(parentIndex, item);
    }

    private void bubbleDown(int position) {
        int c;
        int i;
        int minIndex;

        c = leftChildIndex(position);
        minIndex = position;

        for (i = 0; i <= 1; i++) {
            if ((c + i) < priorityQueue.nodes) {
                if (priorityQueue.items.get(minIndex).compareTo(priorityQueue.items.get(c + i)) > 0) {
                    minIndex = c + i;
                }
            }
        }

        if (minIndex != position) {
            swap(position, minIndex);
            bubbleDown(minIndex);
        }
    }

    private int parentIndex(int n) {
        if (n == 1) return -1;
        else return n / 2;
    }

    private int leftChildIndex(int n) {
        return 2 * n;
    }

    private int rightChildIndex(int n) {
        return 2 * n + 1;
    }
}
