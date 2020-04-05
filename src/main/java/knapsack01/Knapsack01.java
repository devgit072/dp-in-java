package knapsack01;


/*
Time complexity will be O(2^n), because for every value n, two recursive call is made.

Space complexity: O(n) to hold the recursion stack.
 */
public class Knapsack01 {

    /*
    How to solve: Either include current element and move forward. Include current element only if weight doesnt exceeds total capacity.
    OR
    Do not include current element and move forward.
     */
    static int getMaximumProfit(int[] weights, int[] profits, int capacity, int pos, int weightSoFar, int profitSoFar) {
        if (pos >= weights.length) {
            return profitSoFar;
        }


        // Either select current element or do not select .i.e 0 or 1
        int val1 = getMaximumProfit(weights, profits, capacity, pos+1, weightSoFar, profitSoFar);
        int val2 = -1;
        // if current weight plus previous weight is greater than capacity, then do not include it.
        if (weightSoFar + weights[pos] <= capacity) {
            val2 = getMaximumProfit(weights, profits, capacity, pos+1, weightSoFar+weights[pos], profitSoFar+profits[pos]);
        }

        return Math.max(val1, val2);
    }

    public static void main(String[] args) {
        int[] weights = {6,3,1,4};
        //int[] weights = {2,3,1,4};
        int[] profits = {4,5,3,7};

        int maxCapacity = 5;

        System.out.println(getMaximumProfit(weights, profits, maxCapacity, 0, 0, 0));
    }
}
