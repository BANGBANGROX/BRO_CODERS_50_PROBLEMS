import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    private int m;
    private int n;

    private void dfs(int x, int y, ArrayList<ArrayList<Character>> grid) {
         if (x < 0 || x >= m || y < 0 || y >= n || grid.get(x).get(y) == '#' || grid.get(x).get(y) == 'X') return;

         grid.get(x).set(y, '#');

         dfs(x + 1, y, grid);
         dfs(x, y + 1, grid);
         dfs(x - 1, y, grid);
         dfs(x, y - 1, grid);
    }

    public void solve(ArrayList<ArrayList<Character>> grid) {
        m = grid.size();
        n = grid.get(0).size();

        for (int i = 0; i < m; ++i) {
            if (grid.get(i).get(0) == 'O') {
                dfs(i, 0, grid);
            }
            if (grid.get(i).get(n - 1) == 'O') {
                dfs(i, n - 1, grid);
            }
        }

        for (int i = 0; i < n; ++i) {
            if (grid.get(0).get(i) == 'O') {
                dfs(0, i, grid);
            }
            if (grid.get(m - 1).get(i) == 'O') {
                dfs(m - 1, i, grid);
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid.get(i).get(j) == '#') {
                    grid.get(i).set(j, 'O');
                }
                else {
                    grid.get(i).set(j, 'X');
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            ArrayList<ArrayList<Character>> grid = new ArrayList<>();
            for (int i = 0; i < m; ++i) {
                ArrayList<Character> row = new ArrayList<>();
                for (int j = 0; j < n; ++j) {
                    char ch = sc.next().charAt(0);
                    row.add(ch);
                }
                grid.add(new ArrayList<>(row));
            }

            Solution solution = new Solution();
            solution.solve(grid);

            for (ArrayList<Character> row : grid) {
                for (char ch : row) {
                    System.out.print(ch + ' ');
                }
                System.out.println();
            }
        }

        sc.close();
    }
}
