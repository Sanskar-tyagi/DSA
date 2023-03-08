package String.Leetcode;

import java.util.Scanner;

public class Decode {
    // ! Q--> https://leetcode.com/problems/decoded-string-at-index/description/
    public static void main(String[] args) {
        Decode string = new Decode();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter the String to Decode");
        String s = sc.next();
        System.out.println("Please Enter Index of the String to find CharAt");
        int k = sc.nextInt();
        String res = string.decodeAtIndex(s, k);
        System.out.println(res);
    }

    public String decodeAtIndex(String s, int k) {
        long size = 0;
        int n = s.length();

        // Calculate the total size of the decoded string
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                size++;
            } else {
                int d = Character.getNumericValue(c);
                size *= d;
            }
        }

        // Iterate backwards to find the kth letter
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                if (k == size || k == 0) {
                    return Character.toString(c);
                }
                size--;
            } else {
                int d = Character.getNumericValue(c);
                size /= d;
                k %= size;
            }
        }

        return "";
    }

}
