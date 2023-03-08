
public class SwapHnT {
    // You need to write a function Swap such that it Swaps the Node Head and Tail
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

        public void Swap() {
            // Approach
            // Let us assume we have a Link list as
            // 4k(adress) 1(data)-->5k(adress) 2(data)-->6k(adress) 3(data)-->7k(adress)
            // 4(data)-->null
            // now when the first line executes
            // N1= 7k(adress) 4(data)
            // Helper=5k(adress) 2(data)
            // Node getSecondlast = this.head;
            // while (getSecondlast.next.next != null) {
            // getSecondlast = getSecondlast.next;
            // }
            // We will store the 6k(adress) 3(data) Node to set the tail so that it does not
            // leads to an infinte loop later.
            // this.tail=4k(adress) 1(data)
            // at this point the list should be
            // 5k(adress) 2(data)-->6k(adress) 3(data)|NO LINK| 4k(adress)
            // 1(data)-->5k(adress)
            // 2(data)
            // now we set the tail as null to break the initial link
            // this.tail.next = null;
            // 5k(adress) 2(data)-->6k(adress) 3(data) 4k(adress) 1(data)-->null
            // and set the link between Secondlast node and tail
            // 5k(adress) 2(data)-->6k(adress) 3(data)-->4k(adress) 1(data)-->null
            // now this.head = N1;
            // 7k(adress) 4(data) 5k(adress) 2(data)-->6k(adress) 3(data)-->4k(adress)
            // 1(data)-->null
            // after this this.head.next = Helper; line will establish the link and
            // 7k(adress) 4(data)--> 5k(adress) 2(data)-->6k(adress) 3(data)-->4k(adress)
            // 1(data)-->null

            Node N1 = this.tail;
            Node Helper = this.head.next;
            Node getSecondlast = this.head;
            while (getSecondlast.next.next != null) {
                getSecondlast = getSecondlast.next;
            }

            this.tail = this.head;
            this.tail.next = null;
            getSecondlast.next = this.tail;
            this.head = N1;
            this.head.next = Helper;
            this.display();
        }

        public Node FindNodeAt(int tar) {
            if (this.size == 0) {
                return null;
            }

            Node next = this.head;
            for (int i = 0; i < tar; i++) {
                next = next.next;
            }
            return next;
        }
    }

    public static void main(String[] args) {
        LinkedList li = new LinkedList();
        li.addLast(0);
        li.addLast(1);
        li.addLast(2);
        li.addLast(3);
        li.display();
        System.out.println("Reversed");
        li.Swap();
    }
}
