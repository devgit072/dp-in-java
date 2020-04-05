package knapsack01;

import java.util.Arrays;

public class Knapsack01Memoization {

    static int knapsack01(int[] profits, int[] weights, int pos, int capacity, int[] memo) {
        if (pos >= weights.length || capacity <= 0) {
            return 0;
        }
        if (memo[pos] != -1) {
            return memo[pos];
        }

        int val1 = 0;
        if (weights[pos] <= capacity) {
            val1 = profits[pos] + knapsack01(profits, weights, pos + 1, capacity - weights[pos], memo);
        }
        int val2 = knapsack01(profits, weights, pos + 1, capacity, memo);

        memo[pos] = Math.max(val1, val2);

        return memo[pos];
    }

    public static void main(String[] args) {
        // int[] weights = {6,3,1,4};
        int[] weights = {2,3,1,4};
        int[] profits = {4,5,3,7};

        int maxCapacity = 5;
        int[] memo = new int[weights.length];
        Arrays.fill(memo, -1);
        knapsack01(profits, weights, 0, maxCapacity, memo);
        // traverse the entire memoization.
        int max = Integer.MIN_VALUE;

        for (int i = 0;i<memo.length;i++) {
            if (max < memo[i]) {
                max = memo[i];
            }
        }
        System.out.println(max);
    }
}
