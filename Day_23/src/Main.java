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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int count = 0;
        ListNode curr = head;
        ListNode left = null;
        ListNode start = null;

        if (m == n) return head;

        while (count <= m) {
            ++count;
            if (count == m - 1) left = curr;
            if (count == m) start = curr;
            curr = curr.next;
        }

        --count;
        curr = start;

        ListNode prev = null;
        ListNode next;

        while (count <= n) {
            ++count;
            assert curr != null;
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        if (left == null) return prev;

        left.next = prev;

        return head;
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
