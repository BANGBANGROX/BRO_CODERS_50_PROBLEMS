import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    private final int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    private final int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    private ArrayList<String> board;
    private int[][][] dp;

    private boolean dfs(int x, int y, int k) {
        int m = board.size();
        int n = board.get(0).length();

        if (dp[x][y][k] != -1) return dp[x][y][k] == 1;

        int newX = x + dx[k];
        int newY = y + dy[k];
        dp[x][y][k] = 0;

        if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
            if (board.get(newX).charAt(newY) == '1' || dfs(newX, newY, k)) dp[x][y][k] = 1;
        }

        return dp[x][y][k] == 1;
    }

    public ArrayList<ArrayList<Integer>> queenAttack(ArrayList<String> board) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int m = board.size();
        int n = board.get(0).length();
        dp = new int[m][n][8];
        this.board = board;

        for (int i = 0; i < m; ++i) {
            ArrayList<Integer> current = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                current.add(0);
            }
            ans.add(new ArrayList<>(current));
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < 8; ++k) {
                    dp[i][j][k] = -1;
                }
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int count = 0;
                for (int k = 0; k < 8; ++k) {
                    if (dfs(i, j, k)) {
                        ++count;
                    }
                }
                ans.get(i).set(j, count);
            }
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
            ArrayList<String> board = new ArrayList<>();
            for (int i = 0; i < m; ++i) {
                String x = sc.next();
                board.add(x);
            }

            Solution solution = new Solution();
            System.out.println(solution.queenAttack(board));
        }

        sc.close();
    }
}
