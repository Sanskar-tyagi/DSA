package Linked_list.Algorithm;

public class CicularLLStartingNode {
    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

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

        public int size() {
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

    static boolean IsCyclic(LinkedList li) {
        if (li.size < 2) {
            System.out.println("Cant make a circular List ");
            return false;
        }
        Node fast = li.head;
        Node slow = li.head;
        while (fast.next != null && fast != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    static void MakeCycleAt(int x, LinkedList li) {
        if (x == 0)
            return;
        else {
            Node temp = li.head;
            while (x > 0) {
                temp = temp.next;
                x--;
            }
            li.tail.next = temp;
        }

    }

    static int FindIndex(LinkedList li) {
        if (IsCyclic(li)) {

            // ?? My intial Approach
            // int x = li.size;
            // Node ptr = li.head.next;
            // Node itr = ptr.next;
            // while (ptr != itr) {
            // while (x > 0) {
            // if (ptr == itr) {
            // return ptr.data;
            // }
            // itr = itr.next;
            // x--;
            // }
            // ptr = ptr.next;
            // itr = ptr.next;
            // x = li.size;
            // }
            // return -1;
            Node tracker = li.head;
            int ans = 0;
            Node fast = li.head;
            Node slow = li.head;
            while (fast.next != null && fast != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    while (tracker != fast) {
                        fast = fast.next;
                        tracker = tracker.next;
                        ans++;
                    }
                    return ans;
                }
            }
            return -1;
        } else {
            System.out.print("List is not cyclic");
            return -1;
        }
    }

    public static void main(String[] args) {
        LinkedList li = new LinkedList();
        li.addLast(1);
        li.addLast(2);
        li.addLast(3);
        li.addLast(4);
        li.addLast(0);
        System.out.println("List");
        li.display();
        MakeCycleAt(3, li);
        System.out.println(IsCyclic(li));
        System.out.println(FindIndex(li));
    }
}
