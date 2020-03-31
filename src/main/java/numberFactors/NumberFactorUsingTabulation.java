package numberFactors;

/*
Time complexity: O(n)
Space complexity: O(n)
 */
public class NumberFactorUsingTabulation {

    static int getTotalWays(int n) {
        if (n==0) {
            return 1;
        }

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3;i<=n;i++) {
            int v1 = dp[i-1];
            int v2 = dp[i-3];
            int v3 = 0;
            if (i-4 >= 0) {
                v3 = dp[i-4];
            }
            dp[i] = v1 + v2 + v3;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(getTotalWays(4));
    }
}
