
package Linked_list;

import java.util.*;

public class LLtoQueue {

    // ? Note -> The intention is to use linked list functions to achieve the
    // ? purpose of a queue. All the functions should work in constant time.

    // 3.1. add -> Should accept new data in FIFO manner
    // 3.2. remove -> Should remove and return data in FIFO manner. If not
    // available,
    // print "Queue underflow" and return -1.
    // 3.3. peek -> Should return data in FIFO manner. If not available, print
    // "Queue
    // underflow" and return -1.
    // 3.4. size -> Should return the number of elements available in the queue

    public static class LLToStackAdapter {
        LinkedList<Integer> list;

        public LLToStackAdapter() {
            list = new LinkedList<>();
        }

        int size() {
            return list.size();
        }

        void add(int val) {
            list.addFirst(val);
        }

        int pop() {
            if (list.size() == 0) {
                System.out.println("Queue underflow");
                return -1;
            }
            return list.removeLast(); // write your code here
        }

        int top() {
            if (list.size() == 0) {
                System.out.println("Queue underflow");
                return -1;
            }
            return list.getLast(); // write your code here
        }

    }

    public static void main(String[] args) throws Exception {
        LLToStackAdapter st = new LLToStackAdapter();
        st.add(0);
        st.add(01);
        st.add(02);
        st.add(03);
        st.add(04);
        st.add(05);
        System.out.println(st.list);
        System.out.println(st.list);
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
    }
}
