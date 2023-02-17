
public class kthFromLast {
    // ? kthFromLast function.
    // ?The function should be an iterative function and
    // ? should return the kth node from end of linked list.

    // ! Also, make sure to not use size data member directly or indirectly (by
    // ! calculating size via making a traversal). k is a 0-based index.
    public static class Node {
        int data;
        Node next;
    }

    public static class Linklist {
        Node head;
        Node tail;
        int size;

        public int kthFromLas(int k) {// *Approach*/
            // We will intialize 2 pointers in the list
            // One will lag with slower movement by kth diffrence from the other pointer
            // We will use Slow and fast as pointer names
            Node slow = this.head;
            Node fast = this.head;
            while (k != 0) {
                fast = fast.next;
                k--;
            }
            // initially they both will point towards the head of linked list
            // we will ittrate over the List until we get our fast as tail.
            while (fast != this.tail) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow.data;
        }

        void addFirst(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = head;

            if (size == 0) {
                head = tail = temp;
            } else {
                head = temp;
            }

            size++;
        }

        int size() {
            return this.size;
        }

        void display() {
            Node ptr = this.head;
            while (ptr != null) {
                System.out.print(ptr.data + "   ");
                ptr = ptr.next;
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Linklist li = new Linklist();
        li.addFirst(110);
        li.addFirst(111);
        li.addFirst(232);
        li.addFirst(354);
        li.addFirst(2244);
        li.display();
        System.out.println(li.kthFromLas(0));
    }
}
