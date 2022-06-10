import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < numCourses; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];
            graph.get(v).add(u);
            ++inDegree[u];
        }

        for (int i = 0; i < numCourses; ++i) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int currentNode = q.poll();
            res.add(currentNode);
            for (int child : graph.get(currentNode)) {
                --inDegree[child];
                if (inDegree[child] == 0) {
                    q.add(child);
                }
            }
        }

        if (res.size() != numCourses) return new int[]{};

        int[] ans = new int[numCourses];

        for (int i = 0; i < numCourses; ++i) {
            ans[i] = res.get(i);
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int numCourses = sc.nextInt();
            int edges = sc.nextInt();
            int[][] prerequisites = new int[edges][2];
            for (int i = 0; i < edges; ++i) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                prerequisites[i][0] = x;
                prerequisites[i][1] = y;
            }

            Solution solution = new Solution();
            int[] ans = solution.findOrder(numCourses, prerequisites);
            for (int i = 0; i < numCourses; ++i) {
                System.out.print(ans[i] + " ");
            }
        }

        sc.close();
    }
}
