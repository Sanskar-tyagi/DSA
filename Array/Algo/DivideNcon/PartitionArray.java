package Array.Algo.DivideNcon;

public class PartitionArray {
    // part the given array into smaller and larger numbers at K pivot

    public static void main(String[] args) {

    }

    static void Lnc(int arr[], int k) {
        int i = 0;
        int j = 0;
        while (j != arr.length || i != arr.length) {
            if (arr[i] <= k) {
                swap(arr, i, j);
                i++;
                j++;
            } else {
                j++;
            }
        }

    }

    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
}
