package housethief;

/*
It is bit better solution than earlier recursion implementation. Code looks more simpler and straighforward.
 */
public class HouseThiefWithRecursion2 {

    static int getMaxSteal(int[] houses, int curr) {
        if (curr >= houses.length) {
            return 0;
        }

        return Math.max(
                houses[curr] + getMaxSteal(houses, curr+2),
                getMaxSteal(houses, curr+1)
        );
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 5, 1, 3, 6, 2, 4};
        int[] arr = {2, 10, 14, 8, 1};
        System.out.println(getMaxSteal(arr1, 0));
    }
}
