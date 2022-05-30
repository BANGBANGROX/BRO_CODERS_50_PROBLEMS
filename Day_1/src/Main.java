import java.util.Scanner;

class Solution {
    public int isPower(int num) {
         if (num == 1) return 1;

         for (int i = 2; i * i <= num; ++i) {
             double v = Math.log10(num) / Math.log10(i);
             if (v == Math.floor(v)) return 1;
         }

         return 0;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int num = sc.nextInt();

            Solution solution = new Solution();
            if (solution.isPower(num) == 1) {
                System.out.println("true");
            }
            else {
                System.out.println("false");
            }
        }

        sc.close();
    }
}
