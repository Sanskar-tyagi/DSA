package Array.Algo.DivideNcon;

public class QuickSort {

    public static void quickSort(int arr[], int lo, int hi) {
        // if(lo > hi) return; // invalid range
        // if(hi == lo) return; // because 1 ele array is always sorted

        int pivot = arr[hi];
        int pidx = getPivotIndexAfterPartition(arr, pivot, lo, hi);

        if (lo < pidx - 1)
            quickSort(arr, lo, pidx - 1);
        if (pidx + 1 < hi)
            quickSort(arr, pidx + 1, hi);
    }

    public static int getPivotIndexAfterPartition(int[] arr, int pivot, int lo, int hi) {
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

    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
