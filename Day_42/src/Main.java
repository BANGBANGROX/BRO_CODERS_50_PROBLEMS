import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxProduct(final List<Integer> nums) {
        int minProduct = Integer.MAX_VALUE;
        int maxProduct = Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num < 0) {
                int temp = minProduct;
                minProduct = maxProduct;
                maxProduct = temp;
            }
            minProduct = Math.min(num, minProduct * num);
            maxProduct = Math.max(num, maxProduct * num);
            ans = Math.max(ans, maxProduct);
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
            System.out.println(solution.maxProduct(nums));
        }

        sc.close();
    }
}
