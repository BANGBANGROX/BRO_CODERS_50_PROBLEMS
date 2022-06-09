import java.util.ArrayList;
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
    private ArrayList<Integer> nums;

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        nums.add(root.val);

        inorder(root.right);
    }

    public int t2Sum(TreeNode root, int target) {
        nums = new ArrayList<>();

        inorder(root);

        int n = nums.size();
        int l = 0;
        int r = n - 1;

        while (l < r) {
            int sum = nums.get(l) + nums.get(r);
            if (sum == target) return 1;
            if (sum > target) --r;
            else ++l;
        }

        return 0;
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
