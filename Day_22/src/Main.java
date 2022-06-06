import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        next = null;
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode resHead = new ListNode(0);
        ListNode resTail = resHead;

        while (head != null) {
            int count = 1;
            ListNode prevNode = head;
            ListNode next = head.next;
            while (next != null && prevNode.val == next.val) {
                prevNode = next;
                next = next.next;
                ++count;
            }
            if (count == 1) {
                resTail.next = new ListNode(prevNode.val);
                resTail = resTail.next;
            }
            head = next;
        }

        return resHead.next;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
        }

        sc.close();
    }
}
