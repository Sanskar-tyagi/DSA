package Recursion_1;

import java.util.*;

public class printZizZag {
    // ? Q 1. Here are a few sets of inputs and outputs for your reference
    // ? Input1 -> 1
    // ? Output1 -> 1 1 1

    // ? Input2 -> 2
    // ? Output2 -> 2 1 1 1 2 1 1 1 2

    // ? Input2 -> 3
    // ? Output3 -> 3 2 1 1 1 2 1 1 1 2 3 2 1 1 1 2 1 1 1 2 3

    // ? 2. Figure out the pattern and complete the recursive function pzz to
    // ? achieve
    // ? the above for any positive number n.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        pzz(n);
    }

    public static void pzz(int n) {// * APPROACH
        // To config such patter using recursive function first lets look at the
        // smallest case
        // When we input 1 the expected output is 1 1 1 lets assume it to be O
        // For input 2 the expected output is 2 1 1 1 2 1 1 1 2 which is -> 2 O 2 O 2
        // And so on ...
        // So the pattern here is to call the function thrice and printing the last
        // answer in between each time

        if (n == 0 || n < 0) {
            return;
        }
        System.out.print(n);
        pzz(n - 1);
        System.out.print(n);

        pzz(n - 1);
        System.out.print(n);
    }

}
