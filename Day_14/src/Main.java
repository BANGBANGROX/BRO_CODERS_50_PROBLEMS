import java.util.Scanner;

class Solution {
    public String minWindow(String a, String b) {
        int m = a.length();
        int n = b.length();
        int uniqueCharacters = 0;
        int start = 0;
        int end = m;
        int l = 0;
        int done = 0;
        int[] countInA = new int[256];
        int[] countInB = new int[256];

        for (int i = 0; i < n; ++i) {
            ++countInB[b.charAt(i)];
            if (countInB[b.charAt(i)] == 1) ++uniqueCharacters;
        }

        for (int r = 0; r < m; ++r) {
            ++countInA[a.charAt(r)];
            if (countInA[a.charAt(r)] == countInB[a.charAt(r)]) ++done;
            if (done == uniqueCharacters) {
                while (countInA[a.charAt(l)] > countInB[a.charAt(l)]) {
                    --countInA[a.charAt(l)];
                    ++l;
                }
                if (end - start > r - l) {
                    start = l;
                    end = r;
                }
            }
        }

        if (end == m) return "";

        return a.substring(start, end + 1);
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
            System.out.println(solution.minWindow(a, b));
        }

        sc.close();
    }
}
