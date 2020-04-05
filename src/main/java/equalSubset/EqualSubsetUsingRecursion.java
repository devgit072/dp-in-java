package equalSubset;

/*
Time complexity: O(2^n)
Space complexity: O(n) to store the recursion stack.
 */
public class EqualSubsetUsingRecursion {

    static boolean hasEqualSubsetUtil(int[] arr, int totalCapacity, int capacity, int pos) {
        if (pos >= arr.length) {
            return false;
        }
        if (capacity <= 0) {
            return false;
        }
        if (capacity * 2 == totalCapacity) {
            return true;
        }

        // Either include current element or do not include current element and move forward.
        return hasEqualSubsetUtil(arr, totalCapacity, capacity-arr[pos], pos+1) ||
                hasEqualSubsetUtil(arr, totalCapacity, capacity, pos+1);
    }

    static boolean hasEqualSubset(int[] arr) {
        int totalSum = 0;

        for (int a : arr) {
            totalSum += a;
        }

        // Fast return if total sum is odd, because then equal subset is not possible.
        if (totalSum%2 == 1) {
            return false;
        }

        return hasEqualSubsetUtil(arr, totalSum, totalSum, 0);
    }

    public static void main(String[] args) {
         int[] arr = {1, 2, 3, 4, 6};
        //int[] arr = {2, 3, 4, 6};

        System.out.println(hasEqualSubset(arr));
    }
}
