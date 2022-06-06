import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
    public int minimumDeviation(int[] nums) {
        int ans = Integer.MAX_VALUE;
        int minimumValue = Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));

        for (int num : nums) {
            if ((num & 1) > 0) num *= 2;
            pq.add(num);
            minimumValue = Math.min(minimumValue, num);
        }

        while (!pq.isEmpty() && (pq.peek() & 1) == 0) {
            ans = Math.min(ans, pq.peek() - minimumValue);
            int top = pq.poll();
            minimumValue = Math.min(minimumValue, top / 2);
            pq.add(top / 2);
        }

        assert !pq.isEmpty();
        ans = Math.min(ans, pq.peek() - minimumValue);

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; ++i) {
                nums[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.minimumDeviation(nums));
        }

        sc.close();
    }
}
