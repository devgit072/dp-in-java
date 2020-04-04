package minimumCost;

/*
Time complexity will be O(3^n), because for same value n, 3 recursive call is made and so on.
Space complexity: O(n) to store the recursion stack.
 */
public class MinimumCostUsingRecursion {

    static int minimumCostUsingRecursion(int[] costs, int pos) {
        if (pos >= costs.length) {
            return 0;
        }

        return costs[pos] + minimumOf(
                minimumCostUsingRecursion(costs, pos+1),
                minimumCostUsingRecursion(costs, pos+2),
                minimumCostUsingRecursion(costs, pos+3));
    }

    private static int minimumOf(int val1, int val2, int val3) {
            return Math.min(Math.min(val1, val2), val3);
    }

    public static void main(String[] args) {
        //int[] costs = {1,2,5,2,1,2};
        int[] costs = {2,3,4,5};
        System.out.println(minimumCostUsingRecursion(costs, 0));
    }
}
