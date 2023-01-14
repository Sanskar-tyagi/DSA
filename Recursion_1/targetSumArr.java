package Recursion_1;

import java.util.Scanner;

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
        int arr[] = new int[ele];
        for (int i = 0; i < ele - 1; i++) {

        }
    }
}
