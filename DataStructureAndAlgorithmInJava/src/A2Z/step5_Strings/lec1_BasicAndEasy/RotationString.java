package A2Z.step5_Strings.lec1_BasicAndEasy;


/*
Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
A shift on s consists of moving the leftmost character of s to the rightmost position. For example, if s = "abcde", then it will be "bcdea" after one shift.
Examples

Example 1:
Input: s = "rotation", goal = "tionrota"
Output: true
Explanation: After multiple left shifts on "rotation", we get:
    1st shift → "otationr"
    2nd shift → "tationro"
    3rd shift → "ationrot"
    4th shift → "tionrota"
    So the goal string can be obtained by rotating the original string.

Example 2:
Input: s = "hello", goal = "lohelx"
Output: false
Explanation:
Even after all possible rotations of "hello", we cannot form "lohelx" due to the presence of an extra character 'x'. Hence, it's not possible


*/


public class RotationString {

    static boolean funBrute(String s, String t){
        if(s.length()!=t.length()){
            return false;
        }
        for(int i=0;i<t.length();i++){
            String l=t.substring(i)+t.substring(0,i);
            if(s.equals(l)){
                return true;
            }
        }
        return false;
    }

    static boolean funOptimal(String s,String t){
        if(s.length()!=t.length()){
            return false;
        }
        s=s+s;
        return s.contains(t);
    }

    static void main() {
        String s = "rotation";
        String goal = "tionrota";


        //bruteForce
        boolean flag=funBrute(s,goal);
        System.out.println(flag);


        //optimal
        boolean flag1=funOptimal(s,goal);
        System.out.println(flag1);
    }
}
