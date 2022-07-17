package StringMust;

//bihar.of.capital.the.is.patna
public class ReverseWords {

	public static void main(String[] args) {
		String S = "patna.is.the.capital.of.bihar";
		String[] str = S.split("\\.");

		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}

		String s = "";
		for (int i = 0; i < str.length; i++) {
			s = s + str[str.length - i - 1] + ".";
		}

		System.out.println(s.substring(0, s.length() - 1));

	}

}
