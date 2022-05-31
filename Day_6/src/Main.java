import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    public int solve(ArrayList<Integer> nums) {
        int n = nums.size();

        if (n == 1) return 1;

        int[] prefixEvenSum = new int[n];
        int[] prefixOddSum = new int[n];
        int[] suffixEvenSum = new int[n];
        int[] suffixOddSum = new int[n];
        int ans = 0;

        prefixEvenSum[0] = nums.get(0);

        for (int i = 1; i < n; ++i) {
            if (i % 2 == 1) {
                prefixEvenSum[i] = prefixEvenSum[i - 1];
                prefixOddSum[i] = prefixOddSum[i - 1] + nums.get(i);
            }
            else {
                prefixEvenSum[i] = prefixEvenSum[i - 1] + nums.get(i);
                prefixOddSum[i] = prefixOddSum[i - 1];
            }
        }

        if ((n - 1) % 2 == 1) {
            suffixOddSum[n - 1] = nums.get(n - 1);
        }
        else {
            suffixEvenSum[n - 1] = nums.get(n - 1);
        }

        for (int i = n - 2; i >= 0; --i) {
            if (i % 2 == 1) {
                suffixEvenSum[i] = suffixEvenSum[i + 1];
                suffixOddSum[i] = suffixOddSum[i + 1] + nums.get(i);
            }
            else {
                suffixEvenSum[i] = suffixEvenSum[i + 1] + nums.get(i);
                suffixOddSum[i] = suffixOddSum[i + 1];
            }
        }

        // If we remove index i we take even and odd sum of prefix(i-1) as it is but swap the odd and even sum
        // of suffix(i+1)

        // For index 0 only suffix case
        if (suffixEvenSum[1] == suffixOddSum[1]) ++ans;

        // For index n - 1 only prefix case
        if (prefixEvenSum[n - 2] == prefixOddSum[n - 2]) ++ans;

        for (int i = 1; i < n - 1; ++i) {
            if (prefixEvenSum[i - 1] + suffixOddSum[i + 1] == prefixOddSum[i - 1] + suffixEvenSum[i + 1]) {
                ++ans;
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
            ArrayList<Integer> nums = new ArrayList<>();

            for (int i = 0; i < n; ++i) {
                int x = sc.nextInt();
                nums.add(x);
            }

            Solution solution = new Solution();
            System.out.println(solution.solve(nums));
        }

        sc.close();
    }
}
