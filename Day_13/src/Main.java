import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> nums, int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        HashSet<ArrayList<Integer>> taken = new HashSet<>();
        int n = nums.size();

        Collections.sort(nums);

        for (int i = 0; i < n - 3; ++i) {
            if (nums.get(i) > target) break;
            int requiredSum = target - nums.get(i);
            for (int j = i + 1; j < n - 2; ++j) {
                int l = j + 1;
                int r = n - 1;
                requiredSum -= nums.get(j);
                while (l < r) {
                    int currentSum = nums.get(l) + nums.get(r);
                    if (currentSum == requiredSum) {
                        ArrayList<Integer> currentResult =
                                new ArrayList<>(Arrays.asList(nums.get(i), nums.get(j), nums.get(l), nums.get(r)));
                        if (!taken.contains(currentResult)) {
                            ans.add(new ArrayList<>(currentResult));
                            taken.add(new ArrayList<>(currentResult));
                        }
                        ++l;
                        --r;
                    }
                    else if (currentSum > requiredSum) --r;
                    else ++l;
                }
                requiredSum += nums.get(j);
            }
        }

        return ans;
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
            int target = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.fourSum(nums, target));
        }

        sc.close();
    }
}
