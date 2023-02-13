 
import java.io.*;
import java.util.*;

public class LLtoStack {
    // ? Note -> The intention is to use linked list functions to achieve the
    // ? purpose of a stack. All the functions should work in constant time.

    // ? 1. You are required to complete the code of our LLToStackAdapter class.
    // ? 2. As data members, you've a linkedlist available in the class.
    // ? 3. Here is the list of functions that you are supposed to complete
    // ? 3.1. push -> Should accept new data in LIFO manner
    // ? 3.2. pop -> Should remove and return data in LIFO manner. If not
    // ? available, print "Stack underflow" and return -1.
    // ? 3.3. top -> Should return data in LIFO manner. If not available, print
    // ? "Stack underflow" and return -1.
    // ? 3.4. size -> Should return the number of elements available in the
    // ? stack
    public static class LLToStackAdapter {
        LinkedList<Integer> list;

        public LLToStackAdapter() {
            list = new LinkedList<>();
        }

        int size() {
            return list.size(); // write your code here
        }

        void push(int val) {
            list.addFirst(val); // write your code here
        }

        int pop() {
            if (list.size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            }
            return list.removeFirst(); // write your code here
        }

        int top() {
            if (list.size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            }
            return list.getFirst(); // write your code here
        }

    }

    public static void main(String[] args) throws Exception {
        LLToStackAdapter st = new LLToStackAdapter();
        st.push(1);
        System.out.println(st.list);
        st.push(2);
        System.out.println(st.list);
        st.push(3);
        System.out.println(st.list);
        st.push(4);
        System.out.println(st.list);
        System.out.println(st.list);
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
    }
}