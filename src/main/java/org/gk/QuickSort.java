package org.gk;

public class QuickSort<T extends Comparable<? super T>> {
    public void quicksort(T[] array, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(array, start, end);
            quicksort(array, start, pivotIndex);
            quicksort(array, pivotIndex + 1, end);
        }
    }

    private int partition(T[] array, int start, int end) {
        int pivotIndex = (start + end) / 2;
        T pivotValue = array[pivotIndex];
        start--;
        end++;

        while (true) {
            do start++; while (array[start].compareTo(pivotValue) < 0);
            do end--; while (array[end].compareTo(pivotValue) > 0);
            if (start >= end) return end;
            T tmp = array[start];
            array[start] = array[end];
            array[end] = tmp;
        }
    }
}