package StacknDeque;

import java.util.*;;

public class DublicateBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input string");
        String s = sc.nextLine();
        System.out.println(isDublicate(s));
    }

    static boolean isDublicate(String s) {
        Stack<Character> sc = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            } else if (c != ')') {
                sc.push(c);
            } else {
                if (sc.peek() == '(') {
                    return true;
                } else {
                    while (sc.peek() != '(') {
                        sc.pop();
                    }
                    sc.pop();
                }
            }
        }
        return false;
    }
}