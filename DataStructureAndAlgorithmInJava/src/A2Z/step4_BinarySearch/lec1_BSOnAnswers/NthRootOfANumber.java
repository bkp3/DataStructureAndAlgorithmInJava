package A2Z.step4_BinarySearch.lec1_BSOnAnswers;

/*
Given two numbers N and M, find the Nth root of M. The nth root of a number M is defined as a number X when raised to the power N equals M. If the 'nth root is not an integer, return -1.

Examples
Input: N = 3, M = 27
Output: 3
Explanation: The cube root of 27 is equal to 3.

Input : N = 4, M = 69
Output: -1
Explanation : The 4th root of 69 does not exist. So, the answer is -1.


*/

public class NthRootOfANumber {

    public static int funBrute(int n, int m) {
        for (int i = 1; i <= m; i++) {
            long power = (long) Math.pow(i, n);
            if (power == m) return i;
            if (power > m) break;
        }
        return -1;
    }

    public static int funOptimal(int n, int m) {
        int low = 1, high = m;
        while (low <= high) {
            int mid = (low + high) / 2;
            long ans = 1;
            for (int i = 0; i < n; i++) {
                ans *= mid;
                if (ans > m) break;
            }
            if (ans == m) return mid;
            if (ans < m) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    static void main(String[] args) {

        int n = 3, m = 27;
        System.out.println(funBrute(n, m));
        System.out.println(funOptimal(n,m));
    }
}
