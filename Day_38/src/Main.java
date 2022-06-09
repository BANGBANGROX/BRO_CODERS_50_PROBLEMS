import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private ArrayList<ArrayList<Integer>> tree;
    private int ans;

    private int dfs(int node, int parent) {
         int children = 1;

         for (int child : tree.get(node)) {
             if (child != parent) {
                 int currentChildren = dfs(child, node);
                 if ((currentChildren & 1) == 0) {
                     ++ans;
                 }
                 children += currentChildren;
             }
         }

         return children;
    }

    public int solve(int n, ArrayList<ArrayList<Integer>> edges) {
        tree = new ArrayList<>();
        ans = 0;

        for (int i = 0; i < n; ++i) {
            tree.add(new ArrayList<>());
        }

        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0) - 1;
            int v = edge.get(1) - 1;
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        dfs(1, -1);

        return ans;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
            for (int i = 1; i < n; ++i) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                edges.add(new ArrayList<>(Arrays.asList(u, v)));
            }

            Solution solution = new Solution();
            System.out.println(solution.solve(n, edges));
        }

        sc.close();
    }
}
