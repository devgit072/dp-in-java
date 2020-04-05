package equalSubset;

/*
THis is top-down memoization approach. Why do we call it top-down?
Because in recursive call, for highest value value only, results are calculated.

Time-Complexity: O(n*C), for each value of POS and sum, computations will be done.
Space: O(N*C), where C is total sum.
 */
public class EqualSubsetUsingMemoization {

    static boolean equalSubsetUsingMemoizationUtil(int[] arr, int pos, int totalSum, int currSum, Boolean[][] memo) {
        if (pos >= arr.length) {
            return false;
        }

        if (currSum <= 0) {
            return false;
        }

        if (currSum * 2 == totalSum) {
            memo[pos][currSum] = true;
            return true;
        }
        if (memo[pos][currSum] != null) {
            return memo[pos][currSum];
        }

        memo[pos][currSum] = equalSubsetUsingMemoizationUtil(arr, pos+1, totalSum, currSum - arr[pos], memo) ||
                equalSubsetUsingMemoizationUtil(arr, pos +1, totalSum, currSum, memo);
        return memo[pos][currSum];
    }

    static boolean equalSubsetUsingMemoization(int[] arr) {
        int totalSum = 0;
        for (int a : arr) {
            totalSum += a;
        }
        Boolean[][] memo = new Boolean[arr.length][totalSum + 1];
        // Fill 0 for sum=0 in memo
        for (int i = 0; i < arr.length; i++) {
            memo[i][0] = false;
        }

        boolean val = equalSubsetUsingMemoizationUtil(arr, 0, totalSum, totalSum, memo);
        System.out.println(val);
        return memo[0][totalSum];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6};
        //int[] arr = {1, 2, 3, 4, 6, 20};
        //int[] arr = {2, 3, 4, 6};

        System.out.println(equalSubsetUsingMemoization(arr));
    }

}
