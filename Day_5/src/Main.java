import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maximumGap(final List<Integer> nums) {
        int n = nums.size();

        if (n < 2) return 0;

        ArrayList<Integer>[] buckets = new ArrayList[n];
        int maxElement = Integer.MIN_VALUE;
        int minElement = Integer.MAX_VALUE;

        for (int num : nums) {
            maxElement = Math.max(maxElement, num);
            minElement = Math.min(minElement, num);
        }

        double gap = (maxElement - minElement) * 1.0 / (n - 1);
        gap = Math.max(gap, 1.0);

        for (int i = 0; i < n; ++i) {
            buckets[i] = new ArrayList<>(Arrays.asList(Integer.MAX_VALUE, Integer.MIN_VALUE));
        }

        for (int num : nums) {
            int ind = (num - minElement) / (int) gap;
            buckets[ind].set(0, Math.min(buckets[ind].get(0), num));
            buckets[ind].set(1, Math.max(buckets[ind].get(1), num));
        }

        int previousMax = Integer.MIN_VALUE;
        int ans = 0;

        for (int i = 0; i < n; ++i) {
            if (buckets[i].get(0) == Integer.MAX_VALUE) continue;
            ans = Math.max(ans, buckets[i].get(0) - previousMax);
            previousMax = buckets[i].get(1);
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
