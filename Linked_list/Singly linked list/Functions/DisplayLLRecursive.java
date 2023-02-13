 
public class DisplayLLRecursive {
    // ?You are required to complete the body of displayReverse and
    // ? displayReverseHelper functions. The function are expected to print in
    // ? reverse the linked list without actually reversing it.
    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        public int size() {
            return size;
        }

        public void display() {
            Node current = this.head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
        }

        void addLast(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = null;

            if (size == 0) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }
            size++;
        }

        private void displayReverseHelper(Node node) {
            // * */ Approach

            // * */ Here we try to use this helper method to display the data in reversed
            // * */ order by repeatedly calling the function till it reaches the last end of
            // * */ the node and then returning from it.
            // * */ Which will lead us to Display firstly the Last Node's data and then
            // * */ destroying the call-stack for the current call and leading to the next
            // * */ call Generating the required output
            if (node == null) {// Base case
                return;
            }
            displayReverseHelper(node.next);// Recursive call
            System.out.print(node.data + " ");// Printing of data from last called Node.
        }

        public void displayReverse() {
            displayReverseHelper(head);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LinkedList li = new LinkedList();
        li.addLast(0);
        li.addLast(1);
        li.addLast(2);
        li.addLast(3);
        li.display();
        System.out.println();
        System.out.println();
        System.out.println("Reversed");
        System.out.println();
        li.displayReverse();

    }
}
