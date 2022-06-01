import java.util.*;

class Solution {
    private int lowerBound(ArrayList<Integer> nums, int key) {
        int n = nums.size();
        int l = 0;
        int r = n - 1;
        int ans = -1;

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            if (nums.get(mid) <= key) {
                l = mid + 1;
                ans = mid;
            }
            else {
                r = mid - 1;
            }
        }

        return ans;
    }

    public int findMedian(ArrayList<ArrayList<Integer>> matrix) {
        int m = matrix.size();
        int n = matrix.get(0).size();
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        int target = (m * n + 1) / 2;

        for (ArrayList<Integer> integers : matrix) {
            for (int j = 0; j < n; ++j) {
                maxValue = Math.max(maxValue, integers.get(j));
                minValue = Math.min(minValue, integers.get(j));
            }
        }

        while (maxValue > minValue) {
            int mid = (minValue + ((maxValue - minValue) >> 1));
            int lesserAndEqual = 0;
            for (ArrayList<Integer> integers : matrix) {
                int curr = lowerBound(integers, mid);
                lesserAndEqual += (curr + 1);
            }
            if (lesserAndEqual >= target) maxValue = mid;
            else minValue = mid + 1;
        }

        return minValue;
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
            System.out.println(solution.findMedian(matrix));
        }

        sc.close();
    }
}
