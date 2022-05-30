import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maximumGap(final List<Integer> nums) {
        int n = nums.size();
        int ans = 0;
        int[] suffix = new int[n];
        int j = 0;

        suffix[n - 1] = nums.get(n - 1);

        for (int i = n - 2; i >= 0; --i) {
            suffix[i] = Math.max(suffix[i + 1], nums.get(i));
        }

        for (int i = 0; i < n; ++i) {
            if (j == n) break;
            while (j < n && suffix[j] >= nums.get(i)) {
                ans = Math.max(ans, j - i);
                ++j;
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
            List<Integer> nums = new ArrayList<>();

            for (int i = 0; i < n; ++i) {
                int x = sc.nextInt();
                nums.add(x);
            }

            Solution solution = new Solution();
            System.out.println(solution.maximumGap(nums));
        }

        sc.close();
    }
}
