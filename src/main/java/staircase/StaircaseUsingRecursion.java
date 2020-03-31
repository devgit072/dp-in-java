package staircase;

/*
   Time complexity will be O(3^n).
   Space complexity is O(n) to store the recursion stack.
 */
public class StaircaseUsingRecursion {

    /*
    The concept of solution: If the n reaches 0, thats means we found one way to the stair, so it returns 1.
    If it n < 0, that means it is not a way to get the stair, so it returns 0.
     */
    static int getTotalNumberOfPossibleWays(int n) {
        if (n<0) {
            return 0;
        }
        if (n==0) {
            return 1;
        }

        // Either we take one stair, two stair or three stair.
        return getTotalNumberOfPossibleWays(n-1) + getTotalNumberOfPossibleWays(n-2) + getTotalNumberOfPossibleWays(n-3);
    }

    public static void main(String[] args) {
        System.out.println(getTotalNumberOfPossibleWays(3));
    }
}
