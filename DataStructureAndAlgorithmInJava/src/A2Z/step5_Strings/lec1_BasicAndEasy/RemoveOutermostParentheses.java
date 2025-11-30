package A2Z.step5_Strings.lec1_BasicAndEasy;

/*
A valid parentheses string is defined by the following rules:

It is the empty string "".
If A is a valid parentheses string, then so is "(" + A + ")".
If A and B are valid parentheses strings, then A + B is also valid.

A primitive valid parentheses string is a non-empty valid string that cannot be split into two or more non-empty valid parentheses strings.

Given a valid parentheses string s, your task is to remove the outermost parentheses from every primitive component of s and return the resulting string.
Examples
Example 1:
Input: s = "((()))"
Output: "(())"
Explanation: The input string is a single primitive: "((()))".
Removing the outermost layer yields: "(())".

Example 2:
Input: s = "()(()())(())"
Output: "(()())()"
Explanation: Primitive decomposition: "()" + "(()())" + "(())"
After removing outermost parentheses: "" + "()()" + "()"
Final result: "(()())()"

*/

import java.util.Stack;

public class RemoveOutermostParentheses {
    static void main() {
        String str="((()))";
        String ans="";
        Stack<Character>st=new Stack<>();
        for(char c:str.toCharArray()){
            if(c=='('){
                if(st.size()>0){
                    ans=ans+"(";
                }
                st.push(c);
            }else{
                st.pop();
                if(st.size()>0){
                    ans=ans+")";
                }
            }
        }
        System.out.println(ans);
    }
}
