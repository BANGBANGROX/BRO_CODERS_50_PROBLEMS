import java.util.*;

class TestClass {
    static void makeLPS(String s, int[] lps) {
        int n = s.length();
        int l = 0;
        int i = 1;

        while (i < n) {
            if (s.charAt(i) == s.charAt(l)) {
                ++l;
                lps[i] = l;
                ++i;
            }
            else {
                if (l == 0) ++i;
                else l = lps[l - 1];
            }
        }
    }

    static int countOccurrences(String pattern, String text) {
        int n = pattern.length();
        int m = text.length();
        int i = 0;
        int j = 0;
        int ans = 0;
        int[] lps = new int[n];

        makeLPS(pattern, lps);

        while (i < m) {
            if (pattern.charAt(j) == text.charAt(i)) {
                ++j;
                ++i;
                if (j == n) {
                    ++ans;
                    j = lps[j - 1];
                }
            }
            else {
                if (j == 0) ++i;
                else j = lps[j - 1];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String pattern = sc.next();
        String text = sc.next();

        System.out.println(countOccurrences(pattern, text));
    }
}

