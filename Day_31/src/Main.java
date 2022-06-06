import java.util.Scanner;
import java.util.ArrayList;

class Solution {
    public int candy(ArrayList<Integer> rating) {
        int n = rating.size();
        int ans = 0;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = right[n - 1] = 1;

        for (int i = 1; i < n; ++i) {
            if (rating.get(i) > rating.get(i - 1)) left[i] = left[i - 1] + 1;
            else left[i] = 1;
        }

        for (int i = n - 2; i >= 0; --i) {
            if (rating.get(i) > rating.get(i + 1)) right[i] = right[i + 1] + 1;
            else right[i] = 1;
        }

        for (int i = 0; i < n; ++i) {
            ans += Math.max(left[i], right[i]);
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
            ArrayList<Integer> rating = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                int x = sc.nextInt();
                rating.add(x);
            }

            Solution solution = new Solution();
            System.out.println(solution.candy(rating));
        }

        sc.close();
    }
}
