import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    public int seats(String seated) {
        ArrayList<Integer> filled = new ArrayList<>();
        int n = seated.length();

        for (int i = 0; i < n; ++i) {
            if (seated.charAt(i) == 'x') {
                filled.add(i);
            }
        }

        if (filled.size() == 0) return 0;

        int medianPos = filled.size() / 2;
        int median = filled.get(medianPos);
        int leftPos = median - 1;
        int rightPos = median + 1;
        int ans = 0;
        final int MOD = 10000003;

        for (int i = medianPos - 1; i >= 0; --i) {
             ans = (leftPos - filled.get(i) + ans + MOD) % MOD;
             --leftPos;
        }

        for (int i = medianPos + 1; i < filled.size(); ++i) {
            ans = (ans + filled.get(i) - rightPos + MOD) % MOD;
            ++rightPos;
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String seated = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.seats(seated));
        }

        sc.close();
    }
}
