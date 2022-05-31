import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    public int solve(ArrayList<ArrayList<Integer>> matrix, int B) {
        int m = matrix.size();
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < m; ++j) {
                if (i == 0 && j == 0) continue;
                else if (i == 0) matrix.get(i).set(j, matrix.get(i).get(j) + matrix.get(i).get(j - 1));
                else if (j == 0) matrix.get(i).set(j, matrix.get(i).get(j) + matrix.get(i - 1).get(j));
                else matrix.get(i).set(j, matrix.get(i).get(j) + matrix.get(i - 1).get(j) + matrix.get(i).get(j - 1)
                            - matrix.get(i - 1).get(j - 1));
            }
        }

        for (int firstRow = 0; firstRow + B <= m; ++firstRow) {
            int lastRow = firstRow + B - 1;
            for (int firstCol = 0; firstCol + B <= m; ++firstCol) {
                int lastCol = firstCol + B - 1;
                int sum = matrix.get(lastRow).get(lastCol) - (firstRow > 0 ? matrix.get(firstRow - 1).get(lastCol) : 0)
                        - (firstCol > 0 ? matrix.get(lastRow).get(firstCol - 1) : 0) + (firstRow > 0 && firstCol > 0 ?
                        matrix.get(firstRow - 1).get(firstCol - 1) : 0);
                ans = Math.max(ans, sum);
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
            ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
            int B = sc.nextInt();

            for (int i = 0; i < m; ++i) {
                ArrayList<Integer> row = new ArrayList<>();
                for (int j = 0; j < m; ++j) {
                    int x = sc.nextInt();
                    row.add(x);
                }
                matrix.add(new ArrayList<>(row));
            }

            Solution solution = new Solution();
            System.out.println(solution.solve(matrix, B));
        }

        sc.close();
    }
}
