package Array.TwoD;

import java.lang.annotation.Retention;
import java.util.ArrayList;
import java.util.Scanner;

public class PascalsTriangle {
    // Q ->https://www.codingninjas.com/codestudio/problems/1089580
    // You are given an integer N. Your task is to return a 2-D ArrayList containing
    // the pascal’s triangle till the row N.
    // A Pascal's triangle is a triangular array constructed by summing adjacent
    // elements in preceding rows. Pascal's triangle contains the values of the
    // binomial coefficient.
    // ! P.S For example refer question link.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the integer to print Array");
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> res = GenerateList(n);
        for (ArrayList<Integer> i : res) {
            for (int x : i) {
                System.out.print(x);
            }
            System.out.println();
        }
    }

    static ArrayList<ArrayList<Integer>> GenerateList(int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> in = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    in.add(1);
                } else {
                    int num = res.get(i - 1).get(j - 1) + res.get(i - 1).get(j);
                    in.add(num);
                }
            }
            res.add(in);
        }
        return res;
    }
}