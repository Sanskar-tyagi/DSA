package StacknDeque;

public class MinStack {
    // Design a stack that supports push, pop, top, and retrieving the minimum
    // element in constant time.

    // Implement the MinStack class:

    // MinStack() initializes the stack object.
    // void push(int val) pushes the element val onto the stack.
    // void pop() removes the element on the top of the stack.
    // int top() gets the top element of the stack.
    // int getMin() retrieves the minimum element in the stack.
    // You must implement a solution with O(1) time complexity for each function.

    public static class Minstack {
        int[] data;
        int tos;

        public Minstack(int cap) {
            data = new int[cap];
            tos = 0;
        }

        public void push(int val) {
            int min = tos == 0 || data[tos] > val ? val : data[tos];// If tos is equal to 0 or the value at index tos of
                                                                    // an array data is greater than a variable val,
                                                                    // then
                                                                    // min is assigned the value of val.
                                                                    // Otherwise, min is assigned the value at index tos
                                                                    // of the array data.
            data[++tos] = val;
            data[++tos] = min;
        }

        public void pop() {// we are first decrementing tos to remove the minimum value, and then
                           // decrementing it again to remove the actual value that was pushed onto the
                           // stack.
            tos--;
            tos--;
        }

        public int top() {
            return data[tos - 1];
        }
    }
}
