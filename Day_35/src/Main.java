// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.count(N));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    private int[] dp;

    private int countUtil(int n) {
        if (n % 2 == 1) return 0;

        if (n == 0) return 1;

        if (dp[n] != -1) return dp[n];

        int ans = 0;

        for (int i = 0; i < n; i += 2) {
            ans += countUtil(i) * countUtil(n - i - 2);
        }

        return dp[n] = ans;
    }

    public int count(int n) {
        // code here
        dp = new int[n + 1];

        Arrays.fill(dp, -1);

        return countUtil(n);
    }
}