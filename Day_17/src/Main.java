import java.util.Scanner;

class Solution {
    public String multiply(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[] res = new int[m + n];
        StringBuilder ans = new StringBuilder();

        for (int i = m - 1; i >= 0; --i) {
            int carry = 0;
            for (int j = n - 1; j >= 0; --j) {
                int temp = res[i + j + 1] + (a.charAt(i) - '0') * (b.charAt(j) - '0') + carry;
                res[i + j + 1] = temp % 10;
                carry = temp / 10;
            }
            res[i] = carry;
        }

        for (int i = 0; i < m + n; ++i) {
            if ((ans.length() == 0) && res[i] == 0) continue;
            ans.append(res[i]);
        }

        if (ans.length() == 0) return "0";

        return ans.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String a = sc.next();
            String b = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.multiply(a, b));
        }

        sc.close();
    }
}
