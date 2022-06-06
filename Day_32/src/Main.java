import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < expression.length(); ++i) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-' ||
                    expression.charAt(i) == '*' || expression.charAt(i) == '/') {
                List<Integer> ans1 = diffWaysToCompute(expression.substring(0, i));
                List<Integer> ans2 = diffWaysToCompute(expression.substring(i + 1));
                for (int x : ans1) {
                    for (int y : ans2) {
                        if (expression.charAt(i) == '+') ans.add(x + y);
                        else if (expression.charAt(i) == '-') ans.add(x - y);
                        else if (expression.charAt(i) == '*') ans.add(x * y);
                        else ans.add(x / y);
                    }
                }
            }
        }

        if (ans.size() == 0) ans.add(Integer.parseInt(expression));

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String expression = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.diffWaysToCompute(expression));
        }

        sc.close();
    }
}
