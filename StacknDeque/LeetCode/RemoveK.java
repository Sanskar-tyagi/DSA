package StacknDeque.LeetCode;

import java.util.*;

public class RemoveK {
    // Given string num representing a non-negative integer num, and an integer k,
    // return the smallest possible integer after removing k digits from num.
    // Input: num = "1432219", k = 3
    // Output: "1219"
    // Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219
    // which is the smallest.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter K");
        int k = sc.nextInt();
        System.out.println("Enter S");
        String s = sc.next();
        String ans = removeKdigits(s, k);
        System.out.println(ans);
    }

    public static String removeKdigits(String num, int k) {
        // Approach

        if (k >= num.length())
            return "0";
        // Initialize an empty stack stack of type Deque<Character> to keep track of the
        // digits.
        Deque<Character> stack = new ArrayDeque<>();
        // Loop through each digit c in the string representation of the number num
        // using a for-each loop:
        for (char c : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peekLast() > c) {// check if there are K digits are still not
                                                                       // removed and the stack is not empty and the
                                                                       // current last value in the stack is greater

                // than the current number
                stack.removeLast();// if so remove the last digit
                k--;// and decrease K

            }
            System.out.println("Added" + c);
            stack.addLast(c); // and add the smaller digits

        }

        while (k > 0) {// After the loop, if there are still digits k that need to be removed, remove
                       // the last digit from the stack and decrement k.
            stack.removeLast();
            k--;
        }

        // Remove all zeros from the front of the stack and then if stack is empty,
        // return "0"
        while (!stack.isEmpty() && stack.peekFirst() == '0')
            stack.removeFirst();
        if (stack.isEmpty())
            return "0";

        // build the number from the stack
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeFirst());
        }
        return sb.toString();
    }
}
