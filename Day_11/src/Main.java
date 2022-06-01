import java.util.Scanner;
import java.util.*;

class Solution {
    public int maxArea(ArrayList<Integer> capacity) {
        int n = capacity.size();
        int l = 0;
        int r = n - 1;
        int maxL = 0;
        int maxR = 0;
        int ans = 0;

        while (l < r) {
            maxL = Math.max(maxL, capacity.get(l));
            maxR = Math.max(maxR, capacity.get(r));
            if (maxL < maxR) {
                ans = Math.max(ans, (r - l) * maxL);
                ++l;
            }
            else {
                ans = Math.max(ans, (r - l) * maxR);
                --r;
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
            int n = sc.nextInt();
            ArrayList<Integer> capacity = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                int x = sc.nextInt();
                capacity.add(x);
            }

            Solution solution = new Solution();
            System.out.println(solution.maxArea(capacity));
        }

        sc.close();
    }
}
