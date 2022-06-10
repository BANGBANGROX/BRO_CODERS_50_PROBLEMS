import java.util.*;

class Solution {
    private boolean[][] bfs(ArrayList<ArrayList<Integer>> matrix, int color) {
        int m = matrix.size();
        int n = matrix.get(0).size();
        boolean[][] visited = new boolean[m][n];
        final int[] dx = {-1, 0, 1, 0};
        final int[] dy = {0, 1, 0, -1};
        Queue<ArrayList<Integer>> q = new LinkedList<>();

        if (color == 0) {
            // Top and Left
            // Top
            for (int i = 0; i < n; ++i) {
                q.add(new ArrayList<>(Arrays.asList(0, i)));
                visited[0][i] = true;
            }
            // Left
            for (int i = 0; i < m; ++i) {
                q.add(new ArrayList<>(Arrays.asList(i, 0)));
                visited[i][0] = true;
            }
        }
        else {
           // Bottom and Right
           // Bottom
           for (int i = 0; i < n; ++i) {
               q.add(new ArrayList<>(Arrays.asList(m - 1, i)));
               visited[m - 1][i] = true;
           }
           // Right
            for (int i = 0; i < m; ++i) {
                q.add(new ArrayList<>(Arrays.asList(i, n - 1)));
                visited[i][n - 1] = true;
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                ArrayList<Integer> currentCell = q.poll();
                assert currentCell != null;
                int x = currentCell.get(0);
                int y = currentCell.get(1);
                for (int j = 0; j < 4; ++j) {
                    int newX = x + dx[j];
                    int newY = y + dy[j];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY] &&
                            matrix.get(newX).get(newY) >= matrix.get(x).get(y)) {
                        q.add(new ArrayList<>(Arrays.asList(newX, newY)));
                        visited[newX][newY] = true;
                    }
                }
            }
        }

        return visited;
    }

    public int solve(ArrayList<ArrayList<Integer>> matrix) {
         int m = matrix.size();
         int n = matrix.get(0).size();
         int ans = 0;

         boolean[][] blue = bfs(matrix, 0);
         boolean[][] red = bfs(matrix, 1);

         for (int i = 0; i < m; ++i) {
             for (int j = 0; j < n; ++j) {
                 if (blue[i][j] && red[i][j]) {
                     ++ans;
                 }
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

            Solution solution = new Solution();
            System.out.println(solution.solve(matrix));
        }

        sc.close();
    }
}
