package Array.Algo;

import java.util.*;

class kadane {

    public static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(findMax(arr));
    }

    public static int findMax(int arr[]) {
        // O(N^3) Approach
        // int max=0;
        // for(int i=0;i<n;i++){
        // for(int j=0;j<i;j++){
        // int sum=0;
        // for(k=i;k<j;k++){
        // sum = sum + arr[k]
        // }
        // if(sum > max)
        // max = sum;
        // }
        // }

        // Kadane's Approach
        int sum = 0;
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (max < sum) {// check if the sum is greater
                max = sum;
            }
            if (sum < 0) {// if ever our sum is ever less than 0, we wont be adding it to the maximum
                          // because we want it to be max
                sum = 0;
            }
        }
        return max;
    }
}
