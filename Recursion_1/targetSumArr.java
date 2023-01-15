package Recursion_1;

import java.util.Scanner;

// Q 1. You are given a number n,representing the count of elements.
// 2. You are given n numbers.
// 3. You are given a number"target".
// 4. Complete the body of printTargetSumSubsets function-without changing 
// signature-to calculate and print all subsets of given elements,the contents of which sum to"tar".
// Use sample input and output to get more idea.

public class targetSumArr {// write reasons and notes why u doing what u doing the cases and base cases
    public static void main(String[] args) {

        // the input constrains says that the number could never be
        // less than zero But can be zero so we can never check our
        // base case as if the sum becomes the target ever because
        // there might be possiblities out in the array that the sum
        // could still be there with a zero or more in it.
        // so the base could only be that if ever our indexes run out in
        // the array
        // there will also be a negitive base case in the loop to check if
        // ever our sum becomes more than the
        Scanner sc = new Scanner(System.in);
        int ele = sc.nextInt();
        int tar = sc.nextInt();
        int arr[] = new int[ele];
        for (int i = 0; i < ele; i++) {
            arr[i] = sc.nextInt();
        }
        printTargetSumSubsets(arr, 0, ele, 0, tar, "", "");
    }

    public static void printTargetSumSubsets(int arr[], int idx, int n, int sumTar, int tar, String ansf,
            String index) {// The whole
        // Pattern of
        // the
        // question is CHOISES.
        // The Question is based on the choices of the numbers to get added in
        // the Target sum
        // We pass in the array in the method and the index to start off with to
        // calculate our Target sum.

        if (idx == n) {
            if (sumTar == tar) {
                System.out.println(ansf + " with index : " + index);
            }
            return;
        }
        // printTargetSumSubsets(arr, idx + 1, n, sumTar, tar); WRONG APPROCH
        // sumTar = sumTar + arr[idx];
        // printTargetSumSubsets(arr, idx + 1, n, sumTar, tar);

        // CORRECTION

        printTargetSumSubsets(arr, idx + 1, n, sumTar + arr[idx], tar, ansf + arr[idx] + " ", index + idx + " ");
        printTargetSumSubsets(arr, idx + 1, n, sumTar, tar, ansf, index);

    }
}
