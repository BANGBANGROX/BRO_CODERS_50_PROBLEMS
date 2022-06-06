import java.util.Scanner;

class Solution {
    private int getReverse(int n) {
        int ans = 0;

        while (n > 0) {
            int lsb = (n & 1);
            ans |= lsb;
            ans <<= 1;
            n >>= 1;
        }

        ans >>= 1;

        return ans;
    }

    public int solve(int n) {
        int len = 1;
        int count = 1;

        while (count < n) {
            ++len;
            int elementsOfLen = (1 << (len - 1) / 2);
            count += elementsOfLen;
        }

        count -= (1 << (len - 1) / 2);

        int offset = (n - count - 1);
        int ans = (1 << (len - 1));

        ans |= (offset << (len / 2));

        int valueFR = (ans >> (len / 2));
        int reverse = getReverse(valueFR);

        ans |= reverse;

        return ans;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.solve(n));
        }

        sc.close();
    }
}
