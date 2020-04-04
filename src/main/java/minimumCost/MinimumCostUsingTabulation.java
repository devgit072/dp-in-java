package minimumCost;

/*
Time complexity will be O(n)
Space complexity will be O(n)
 */
public class MinimumCostUsingTabulation {

    static int minimumCostUsingTabulation(int[] costs) {
        int n = costs.length;
        int[] cache = new int[n];

        // we go from back to front.
        for (int i = n-1;i>=0;i--) {
            // If from current position we can go beyond the last element then no need to check cache for further elements,
            // because we will go beyond from current position only.
            if (i+3 >=n || i+2 >= n || i+1 >= n) {
                cache[i] = costs[i];
                continue;
            }
            int minTemp = Math.min(Math.min(cache[i+1], cache[i+2]), cache[i+3]);
            cache[i] = costs[i] + minTemp;
        }

        return cache[0];
    }

    public static void main(String[] args) {
        int[] costs = {1,2,5,2,1,2};
        //int[] costs = {2,3,4,5};
        System.out.println(minimumCostUsingTabulation(costs));
    }
}
