package A2Z.step4_BinarySearch.lec1_BSOnAnswers;

/*
A monkey Koko is given ‘n’ piles of bananas, whereas the 'ith' pile has ‘a[i]’ bananas. An integer ‘h’ is also given, which denotes the time (in hours) for all the bananas to be eaten.

Each hour, the monkey chooses a non-empty pile of bananas and eats ‘k’ bananas. If the pile contains less than ‘k’ bananas, then the monkey consumes all the bananas and won’t eat any more bananas in that hour.

Find the minimum number of bananas ‘k’ to eat per hour so that the monkey can eat all the bananas within ‘h’ hours.

Examples
Input: N = 4, a[] = {7, 15, 6, 3}, h = 8
Output: 5
Explanation:  If Koko eats 5 bananas/hr, he will take 2, 3, 2, and 1 hour to eat the piles accordingly. So, he will take 8 hours to complete all the piles.

Input: N = 5, a[] = {25, 12, 8, 14, 19}, h = 5
Output: 25
Explanation: If Koko eats 25 bananas/hr, he will take 1, 1, 1, 1, and 1 hour to eat the piles accordingly.

*/

import java.util.Arrays;

public class KokoEatingBananas {

    public static int calculateTotalHours(int[] a, int hourly) {
        int totalHours = 0;
        for (int pile : a) {
            totalHours += (int)Math.ceil((double)pile / hourly);
        }
        return totalHours;
    }
    public static int funBrute(int[] a, int h) {
        int maxVal = Arrays.stream(a).max().getAsInt();
        for (int i = 1; i <= maxVal; i++) {
            int hours = calculateTotalHours(a, i);
            if (hours <= h) {
                return i;
            }
        }
        return maxVal;
    }

    public static int funOptimal(int[] piles, int h) {
        int maxPile = Arrays.stream(piles).max().getAsInt();
        int low = 1, high = maxPile;
        int ans = maxPile;
        while (low <= high) {
            int mid = (low + high) / 2;
            int totalH = calculateTotalHours(piles, mid);
            if (totalH <= h) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }

    static void main() {
        int[] a = {3, 6, 7, 11};
        int h = 8;

        System.out.println(funBrute(a,h));
        System.out.println(funOptimal(a,h));
    }
}
