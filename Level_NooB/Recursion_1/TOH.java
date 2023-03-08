package Recursion_1;

import java.util.*;

//1. There are 3 towers. Tower 1 has n disks, where n is a positive number. Tower 2 and 3 are empty.
// 2. The disks are increasingly placed in terms of size such that the smallest disk is on top and largest disk is at bottom.
// 3. You are required to 
//     3.1. Print the instructions to move the disks.
//     3.2. from tower 1 to tower 2 using tower 3 
//     3.3. following the rules
//         3.3.1 move 1 disk at a time.
//         3.3.2 never place a smaller disk under a larger disk.
//         3.3.3 you can only move a disk at the top.
public class TOH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printmoves("source", "destination", "helper", n);
    }

    public static void printmoves(String src, String des, String hel, int discs) {
        if (discs == 0) {
            return;
        }
        // remove the top disc
        printmoves(src, hel, des, discs - 1);
        System.out.println(src + "-->" + des);
        printmoves(hel, des, src, discs - 1);
    }
}
