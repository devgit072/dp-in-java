package fibonacci;

/*
 The time complexity of this solution is O(2^n) as we are making 2 recursive call in same method and you can visualize
 a binary tree will be formed.
 Space complexity will be O(n), to store all the parameters in recursion stack.
 */
public class FibonacciUsingRecursion {

    static int calculateFibonacci(int n) {
        if (n==0 || n==1) {
            return n;
        }

        return calculateFibonacci(n-1) + calculateFibonacci(n-2);
    }

    public static void main(String[] args) {
        System.out.println(calculateFibonacci(10));
    }
}


