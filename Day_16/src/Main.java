import java.util.*;

class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> findSubstring(String s, final List<String> dictionary) {
        HashMap<String, Integer> count = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int n = s.length();
        int wordLength = dictionary.get(0).length();
        int m = dictionary.size();

        for (String word: dictionary) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < n; ++i) {
            if (m * wordLength + i > n) break;
            HashMap<String, Integer> currentCount = new HashMap<>();
            StringBuilder currentWord = new StringBuilder();
            for (int j = i; j < m * wordLength + i; ++j) {
                if (!currentWord.toString().equals("") && (j - i) % wordLength == 0) {
                    currentCount.put(currentWord.toString(), currentCount.getOrDefault(currentWord.toString(), 0) + 1);
                    currentWord = new StringBuilder();
                }
                currentWord.append(s.charAt(j));
            }
            if (!currentWord.toString().equals("")) {
                currentCount.put(currentWord.toString(), currentCount.getOrDefault(currentWord.toString(), 0) + 1);
            }
            boolean found = true;
            for (String word : currentCount.keySet()) {
                if (!count.containsKey(word) || !Objects.equals(count.get(word), currentCount.get(word))) {
                    found = false;
                    break;
                }
            }
            if (found) ans.add(i);
        }

        return ans;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();
            int n = sc.nextInt();
            List<String> dictionary = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                String x = sc.next();
                dictionary.add(x);
            }

            Solution solution = new Solution();
            System.out.println(solution.findSubstring(s, dictionary));
        }

        sc.close();
    }
}
