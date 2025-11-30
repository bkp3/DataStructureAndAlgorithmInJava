package A2Z.step5_Strings.lec1_BasicAndEasy;

/*
Given a string s, representing a large integer, the task is to return the largest-valued odd integer (as a string) that is a substring of the given string s.
The number returned should not have leading zero's. But the given input string may have leading zero.

Examples

Example 1
Input: s = "5347"
Output: "5347"
Explanation: The odd numbers formed by the given string are → 5, 3, 53, 347, 5347. The largest odd number without leading zeroes is 5347.

Example 2
Input: s = "0214638"
Output: "21463"
Explanation: The odd numbers formed by the string are → 1, 3, 21, 63, 463, 1463, 21463. We can't use numbers starting with 0, so the largest valid odd number is 21463.



*/

public class LargestOddNumberString {
    static void main() {
        String s="00022214638";
        int ind = -1;
        int i;
        for (i = s.length() - 1; i >= 0; i--) {
            if ((s.charAt(i) - '0') % 2 == 1) {
                ind = i;
                break;
            }
        }
        if (ind == -1){
            System.out.println("");
            return;
        }
        i = 0;
        while (i <= ind && s.charAt(i) == '0') i++;

        System.out.println(s.substring(i, ind + 1));

    }
}
