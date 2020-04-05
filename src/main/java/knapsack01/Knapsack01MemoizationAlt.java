package knapsack01;

import java.util.Arrays;

public class Knapsack01MemoizationAlt {

    static int knapsack01(int[] profits, int[] weights, int pos, int capacity, Integer[][] memo) {
        if (pos >= weights.length || capacity <= 0) {
            return 0;
        }
        if (memo[pos][capacity] != null) {
            return memo[pos][capacity];
        }

        int val1 = 0;
        if (weights[pos] <= capacity) {
            val1 = profits[pos] + knapsack01(profits, weights, pos+1, capacity - weights[pos], memo);
        }
        int val2 = knapsack01(profits, weights, pos + 1, capacity, memo);

        memo[pos][capacity] = Math.max(val1, val2);

        return memo[pos][capacity];
    }

    public static void main(String[] args) {
        //int[] weights = {2,3,1,4};
        int[] weights = {6,3,1,4};
        int[] profits = {4,5,3,7};

        int maxCapacity = 5;
        Integer[][] memo = new Integer[weights.length][maxCapacity+1];


        System.out.println(knapsack01(profits, weights, 0, maxCapacity, memo));

        System.out.println(memo[0][maxCapacity]);
    }
}
