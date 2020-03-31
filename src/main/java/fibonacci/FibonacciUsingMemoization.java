package fibonacci;

import java.util.Arrays;

/*
Time complexity will be O(n). It looks O(2^n), but since we are caching the result, same value is not getting calculated twice.
Space complexity will be O(n). Precisely O(n)+O(n), one O(n) for memoization.
 */

public class FibonacciUsingMemoization {

    static int fiboUsingMemo(int n, int[] memo) {
        if (memo[n] != -1) {
            return memo[n];
        }
        if (n==0 || n==1) {
            memo[n] = n;
            return memo[n];
        }
        int nThFibo = fiboUsingMemo(n-1, memo) + fiboUsingMemo(n-2, memo);
        memo[n] = nThFibo;
        return memo[n];
    }

    public static void main(String[] args) {
       int n = 10;
       int[] memo = new int[n+1];
       Arrays.fill(memo, -1);
        System.out.println(fiboUsingMemo(n,memo));
    }
}
