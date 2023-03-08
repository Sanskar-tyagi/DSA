package StacknDeque;

import java.util.*;

public class QueueToStack {
    // ! Implementing Stack using the Inbuit Queue in java

    Queue<Integer> mainQ;
    Queue<Integer> helperQ;

    public QueueToStack() {
        mainQ = new ArrayDeque<>();
        helperQ = new ArrayDeque<>();
    }

    int size() {
        return mainQ.size();
    }

    void push(int val) {
        mainQ.add(val);
    }

    int pop() {
        if (mainQ.size() == 0) {
            System.out.println("Stack underflow");
            return -1;
        }
        while (mainQ.size() > 1) {
            helperQ.add(mainQ.remove());
        }
        int val = mainQ.remove();
        Queue<Integer> tmpQ = mainQ;
        mainQ = helperQ;
        helperQ = tmpQ;

        return val;
    }

    int top() {
        if (mainQ.size() == 0) {
            System.out.println("Stack underflow");
            return -1;
        }
        while (mainQ.size() > 1) {
            helperQ.add(mainQ.remove());
        }
        int val = mainQ.remove();
        helperQ.add(val);
        Queue<Integer> tmpQ = mainQ;
        mainQ = helperQ;
        helperQ = tmpQ;

        return val;
    }
}

