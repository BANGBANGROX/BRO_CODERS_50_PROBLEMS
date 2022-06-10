import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    public ArrayList<ArrayList<Integer>> solve(int k, ArrayList<ArrayList<Integer>> matrix) {
        int m = matrix.size();
        int n = matrix.get(0).size();
        int[][][] dp = new int[m][n][k + 1];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int size = 0; size <= k; ++size) {
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (size == 0) {
                        dp[i][j][size] = matrix.get(i).get(j);
                    }
                    else {
                        int res = matrix.get(i).get(j);
                        if (i + 1 < m) res = Math.max(res, dp[i + 1][j][size - 1]);
                        if (j + 1 < n) res = Math.max(res, dp[i][j + 1][size - 1]);
                        if (i - 1 >= 0) res = Math.max(res, dp[i - 1][j][size - 1]);
                        if (j - 1 >= 0) res = Math.max(res, dp[i][j - 1][size - 1]);
                        dp[i][j][size] = res;
                    }
                }
            }
        }

        for (int i = 0; i < m; ++i) {
            ArrayList<Integer> current = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                current.add(dp[i][j][k]);
            }
            ans.add(new ArrayList<>(current));
        }

        return ans;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
            for (int i = 0; i < m; ++i) {
                ArrayList<Integer> row = new ArrayList<>();
                for (int j = 0; j < n; ++j) {
                    int x = sc.nextInt();
                    row.add(x);
                }
                matrix.add(new ArrayList<>(row));
            }
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.solve(k, matrix));
        }

        sc.close();
    }
}
