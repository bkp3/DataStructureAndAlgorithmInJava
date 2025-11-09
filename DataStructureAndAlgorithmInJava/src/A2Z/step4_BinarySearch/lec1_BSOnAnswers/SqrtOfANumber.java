package A2Z.step4_BinarySearch.lec1_BSOnAnswers;

/*
You are given a positive integer n. Your task is to find and return its square root. If ‘n’ is not a perfect square, then return the floor value of sqrt(n).

Examples
Input: N = 36
Output: 6
Explanation: Square root of 36 is 6.

Input: N = 28
Output: 5
Explanation: Square root of 28 is approximately 5.292. So, the floor value will be 5.

*/

public class SqrtOfANumber {
    public static int funBrute(int n) {

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if ((long) (i) * i <= n) {
                ans = i;
            } else {
                break;
            }
        }
        return ans;
    }

    public static int funOptimal(int x) {
        if (x < 2) return x;
        int left = 1, right = x / 2, ans = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid <= x) {
                ans = (int) mid;
                left = (int) mid + 1;
            } else {
                right = (int) mid - 1;
            }
        }
        return ans;
    }

    static void main(String[] args) {

        int n = 27;

        System.out.println(funBrute(n));
        System.out.println(funOptimal(n));
    }

}
