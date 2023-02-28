/*
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 */

public class AddTwoNumbers {
    public static void main(String[] args) {
        // Example 1
        ListNode c = new ListNode(3);
        ListNode b = new ListNode(4, c);
        ListNode a = new ListNode(2, b);

        ListNode z = new ListNode(4);
        ListNode y = new ListNode(6, z);
        ListNode x = new ListNode(5, y);

        ListNode result1 = addTwoNumbers(a, x);
        System.out.println("Example 1");
        printListNode(result1);

        // Example 2
        ListNode aa = new ListNode(0);
        ListNode bb = new ListNode(0);
        ListNode result2 = addTwoNumbers(aa, bb);
        System.out.println("Example 2");
        printListNode(result2);

        // Example 3 - almost makes me want to make an easier way to create these, but too late
        ListNode t7 = new ListNode(9);
        ListNode t6 = new ListNode(9, t7);
        ListNode t5 = new ListNode(9, t6);
        ListNode t4 = new ListNode(9, t5);
        ListNode t3 = new ListNode(9, t4);
        ListNode t2 = new ListNode(9, t3);
        ListNode t1 = new ListNode(9, t2);

        ListNode u4 = new ListNode(9);
        ListNode u3 = new ListNode(9, u4);
        ListNode u2 = new ListNode(9, u3);
        ListNode u1 = new ListNode(9, u2);
        ListNode result3 = addTwoNumbers(t1, u1);
        printListNode(result3);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addWithCarryOver(l1, l2, 0);
    }

    public static ListNode addWithCarryOver(ListNode l1, ListNode l2, int carryOver) {
        int a = l1 == null ? 0 : l1.val;
        int b = l2 == null ? 0 : l2.val;
        int sum = a + b + carryOver;
        int nextCarryOver = 0;
        if (sum >= 10) {
            nextCarryOver = 1;
            sum -= 10;
        }

        if (nextCarryOver > 0 || (l1 != null && l1.next != null) || (l2 != null && l2.next != null)) {
            ListNode nextL1 = l1 != null ? l1.next : null;
            ListNode nextL2 = l2 != null ? l2.next : null;
            return new ListNode(sum, addWithCarryOver(nextL1, nextL2, nextCarryOver));
        } else {
            return new ListNode(sum);
        }
    }

    private static void printListNode(ListNode x) {
        StringBuilder sb = new StringBuilder();
        sb.append(x.val);
        while (x.next != null) {
            x = x.next;
            sb.append(x.val);
        }
        System.out.println(sb.toString());
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}


 