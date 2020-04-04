package minimumJump;

import java.util.Arrays;

/*
Note that the problem is to reach last index, not beyond last index.
 */

/*
Usually in tabulation, we go from front to end, but here intuitively we need to go from back to front.

Time complexity will be O(n^2) at worst though it will be better than O(n^2).
and
Space complexity: O(n)
 */
public class MinimumJumpUsingTabulation {

    static int minimumJump(int[] steps) {
        int[] cache = new int[steps.length];
        Arrays.fill(cache, -2);


        // we have to go from back to front

        int n = steps.length;

        // last element is already a destination. So number of steps required from last position to last position is always 0.
        cache[n-1] = 0;
        for (int i = n-2; i >=0 ; i--) {

            // Even if current value is 0, we must not return, because we are traversing from back to front.
            // May be there is no way to reach destination from i, but we are searching the minimum steps from position 0.
            // So from, i-1 or earlier, there will be steps to reach the last element.
            if (steps[i] == 0) {
                cache[i] = -1;
                continue;
            }
            // check if current position value is enough to reach end.
            if (steps[i] >= (n-i-1)) {
                cache[i] = 1;
                continue;
            }

            int min = Integer.MAX_VALUE;
            for (int k=1;k<=steps[i];k++) {
                if (cache[i+k] == -1) {
                    continue;
                }
                if (1+cache[i+k] < min) {
                    min = 1+cache[i+k];
                }
            }
            cache[i] = min;
        }
        return cache[0];
    }

    public static void main(String[] args) {
        //int[] arr = {2,1,1,1,4};
        int[] arr = {1,1,3,6,9,3,0,1,3};

        System.out.println(minimumJump(arr));
    }
}
