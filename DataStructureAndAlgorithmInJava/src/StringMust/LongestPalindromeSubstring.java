package StringMust;
//aabbaa

public class LongestPalindromeSubstring {

	public static void main(String[] args) {
		String S = "aaaabbaa";
		int n = S.length();
		int maxLength = 1;
		int start = 0;

		for (int i = 0; i < n; i++) {
			int low = i - 1;
			int high = i + 1;
			while (high < n && S.charAt(high) == S.charAt(i)) {
				high++;
			}
			while (low >= 0 && S.charAt(low) == S.charAt(i)) {
				low--;
			}
			while (high < n && low >= 0 && S.charAt(low) == S.charAt(high)) {
				high++;
				low--;
			}
			int length = high - low - 1;
			if (length > maxLength) {
				maxLength = length;
				start = low + 1;
			}
		}
		String ans = S.substring(start, start + maxLength);
		System.out.println(ans);

	}

}
