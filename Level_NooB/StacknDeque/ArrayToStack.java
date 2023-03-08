package StacknDeque;

import java.util.Scanner;

public class ArrayToStack {
    // Motive --> You are required to complete the code of our CustomStack class.
    // The class should mimic the behaviour of java.util.Stack class and implement
    // LIFO semantic.
    // Here is the list of functions that you are supposed to complete
    // 2.1. push -> Should accept new data if there is space available in the
    // underlying
    // array or print "Stack overflow" otherwise.
    // 2.2. pop -> Should remove and return last data if available or print "Stack
    // underflow" otherwise and return -1.
    // 2.3. top -> Should return last data if available or print "Stack underflow"
    // otherwise and return -1.
    // 2.4. size -> Should return the number of elements available in the stack.

    public static class CustomStack {
        int[] data;
        int tos;

        public CustomStack(int cap) {
            data = new int[cap];
            tos = -1;
        }

        int size() {
            return tos + 1;
        }

        void push(int val) {
            if (tos != size()) {
                tos = tos + 1;
                this.data[tos] = val;
            } else {
                System.out.println("Stack overflow Please Remove Elements to add more");
            }
        }

        int pop() {
            if (size() > 0) {
                int val = data[tos];
                tos--;
                return val;
            } else {
                return -1;
            }
        }

        int top() {
            if (size() > 0) {
                int val = data[tos];
                return val;
            } else
                return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter size of stack");
        int n = sc.nextInt();
        CustomStack stack = new CustomStack(n);
        System.out.println("Please Note The Stack now has a Fixed size of" + n);
        System.out.println("Please enter a character to perform Functions ");
        System.out.println("P --> to push a value in stack");
        System.out.println("T --> to peek the top value in stack");
        System.out.println("R --> to remove the top value in stack");
        System.out.println("S --> to view stack size");
        System.out.println("E --> terminate");
        char c = ' ';
        while (Character.toUpperCase(c) != 'E') {
            String input = sc.next();
            c = input.charAt(0);
            if (Character.toUpperCase(c) == 'P') {
                System.out.println("Please enter value to push");
                int val = sc.nextInt();
                stack.push(val);
                continue;
            } else if (Character.toUpperCase(c) == 'T') {
                if (stack.top() != -1) {
                    System.out.println("The top of the stack has " + stack.top());
                } else {
                    System.out.println("Stack underflow. Please add elements to view further.");
                }
                continue;
            } else if (Character.toUpperCase(c) == 'R') {
                if (stack.pop() > -1) {
                    System.out.println("Removed " + stack.pop());
                } else {
                    System.out.println("Stack underflow. Please add elements to remove further.");
                }
                continue;
            } else if (Character.toUpperCase(c) == 'S') {
                if (stack.size() > 0) {
                    System.out.println("Size --> " + stack.size());
                } else {
                    System.out.println("Stack underflow. Please add elements to view size further.");
                }
                continue;
            } else if (Character.toUpperCase(c) != 'E') {
                System.out.println("Invalid input.");
                continue;
            }
        }
        System.out.println("Terminating.");
        return;
    }
}
