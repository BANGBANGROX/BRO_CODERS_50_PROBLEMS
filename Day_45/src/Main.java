import java.util.Scanner;

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
    private int ans;

    private int maxPathSumUtil(TreeNode root) {
        if (root == null) return 0;

        int leftSum = maxPathSumUtil(root.left);
        int rightSum = maxPathSumUtil(root.right);
        int val1 = root.val + Math.max(leftSum, rightSum);
        int val2 = root.val + leftSum + rightSum;

        ans = Math.max(ans, root.val);
        ans = Math.max(ans, Math.max(val1, val2));

        return val1;
    }

    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;

        maxPathSumUtil(root);

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
