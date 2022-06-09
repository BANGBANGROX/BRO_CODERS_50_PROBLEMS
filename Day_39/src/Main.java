import java.util.Scanner;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

class Solution {
    private final Stack<TreeNode> st;

    public Solution(TreeNode root) {
         st = new Stack<>();

         while (root != null) {
             st.push(root);
             root = root.left;
         }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
         return !st.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        int ans = st.peek().val;
        TreeNode current = st.pop();

        current = current.right;

        while (current != null) {
            st.push(current);
            current = current.left;
        }

        return ans;
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
