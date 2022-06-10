import java.util.Scanner;

class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        boolean[][] palindrome = new boolean[n][n];

        for (int len = 1; len <= n; ++len) {
            for (int i = 0; i + len <= n; ++i) {
                int j = i + len - 1;
                if (i == j) {
                    palindrome[i][j] = true;
                }
                else {
                    palindrome[i][j] = (s.charAt(i) == s.charAt(j)) && palindrome[i + 1][j - 1];
                }
            }
        }

        for (int i = 0; i < n; ++i) {
            if (palindrome[0][i]) {
                dp[i] = 0;
            }
            else {
                dp[i] = Integer.MAX_VALUE;
                for (int j = 0; j < i; ++j) {
                    if (palindrome[j + 1][i]) {
                        dp[i] = Math.min(dp[i], 1 + dp[j]);
                    }
                }
            }
        }

        return dp[n - 1];
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.minCut(s));
        }

        sc.close();
    }
}
