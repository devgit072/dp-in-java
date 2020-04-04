package minimumCost;

import java.util.Arrays;

/*
Memoization is easiest way to solve DP.

Time Complexity: O(n), because for value n, there will be no more than 1 computation, because we are caching the value.

Space complexity: O(n) to store the recursion stack.
 */
public class MinimumCostUsingMemoization {

    static int minimumCostsUsingMemoization(int[] costs, int pos, int[] memo) {

        if (pos >= costs.length) {
            return 0;
        }

        if (memo[pos] != -1) {
            return memo[pos];
        }

        int minimumCost =  costs[pos] + minimumOf(
                minimumCostsUsingMemoization(costs, pos+1, memo),
                minimumCostsUsingMemoization(costs, pos+2, memo),
                minimumCostsUsingMemoization(costs, pos+3, memo));

        memo[pos] = minimumCost;
        return memo[pos];
    }

    private static int minimumOf(int val1, int val2, int val3) {
        return Math.min(Math.min(val1, val2), val3);
    }

    public static void main(String[] args) {
        int[] costs = {1,2,5,2,1,2};
        //int[] costs = {2,3,4,5};

        int[] memo = new int[costs.length];
        Arrays.fill(memo, -1);
        System.out.println(minimumCostsUsingMemoization(costs, 0, memo));
    }
}
