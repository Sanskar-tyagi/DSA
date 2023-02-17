public class UnFoldLL {
    // Given a singly linkedlist : l0 -> ln -> l1 -> ln-1 -> l2 -> ln-2 -> l3 ->
    // ln-3 -> .....
    // reorder it : l0 -> l1 -> l2 -> l3 -> l4 -> l5 -> l6 ..... -> ln-1 -> ln
    // Input Format
    // 1->7->2->6->3->5->4->null
    // Output Format
    // 1->2->3->4->5->6->7->null
    static class ListNode {
        int data;
        ListNode next = null;

        ListNode(int val) {
            this.data = val;
        }
    }

    static class Linklist {
        ListNode head;
        ListNode tail;
        int size;

        public void addLast(int val) {
            ListNode ListNode = new ListNode(0);
            ListNode.data = val;
            if (this.size == 0) {
                this.head = ListNode;
                this.tail = ListNode;
            } else {
                this.tail.next = ListNode;
                this.tail = ListNode;
            }
            this.size++;
        }

        int size() {
            return this.size;
        }

        void display() {
            ListNode ptr = this.head;
            while (ptr != null) {
                System.out.print(ptr.data + "   ");
                ptr = ptr.next;
            }
            System.out.println("");
        }

        public void reorderList(ListNode head) {
            if (head == null || head.next == null)
                return;

            ListNode mid = getMid(head);
            ListNode head2 = mid.next;
            mid.next = null;

            head2 = reverse(head2);

            ListNode p1 = head, p2 = head2;

            ListNode dummy = new ListNode(0);

            ListNode p3 = dummy;

            while (p1 != null && p2 != null) {
                p3.next = p1;
                p1 = p1.next;
                p3 = p3.next;

                p3.next = p2;
                p2 = p2.next;
                p3 = p3.next;
            }

            p3.next = p1; // odd
        }

        public ListNode getMid(ListNode head) {
            if (head == null || head.next == null)
                return head;

            ListNode slow = head, fast = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }

            return slow;
        }

        public ListNode reverse(ListNode head) {
            ListNode curr = head;
            ListNode prev = null;
            while (curr != null) {
                ListNode nbr = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nbr;
            }
            return prev;
        }

        void UnFoldLL(ListNode head) {
            if (head == null || head.next == null || head.next.next == null) {
                return;
            } else {
                ListNode D2 = new ListNode(0);
                ListNode D1 = new ListNode(0);
                ListNode p1 = D1;
                ListNode p2 = D2;
                ListNode p3 = this.head;
                boolean flag = true;
                while (p3 != null) {
                    if (flag == true) {
                        p1.next = p3;
                        p1 = p1.next;
                        flag = !flag;
                    } else {
                        p2.next = p3;
                        p2 = p2.next;
                        flag = !flag;
                    }
                    p3 = p3.next;
                }
                p1.next = null;
                p2.next = null;
                ListNode head2 = D2.next;
                head2 = reverse(head2);
                ListNode ptr = head;
                while (ptr.next != null) {
                    ptr = ptr.next;
                }
                ptr.next = head2;
            }
        }
    }

    public static void main(String[] args) {
        Linklist li = new Linklist();
        li.addLast(1);
        li.addLast(2);
        li.addLast(3);
        li.addLast(4);
        li.addLast(5);
        li.addLast(6);
        li.addLast(7);
        li.addLast(8);
        li.addLast(9);
        li.display();
        li.reorderList(li.head);
        li.display();
        li.UnFoldLL(li.head);
        li.display();
    }
}
