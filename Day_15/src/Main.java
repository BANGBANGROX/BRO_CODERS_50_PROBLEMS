import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int threeSumMulti(int[] arr, int target) {
         int n = arr.length;
         final long mod = (long) 1e9 + 7;
         long ans = 0;

         Arrays.sort(arr);

         for (int i = 0; i < n - 1; ++i) {
             int requiredSum = target - arr[i];
             if (requiredSum < 0) break;
             int l = i + 1;
             int r = n - 1;
             while (l < r) {
                 int currentSum = arr[l] + arr[r];
                 if (currentSum == requiredSum) {
                     int prevL = l;
                     int prevR = r;
                     while (r - 1 > l && arr[r] == arr[r - 1]) --r;
                     while (l + 1 < r && arr[l] == arr[l + 1]) ++l;
                     if (arr[l] == arr[r]) {
                         long totalCount = prevR - r + l - prevL + 2;
                         ans = (ans + totalCount * (totalCount - 1) / 2) % mod;
                     }
                     else {
                         long totalCount = ((long) prevR - r + 1) * ((long) l - prevL + 1);
                         ans = (ans + totalCount) % mod;
                     }
                     ++l;
                     --r;
                 }
                 else if (currentSum > requiredSum) --r;
                 else ++l;
             }
         }

         return (int) ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; ++i) {
                arr[i] = sc.nextInt();
            }

            int target = sc.nextInt();
            Solution solution = new Solution();
            System.out.println(solution.threeSumMulti(arr, target));
        }

        sc.close();
    }
}
