// package Recursion_1;

// import java.util.*;

// /*You are given a string Str.
// * You need to find all the subsqeuence of the given string possible and store
// the ans in an array.
// */
// public class Subsequence {
// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);
// String str = sc.next();
// int n = str.length();
// getsub(str, "", n);
// }

// public static void getsub(String str, String ansf, int idx) {

// List<String> list = new ArrayList<String>();
// if (idx < 0) {
// return;
// }
// if (idx == 0) {
// String arr[] = new String[list.size()];
// for (int i = 0; i < list.size(); i++) {
// arr[i] = list.get(i);
// System.out.println(arr[i]);
// }
// }
// how will you make sub sequence ???
// for abc --[ ,a+'',b+'',c+'',ab+'',bc+'',ac+'',abc+'' ]
// choices of a char to add in answer string or not
// list.add(idx, ansf);
// char a = str.charAt(idx);
// getsub(str, ansf + a, idx - 1);
// getsub(str, ansf + "", idx - 1);
// }
// }

//! there are a few issues with the current implementation.

//! First, the list variable should be declared outside of the getsub method so that it can be accessed by all recursive calls.

//! Second, the getsub method should be called with the index n-1 instead of n in the initial call in the main method. This is because the string indexes start at 0 and not 1.

//! Third, the for loop in the code should be moved to outside of the recursion so that after all the recursive calls have returned, it should print all the sub sequences.

//! Finally, the method should be modified to pass the list as parameter and after each recursive call it should add the answer to the list.

package Recursion_1;

import java.util.*;

public class Subsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = str.length();
        List<String> list = new ArrayList<>();
        getsub(str, " ", n, list);
        String arr[] = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
            System.out.print(arr[i] + '_');
        }
    }

    public static void getsub(String str, String ansf, int idx, List<String> list) {
        if (idx == 0) {
            list.add(ansf);
            return;
        }
        getsub(str, ansf, idx - 1, list);
        getsub(str, ansf + str.charAt(idx - 1), idx - 1, list);
    }
}
