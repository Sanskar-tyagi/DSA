package Array.Algo.DivideNcon;

public class QuickSort {

    public void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            // Invalid range or 1 element array
            return;
        }

        int mid = (lo + hi) / 2;
        swap(arr, mid, hi);
        int pivot = arr[hi];
        // Partition the array around the pivot
        int pidx = partition(arr, pivot, lo, hi);

        // Recursively sort left and right subarrays
        quickSort(arr, lo, pidx - 1);
        quickSort(arr, pidx + 1, hi);
    }

    public int partition(int[] arr, int pivot, int lo, int hi) {
        int i = lo, j = lo;
        while (j <= hi) {
            if (arr[j] <= pivot) {
                swap(arr, j, i);
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i - 1;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
