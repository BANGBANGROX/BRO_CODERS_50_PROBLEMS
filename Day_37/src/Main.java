import java.util.*;

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
    public ArrayList<Integer> solve(TreeNode root, int nodeValue) {
        HashMap<TreeNode, TreeNode> parents = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            ArrayList<TreeNode> currentLevel = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                TreeNode currentNode = q.poll();
                currentLevel.add(currentNode);
                assert currentNode != null;
                if (currentNode.left != null) {
                    q.add(currentNode.left);
                    parents.put(currentNode.left, currentNode);
                }
                if (currentNode.right != null) {
                    q.add(currentNode.right);
                    parents.put(currentNode.right, currentNode);
                }
            }
            boolean found = false;
            TreeNode nodeParent = null;
            for (TreeNode currentNode: currentLevel) {
                if (currentNode.val == nodeValue) {
                    found = true;
                    nodeParent = parents.get(currentNode);
                    break;
                }
            }
            if (found) {
                ArrayList<Integer> ans = new ArrayList<>();
                for (TreeNode currentNode: currentLevel) {
                    if (parents.get(currentNode) != nodeParent) {
                        ans.add(currentNode.val);
                    }
                }
                return ans;
            }
        }

        return new ArrayList<>();
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
