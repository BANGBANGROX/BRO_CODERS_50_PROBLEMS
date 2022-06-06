import java.util.LinkedList;
import java.util.Scanner;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        LinkedList<Integer> minElements = new LinkedList<>();
        LinkedList<Integer> maxElements = new LinkedList<>();
        int i = 0;
        int j = 0;
        int ans = 0;
        int n = nums.length;

        while (j < n) {
            while (!minElements.isEmpty() && minElements.getLast() > nums[j]) {
                minElements.pollLast();
            }
            while (!maxElements.isEmpty() && maxElements.getLast() < nums[j]) {
                maxElements.pollLast();
            }
            minElements.addLast(nums[j]);
            maxElements.addLast(nums[j]);
            assert maxElements.peek() != null && minElements.peek() != null;
            if (maxElements.peek() - minElements.peek() <= limit) {
                ans = Math.max(ans, j - i + 1);
            }
            else {
                while (!maxElements.isEmpty() && !minElements.isEmpty() &&
                        maxElements.peek() - minElements.peek() > limit) {
                    if (minElements.peek() == nums[i]) minElements.poll();
                    assert maxElements.peek() != null && minElements.peek() != null;
                    if (maxElements.peek() == nums[i]) maxElements.poll();
                    ++i;
                }
            }
            ++j;
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
            int[] nums = new int[n];
            for (int i = 0; i < n; ++i) {
                nums[i] = sc.nextInt();
            }
            int limit = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.longestSubarray(nums, limit));
        }

        sc.close();
    }
}
