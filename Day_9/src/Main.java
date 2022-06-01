import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    // DO NOT MODIFY BOTH THE LISTS
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        if (a.size() > b.size()) return findMedianSortedArrays(b, a);

        int m = a.size();
        int n = b.size();
        int l = 0;
        int r = m;

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            int idx = ((m + n + 1) / 2 - mid);
            int a1 = Integer.MIN_VALUE;
            int a2 = Integer.MAX_VALUE;
            int b1 = Integer.MIN_VALUE;
            int b2 = Integer.MAX_VALUE;
            if (mid > 0) a1 = a.get(mid - 1);
            if (mid < m) a2 = a.get(mid);
            if (idx > 0) b1 = b.get(idx - 1);
            if (idx < n) b2 = b.get(idx);
            if (a1 > b2) r = mid - 1;
            else if (b1 > a2) l = mid + 1;
            else {
                if ((m + n) % 2 == 0) return (Math.max(a1, b1) + Math.min(a2, b2)) * 1.0 / 2;
                return Math.max(a1, b1);
            }
        }

        return -1;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int m = sc.nextInt();
            ArrayList<Integer> a = new ArrayList<>();

            for (int i = 0; i < m; ++i) {
                int x = sc.nextInt();
                a.add(x);
            }

            int n = sc.nextInt();
            ArrayList<Integer> b = new ArrayList<>();

            for (int i = 0; i < n; ++i) {
                int x = sc.nextInt();
                b.add(x);
            }

            Solution solution = new Solution();
            System.out.println(solution.findMedianSortedArrays(a, b));
        }

        sc.close();
    }
}
