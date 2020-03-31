package fibonacci;

/*
Time complexity is O(n) since there is just a for loop.
Space complexity is O(n) for the cache array.
 */
public class FibonacciUsingTabulation {

    static int fiboUsingTabulation(int n) {
        int[] cache = new int[n+1];
        if (n < 2) {
            return n;
        }
        cache[0]=0;
        cache[1]=1;
        for (int i =2 ;i<n+1;i++) {
            cache[i] = cache[i-1] + cache[i-2];
        }
        return cache[n];
    }

    public static void main(String[] args) {
        System.out.println(fiboUsingTabulation(10));
    }
}
