package A2Z.step5_Strings.lec2_MediumProblems;

import java.util.Stack;

/*
Given a valid parentheses string s, return the nesting depth of s. The nesting depth is the maximum number of nested parentheses.

Examples

Example 1:
Input: s = "(1+(2*3)+((8)/4))+1"
Output: 3
Explanation: Digit 8 is inside of 3 nested parentheses in the string.

*/

public class MaximumNestingDepthOfParenthesis {

    static void main() {
        String s = "(1+(2*3)+(((8)/4))+1)";
        int n=s.length();
        Stack<Character>st=new Stack<>();
        int ans=Integer.MIN_VALUE;
        for(char x:s.toCharArray()){
            if(x=='('){
                st.push(x);
                ans=Math.max(ans,st.size());
            }else if(x==')'){
                st.pop();
            }
        }
        System.out.println(ans);
    }

}
