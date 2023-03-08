package Recursion_1.LeetCode;

import java.util.*;

public class GenerateParentheses {
    // ! Q--> https://leetcode.com/problems/generate-parentheses/description/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter The number to Generate Parentheses");
        int n = sc.nextInt();
        List<String> res = new ArrayList<String>();
        par(res, 0, 0, "", n);// Calling the Recursive Method par to generate our Result (res) ArrayList
        for (String c : res) {
            System.out.println(" [  " + c + "  ] ");
        }
    }

    public static void par(List<String> res, int left, int right, String s, int n) {
        if (s.length() == n * 2) {// checks if the length of the current combination s is equal to n * 2. If so,
                                  // it means that the current combination has n pairs of parentheses and is a
                                  // valid combination. The combination is added to the res list and the function
                                  // returns.
            res.add(s);
            return;
        }

        if (left < n) {// here we check if it is possible to add a left parenthesis to the current
                       // combination. If the number of left parentheses added to the current
                       // combination is less than n,
            par(res, left + 1, right, s + "(", n);// the function makes a recursive call to itself
                                                  // with the updated number of left parentheses added to the current
                                                  // combination,and the updated string s with a left parenthesis added
                                                  // to it. first bracket for our Answer.
        }

        if (right < left) {// here we check if it is possible to add a right parenthesis to the
                           // current combination. If the number of right parentheses added to the current
                           // combination is less than the number of left parentheses,
            par(res, left, right + 1, s + ")", n);// the function makes a
                                                  // recursive call to itself with the updated number of right
                                                  // parentheses added to the current combination, and the updated
                                                  // string s with a right parenthesis added to it.

        }
    }
}
