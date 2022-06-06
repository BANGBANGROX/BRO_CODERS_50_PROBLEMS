import java.util.*;

class Solution {
    public ArrayList<Integer> nextGreater(ArrayList<Integer> nums) {
        int n = nums.size();
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = n - 1; i >= 0; --i) {
            while (!st.isEmpty() && nums.get(st.peek()) <= nums.get(i)) {
                st.pop();
            }
            if (st.isEmpty()) ans.add(-1);
            else ans.add(nums.get(st.peek()));
            st.push(i);
        }

        Collections.reverse(ans);

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

            Solution solution = new Solution();
            System.out.println(solution.nextGreater(nums));
        }

        sc.close();
    }
}
