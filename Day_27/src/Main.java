import java.util.*;

class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> nums1, ArrayList<Integer> nums2, int k) {
        int n = nums1.size();
        int count = 0;
        HashSet<ArrayList<Integer>> visited = new HashSet<>();
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>((a, b) -> (b.get(0) - a.get(0)));
        ArrayList<Integer> ans = new ArrayList<>();

        Collections.sort(nums1);
        Collections.sort(nums2);

        pq.add(new ArrayList<>(Arrays.asList(nums1.get(n - 1) + nums2.get(n - 1), n - 1, n - 1)));
        visited.add(new ArrayList<>(Arrays.asList(n - 1, n - 1)));

        while (count < k) {
            ArrayList<Integer> current = pq.poll();
            assert current != null;
            int sum = current.get(0);
            int i = current.get(1);
            int j = current.get(2);
            ans.add(sum);
            ArrayList<Integer> firstNext = new ArrayList<>(Arrays.asList(i - 1, j));
            ArrayList<Integer> secondNext = new ArrayList<>(Arrays.asList(i, j - 1));
            if (!visited.contains(firstNext)) {
                visited.add(firstNext);
                pq.add(new ArrayList<>(Arrays.asList(nums1.get(i - 1) + nums2.get(j), i - 1, j)));
            }
            if (!visited.contains(secondNext)) {
                visited.add(secondNext);
                pq.add(new ArrayList<>(Arrays.asList(nums1.get(i) + nums2.get(j - 1), i, j - 1)));
            }
            ++count;
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
            ArrayList<Integer> nums1 = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                int x = sc.nextInt();
                nums1.add(x);
            }
            ArrayList<Integer> nums2 = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                int x = sc.nextInt();
                nums2.add(x);
            }
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.solve(nums1, nums2, k));
        }

        sc.close();
    }
}
