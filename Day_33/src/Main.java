import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    private int k;

    private int findIndex(int n) {
        if (n == 0) return 0;

        int factorial = n;

        --n;

        while (k >= factorial && n > 1) {
            factorial *= n;
            --n;
        }

        int index = k / factorial;

        k %= factorial;

        return index;
    }

    private String getPermutation(ArrayList<Integer> nums) {
        if (nums.size() == 0) return "";

        int x = findIndex(nums.size() - 1);
        String ans = String.valueOf(nums.get(x));

        nums.remove(x);

        return ans + getPermutation(nums);
    }

    public String getPermutation(int n, int k) {
        ArrayList<Integer> nums = new ArrayList<>();

        for (int i = 1; i <= n; ++i) {
            nums.add(i);
        }

        this.k = k;

        --this.k;

        return getPermutation(nums);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.getPermutation(n, k));
        }

        sc.close();
    }
}
