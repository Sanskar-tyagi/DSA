package Array.Algo.DivideNcon;

import java.util.*;;

public class MergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter N");
        int n = sc.nextInt();
        System.out.println("Enter M");
        int m = sc.nextInt();
        int arr[] = new int[n];
        int nums[] = new int[m];
        System.out.println("Enter Arr 1");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter nums");
        for (int j = 0; j < m; j++) {
            nums[j] = sc.nextInt();
        }
        display(arr);
        display(nums);
        Arrays.sort(arr);
        Arrays.sort(nums);
        int ans[] = MergeArr(arr, nums);
        display(ans);
    }

    static void display(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "   ");
        }
        System.out.println();
    }

    static int[] MergeArr(int[] nums1, int[] nums2) {
        int p1 = 0;
        int p2 = 0;
        int idx = 0;
        int[] ans = new int[nums1.length + nums2.length];
        while (idx < ans.length) {
            int val1 = p1 < nums1.length ? nums1[p1] : Integer.MAX_VALUE;
            int val2 = p2 < nums2.length ? nums2[p2] : Integer.MAX_VALUE;
            if (val1 < val2) {
                ans[idx] = val1;
                p1++;
            } else {
                ans[idx] = val2;
                p2++;
            }
            idx++;
        }
        return ans;
    }

    static int[] sort(int arr[], int l, int r) {
        if (l == r) {
            int base[] = new int[1];
            base[0] = arr[l];
            return base;
        }
        int mid = l + r / 2;
        int left[] = sort(arr, l, mid);
        int right[] = sort(arr, mid + 1, r);
        return MergeArr(left, right);
    }
}
