import java.util.*;

class Solution {
    private int upperBound(List<Integer> nums, int key) {
        int n = nums.size();
        int l = 0;
        int r = n - 1;
        int ans = n - 1;

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            if (nums.get(mid) > key) {
                ans = mid;
                r = mid - 1;
            }
            else l = mid + 1;
        }

        return ans;
    }

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int minimize(final List<Integer> a, final List<Integer> b, final List<Integer> c) {
        int ans = Integer.MAX_VALUE;

        for (int val1 : a) {
            int idx1 = upperBound(b, val1);
            int idx2 = upperBound(c, val1);
            int val2 = b.get(idx1);
            int val3 = c.get(idx2);
            ans = Math.min(ans, Math.max(Math.abs(val1 - val2), Math.max(Math.abs(val2 - val3),
                    Math.abs(val1 - val3))));
            if (idx1 == 0 && idx2 == 0) continue;
            else if (idx1 == 0) {
                val3 = c.get(idx2 - 1);
                ans = Math.min(ans, Math.max(Math.abs(val1 - val2), Math.max(Math.abs(val2 - val3),
                        Math.abs(val1 - val3))));
            } else if (idx2 == 0) {
                val2 = b.get(idx1 - 1);
                ans = Math.min(ans, Math.max(Math.abs(val1 - val2), Math.max(Math.abs(val2 - val3),
                        Math.abs(val1 - val3))));
            } else {
                val3 = c.get(idx2 - 1);
                ans = Math.min(ans, Math.max(Math.abs(val1 - val2), Math.max(Math.abs(val2 - val3),
                        Math.abs(val1 - val3))));
                val3 = c.get(idx2);
                val2 = b.get(idx1 - 1);
                ans = Math.min(ans, Math.max(Math.abs(val1 - val2), Math.max(Math.abs(val2 - val3),
                        Math.abs(val1 - val3))));
                val3 = c.get(idx2 - 1);
                ans = Math.min(ans, Math.max(Math.abs(val1 - val2), Math.max(Math.abs(val2 - val3),
                        Math.abs(val1 - val3))));
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
            List<Integer> a = new ArrayList<>();
            for (int i = 0; i < m; ++i) {
                int x = sc.nextInt();
                a.add(x);
            }
            int n = sc.nextInt();
            List<Integer> b = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                int x = sc.nextInt();
                b.add(x);
            }
            int o = sc.nextInt();
            List<Integer> c = new ArrayList<>();
            for (int i = 0; i < o; ++i) {
                int x = sc.nextInt();
                c.add(x);
            }

            Solution solution = new Solution();
            System.out.println(solution.minimize(a, b, c));
        }

        sc.close();
    }
}
