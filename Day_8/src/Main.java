import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    public int firstMissingPositive(ArrayList<Integer> nums) {
        int n = nums.size();

        for (int i = 0; i < n; ++i) {
            while (nums.get(i) > 0 && nums.get(i) < n && nums.get(i) != i + 1 &&
                    nums.get(i) != nums.get(nums.get(i) - 1)) {
                int x = nums.get(i);
                nums.set(i, nums.get(x - 1));
                nums.set(x - 1, x);
            }
        }

        for (int i = 0; i < n; ++i) {
            if (nums.get(i) != i + 1) return i + 1;
        }

        return n + 1;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            ArrayList<Integer> nums = new ArrayList<>();

            for (int i = 0; i < n; ++i) {
                int x = sc.nextInt();
                nums.add(x);
            }

            Solution solution = new Solution();
            System.out.println(solution.firstMissingPositive(nums));
        }

        sc.close();
    }
}
