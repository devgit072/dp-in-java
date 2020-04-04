package minimumJump;

import java.util.Arrays;

/*
Time complexity will be O(n). We are using memoization, so there wont be more than O(n), computations.
For any given value, i, maximum one computation will be done, because we are storing the value.

Space Complexity: O(n). Precisely 2*O(n), one for memo and one for recursion stack.
 */
public class MinimumjumpUsingMemoization {

    // memo is array, which store minimum jump at position pos.
    static int minimumJump(int[] steps, int pos, int[] memo) {
        if (steps[pos] == 0) {
            return -1;
        }

        // If value is already calculated, then simply return.
        if (memo[pos] != -2) {
            return memo[pos];
        }

        int val = steps[pos];
        int n = steps.length;
        if (val >= n-pos-1) {
            memo[pos]=1;
            return 1;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= val; i++) {
            int minTemp = minimumJump(steps, pos + i, memo);
            if (minTemp == -1) {
                memo[pos] = -1;
                return -1;
            }

            if (minTemp + 1 < min) {
                min = minTemp + 1;
            }
        }
        memo[pos] = min;
        return memo[pos];
    }

    public static void main(String[] args) {
        //int[] arr = {2,1,1,1,4};
        int[] arr = {1,1,3,6,9,3,0,1,3};

        int[] memo = new int[arr.length];
        Arrays.fill(memo, -2);
        System.out.println(minimumJump(arr, 0, memo));
    }
}
