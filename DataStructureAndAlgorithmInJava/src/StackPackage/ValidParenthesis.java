package StackPackage;

import java.util.*;

//true
public class ValidParenthesis {

	public static boolean fun(String s) {
		Stack<Character> st = new Stack<>();
		int n = s.length();
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(') {
				st.push(s.charAt(i));
			} else {
				if (st.empty()) {
					return false;
				}

				char x = st.pop();
				if (s.charAt(i) == '}' && x != '{')
					return false;

				if (s.charAt(i) == ']' && x != '[')
					return false;

				if (s.charAt(i) == ')' && x != '(')
					return false;

			}
		}
		if (st.empty())
			return true;
		else
			return false;

	}

	public static void main(String[] args) {
		String str = "{()[]}";
		boolean flag = fun(str);
		System.out.println(flag);

	}

}
