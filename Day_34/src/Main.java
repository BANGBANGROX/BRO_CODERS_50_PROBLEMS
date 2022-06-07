import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    private ArrayList<Integer> ans;
    private boolean[] visited;

    private boolean checkGrayCode(int n) {
        if (ans.size() == (1 << n)) return true;

        int current = ans.get(ans.size() - 1);

        for (int i = 0; i < n; ++i) {
            int next = current ^ (1 << i);
            if (!visited[next]) {
                visited[next] = true;
                ans.add(next);
                if (checkGrayCode(n)) return true;
                ans.remove(ans.size() - 1);
                visited[next] = false;
            }
        }

        return false;
    }

    public ArrayList<Integer> grayCode(int n) {
        ans = new ArrayList<>();
        visited = new boolean[(1 << n)];

        visited[0] = true;
        ans.add(0);

        checkGrayCode(n);

        return ans;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.grayCode(n));
        }

        sc.close();
    }
}
