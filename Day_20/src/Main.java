import java.util.Scanner;

class Solution {
    public int divide(long A, long B) {
        int sign = (((A > 0 && B > 0) || (A < 0 && B < 0)) ? 1 : -1);
        long dividend = Math.abs(A);
        long divisor = Math.abs(B);
        long ans = 0;
        long temp = 0;

        for (long i = 31; i >= 0; --i) {
            if ((temp + (divisor << i)) <= dividend) {
                temp += divisor << i;
                ans |= ((long) 1 << i);
            }
        }

        ans *= sign;

        if (ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;

        if (ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return (int) ans;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            long A = sc.nextLong();
            long B = sc.nextLong();

            Solution solution = new Solution();
            System.out.println(solution.divide(A, B));
        }

        sc.close();
    }
}
