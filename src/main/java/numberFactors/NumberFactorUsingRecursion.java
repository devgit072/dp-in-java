package numberFactors;

/*
It is just like the usual fibonacci or staircase problem.

Time Complexity: O(3^n)
Space: O(n) to hold the O(n)
 */
public class NumberFactorUsingRecursion {

    static int getNumberOfWays(int n) {
        if (n<0) {
            return 0;
        }
        if (n==0) {
            return 1;
        }
        if (n==1) {
            return 1;
        }

        return getNumberOfWays(n-1) + getNumberOfWays(n-3) + getNumberOfWays(n-4);
    }

    public static void main(String[] args) {
        System.out.println(getNumberOfWays(5));
    }
}
