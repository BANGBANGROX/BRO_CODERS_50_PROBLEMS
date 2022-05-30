import java.util.Scanner;

class Solution {
    private final int mod = 1000003;

    private int factorial(int num) {
         int res = 1;

         while (num > 0) {
             res = (res * num) % mod;
             --num;
         }

         return res;
    }

    private void compute(String s, int[] count) {
        for (char ch : s.toCharArray()) {
            ++count[ch];
        }

        for (int i = 1; i < 256; ++i) {
            count[i] += count[i - 1];
        }
    }

    private void update(int[] count, char ch) {
        for (char c = ch; c < 256; ++c) {
            --count[c];
        }
    }

    private long binExp(long a, long b) {
        long res = 1;

        while (b > 0) {
            if (b % 2 == 1) {
                res = ((res % mod) * (a % mod)) % mod;
                --b;
            }
            a = ((a % mod) * (a % mod)) % mod;
            b /= 2;
        }

        //System.out.println(a + " " + b + " " + res);

        return res;
    }

    public int findRank(String s) {
        int n = s.length();
        long mul = factorial(n);
        long ans = 1;
        int[] count = new int[256];

        compute(s, count);

        //System.out.println(mul);

        for (int i = 0; i < n; ++i) {
            mul = (mul * binExp(n - i, mod - 2)) % mod;
            if ((int)s.charAt(i) == 0) {
                update(count, s.charAt(i));
                continue;
            }
            int currentChar = s.charAt(i);
            ans = (count[currentChar - 1] * mul + ans) % mod;
            update(count, s.charAt(i));
        }

        return (int) ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.findRank(s));
        }

        sc.close();
    }
}
