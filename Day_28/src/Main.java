import java.util.*;

class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> nums, int k) {
        int n = nums.size();
        int[] pos = new int[n + 1];
        int[] numsArray = new int[n];

        for (int i = 0; i < n; ++i) {
            pos[nums.get(i)] = i;
            numsArray[i] = nums.get(i);
        }

        for (int i = 0; i < n && k > 0; ++i) {
            if (nums.get(i) == n - i) continue;
            int temp = pos[n - i];
            pos[numsArray[i]] = pos[n - i];
            pos[n - i] = i;
            int x = numsArray[temp];
            numsArray[temp] = numsArray[i];
            numsArray[i] = x;
            --k;
        }

        nums.clear();

        for (int i = 0; i < n; ++i) {
            nums.add(numsArray[i]);
        }

        return nums;
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
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.solve(nums, k));
        }

        sc.close();
    }
}
