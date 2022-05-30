import java.util.Scanner;

class Solution {
    public int solve(int target) {
        int sum = 0;
        int move = 1;

        if (target == 0) return 0;

        target = Math.abs(target);

        while (sum < target) {
            sum += move;
            ++move;
        }

        if ((sum - target) % 2 == 0) return move - 1;

        if ((sum + move - target) % 2 == 0) return move;

        return move + 1;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int target = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.solve(target));
        }

        sc.close();
    }
}
