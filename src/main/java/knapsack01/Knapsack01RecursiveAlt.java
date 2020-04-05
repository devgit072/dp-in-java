package knapsack01;

public class Knapsack01RecursiveAlt {

    static int knapsack01(int[] weights, int[] profits, int pos, int capacity) {
        if (pos >= weights.length || capacity <= 0) {
            return 0;
        }

        // Include current element based on condition.
        int val1 = 0;
        if (weights[pos] <= capacity) {
            val1 = profits[pos] + knapsack01(weights, profits, pos + 1, capacity-weights[pos]);
        }
        // Do not include the current element.
        int val2 = knapsack01(weights, profits, pos + 1, capacity);

        return Math.max(val1, val2);
    }

    public static void main(String[] args) {
        // int[] weights = {6,3,1,4};
        int[] weights = {2,3,1,4};
        int[] profits = {4,5,3,7};

        int maxCapacity = 5;

        System.out.println(knapsack01(weights, profits, 0, maxCapacity));
    }
}
