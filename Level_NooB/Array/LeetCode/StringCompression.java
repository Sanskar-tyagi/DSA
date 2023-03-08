package Array.LeetCode;

import java.util.Scanner;

public class StringCompression {
    // Given an array of characters chars, compress it using the following
    // algorithm:

    // Begin with an empty string s. For each group of consecutive repeating
    // characters in chars:

    // If the group's length is 1, append the character to s.
    // Otherwise, append the character followed by the group's length.
    // The compressed string s should not be returned separately, but instead, be
    // stored in the input character array chars. Note that group lengths that are
    // 10 or longer will be split into multiple characters in chars.

    // After you are done modifying the input array, return the new length of the
    // array.

    // You must write an algorithm that uses only constant extra space.

    // ? Here are some things we want to ask ourselves:
    // ? What to do when a character group is of length 1?
    // ? What to do when a character ground is length > 1?
    // ? How do I solve this in-place (for constant space complexity)?
    // ? To tackle this issue, we will use a two pointers approach.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter N");
        int n = sc.nextInt();
        char ch[] = new char[n];
        System.out.println("Enter Char");
        for (int i = 0; i < n; i++) {
            ch[i] = sc.next().charAt(0);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(ch[i]);
        }
        System.out.println();
        int a = compress(ch);
        System.out.println("A" + a);
        for (int i = 0; i < n; i++) {
            System.out.print(ch[i]);
        }

    }

    public static int compress(char[] chars) {
        int index = 0;
        int i = 0;
        while (i < chars.length) {
            int j = i;
            while (j < chars.length && chars[j] == chars[i])
                j++;
            chars[index++] = chars[i];
            if (j - i > 1) {
                String count = j - i + "";
                for (char c : count.toCharArray()) {
                    chars[index++] = c;
                }
            }
            i = j;
        }
        return index;

    }
}
