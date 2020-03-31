package staircase;

import java.util.Arrays;

/*
Time complexity: Though we are using, three recursive call, but still time complexity will be O(n), because we are using
memoization and we will be avoiding repetitive call and there will be total n computation, hence time complexity is O(n).
Space complexity will be O(n) to store the recursion stack.
Time complexity we can conclude O(n), also because memo[n], it is n long and there wont be more than n computations, because
we are storing the solution of subproblems.
 */
public class StaircaseUsingDPMemoization {
    static int getTotalNumberOfPossibleWays(int n, int[] memo) {

        if (n<0) {
            return 0;
        }

        if(memo[n] != -1) {
            return memo[n];
        }

        if (n==0) {
            memo[n]=1;
            return 1;
        }

        // Either we take one stair, two stair or three stair.
        int sol1 = getTotalNumberOfPossibleWays(n-1, memo);
        int sol2 = getTotalNumberOfPossibleWays(n-2, memo);
        int sol3 =  getTotalNumberOfPossibleWays(n-3, memo);
        int totalWays = sol1 + sol2 +sol3;
        memo[n] = totalWays;
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 3;
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);

        getTotalNumberOfPossibleWays(n, memo);
        System.out.println(memo[n]);

    }
}
