
public class MaximumTwinSumOfLL {
    // ! Q--> https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list
    // In a linked list of size n, where n is even, the ith node (0-indexed) of the
    // linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2)
    // - 1.

    // For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the
    // twin of node 2. These are the only nodes with twins for n = 4.
    // The twin sum is defined as the sum of a node and its twin.

    // Given the head of a linked list with even length, return the maximum twin sum
    // of the linked list.
    class ListNode {
        int val;
        ListNode next;
    }

    public static void main(String[] args) {

    }

    public ListNode middleNode(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null)
            return head;
        ListNode previous = null;
        ListNode present = head;
        ListNode next = present.next;

        while (present != null) {
            present.next = previous;
            previous = present;
            present = next;

            if (next != null)
                next = next.next;
        }
        return previous;
    }

    public int pairSum(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode headSecond = reverseList(mid);

        int max = Integer.MIN_VALUE;
        while (head != null && headSecond != null) {
            max = Math.max(max, (head.val + headSecond.val));
            head = head.next;
            headSecond = headSecond.next;
        }
        return max;
    }
}
