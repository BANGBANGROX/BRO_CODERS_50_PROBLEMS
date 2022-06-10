import java.util.*;

class Solution {
    public int fibSum(int target) {
        if (target == 0) return 0;

        ArrayList<Integer> fibonacciNumbers = new ArrayList<>();
        int current = 2;
        int previous = 1;
        int ans = 0;

        fibonacciNumbers.add(1);
        fibonacciNumbers.add(1);

        while (current <= target) {
            fibonacciNumbers.add(current);
            int next = current + previous;
            previous = current;
            current = next;
        }

        int i = fibonacciNumbers.size() - 1;

        while (target > 0) {
            if (target >= fibonacciNumbers.get(i)) {
                ++ans;
                target -= fibonacciNumbers.get(i);
            }
            --i;
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int target = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.fibSum(target));
        }

        sc.close();
    }
}
