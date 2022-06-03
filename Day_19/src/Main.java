import java.util.*;

class Solution {
    private int[] makeLPS(String s) {
        int n = s.length();
        int[] lps = new int[n];

        for (int i = 1; i < n; ++i) {
            int len = lps[i - 1];
            while (len > 0 && s.charAt(i) != s.charAt(len)) {
                len = lps[len - 1];
            }
            if (s.charAt(i) == s.charAt(len)) ++len;
            lps[i] = len;
        }

        return lps;
    }

    private int binExp(long a, long b, long mod) {
        long res = 1;

        while (b > 0) {
            if ((b & 1) > 0) {
                res = (res * a) % mod;
                --b;
            }
            a = (a * a) % mod;
            b /= 2;
        }

        return (int) res;
    }

    private int findLCM(int[] nums) {
        long ans = 1;
        long mod = (long) 1e9 + 7;
        HashMap<Integer, Integer> commonFactors = new HashMap<>();

        for (int num : nums) {
            for (int i = 2; i * i <= num; ++i) {
                int count = 0;
                while (num % i == 0) {
                    ++count;
                    num /= i;
                }
                if (count > 0) {
                    commonFactors.put(i, Math.max(commonFactors.getOrDefault(i, 0), count));
                }
            }
            if (num > 1) {
                commonFactors.put(num, Math.max(commonFactors.getOrDefault(num, 0), 1));
            }
        }

        for (int primeFactor : commonFactors.keySet()) {
            ans = (ans * binExp(primeFactor, commonFactors.get(primeFactor), mod)) % mod;
        }

        return (int) ans;
    }

    public int solve(ArrayList<String> strs) {
            int[] nums = new int[strs.size()];

            for (int i = 0; i < strs.size(); ++i) {
                String s = strs.get(i);
                int n = s.length();
                int[] lps = makeLPS(s);
                int last = lps[n - 1];
                int maxSteps = n;
                int operations = 1;
                int sum = 1;
                if (n % (n - last) == 0) maxSteps = n - last;
                while (sum % maxSteps != 0) {
                    ++operations;
                    sum += operations;
                }
                nums[i] = operations;
            }

            return findLCM(nums);
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            ArrayList<String> strs = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                String x = sc.next();
                strs.add(x);
            }

            Solution solution = new Solution();
            System.out.println(solution.solve(strs));
        }

        sc.close();
    }
}
