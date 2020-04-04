package minimumJump;
/*
The time complexity is O(2^n). How?
The in given function code snippet, the for loop will have n iterations and in each iterations function calls itself.
The time complexity of below code snippet will O(n)
func foo(n) {
    foo(n-1);
}

BUT time complexity of below code snippet will O(2^n)
func foo(n) {
  for (i:=1;i<=n;i++) {
    foo(n-1)
  }
}
Above can be proved mathematically. But as a laymen, you can visualize if it if F(4), there will be total
16 computations. If it is F(5), there will be total 32 computations.

Space complexity will be O(n) to store the recursion stack.
 */
public class MinimumJumpUsingRecursion {

    static int getMinimumJumpUsingRecursion(int[] steps, int pos) {
        int val = steps[pos];
        if (val == 0) {
            return -1;
        }
        int n = steps.length;
        if (val >= n-pos-1) {
            return 1;
        }

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= val; i++) {
            int minTemp = getMinimumJumpUsingRecursion(steps, pos + i);

            if (minTemp == -1) {
                return -1;
            }
            if ((minTemp + 1) < min) {
                min = minTemp +1;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        //int[] arr = {2,1,1,1,4};
        int[] arr = {1,1,3,6,9,3,0,1,3};

        System.out.println(getMinimumJumpUsingRecursion(arr, 0));
    }
}


