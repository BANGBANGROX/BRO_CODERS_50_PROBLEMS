import java.util.*;

class Solution {
    private ArrayList<ArrayList<Integer>> ans;
    private ArrayList<Integer> nums;
    private ArrayList<Integer> current;
    private HashSet<ArrayList<Integer>> visited;

    private void generate(int sum, int ind) {
        if (sum == 0) {
            if (!visited.contains(current)) {
                ans.add(new ArrayList<>(current));
                visited.add(new ArrayList<>(current));
            }
            return;
        }

        if (ind == nums.size() || sum < nums.get(ind)) return;

        // Take the current number
        current.add(nums.get(ind));
        generate(sum - nums.get(ind), ind);
        generate(sum - nums.get(ind), ind + 1);

        // Don't take the number
        current.remove(current.size() - 1);
        generate(sum, ind + 1);
    }

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> nums, int sum) {
        ans = new ArrayList<>();
        current = new ArrayList<>();
        visited = new HashSet<>();

        Collections.sort(nums);

        this.nums = nums;

        generate(sum, 0);

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
            int sum = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.combinationSum(nums, sum));
        }

        sc.close();
    }
}
