package housethief;
/*
Given a number array representing the wealth of ‘n’ houses, determine the maximum amount of money the thief can steal.
They can't steal from consecutive houses.

Input: {2, 5, 1, 3, 6, 2, 4}
Output: 15
Explanation: The thief should steal from houses 5 + 6 + 4

Input: {2, 10, 14, 8, 1}
Output: 18
Explanation: The thief should steal from houses 10 + 8
 */
public class HouseThiefWithRecursion {

    static int getMaximumSteal(int[] houseValues, int curr) {
        int n = houseValues.length;
        if (n==0) {
            return 0;
        }

        if (curr >= n) {
            return 0;
        }

        int maxValue = Integer.MIN_VALUE;
        for(int i=curr;i<n;i++) {
            int val1 = houseValues[i] + getMaximumSteal(houseValues, i+2);
            int val2=0;
            if (i+1 < n) {
                val2 = houseValues[i+1] + getMaximumSteal(houseValues, i+3);
            }

            int maxLocal = Math.max(val1, val2);
            maxValue = Math.max(maxLocal, maxValue);
        }

        return maxValue;

    }

    public static void main(String[] args) {
        int[] arr1 = {2, 5, 1, 3, 6, 2, 4};
        int[] arr = {2, 10, 14, 8, 1};
        System.out.println(getMaximumSteal(arr, 0));
    }
}
