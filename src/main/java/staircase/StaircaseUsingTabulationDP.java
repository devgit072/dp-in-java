package staircase;

/*
DP using tabulation i.e botton up is best way to solve, because it does not involves recursive call and tough to solve
at start.

Time complexity will be O(n) and space complexity will be O(n)
 */
public class StaircaseUsingTabulationDP {

    static int getTotalNumberOfPossibleWays(int n) {
        if (n<0) {
            return 0;
        }

        int[] res = new int[n+1];
        res[0]=1;
        res[1]=1;
        res[2]=2;

        for (int i = 3;i<=n;i++) {
            res[i] = res[i-1] + res[i-2]+ res[i-3];
        }

        return res[n];
    }

    public static void main(String[] args) {
        System.out.println(getTotalNumberOfPossibleWays(3));
    }
}
