package StringZone;

public class StringCharacter {

	public static void main(String[] args) {
		String str = "HelloWorld";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 65 && str.charAt(i) <= 90) {
				System.out.println(str.charAt(i));
				str = str.replace(str.charAt(i), '_');
			}
		}
		System.out.println(str);

	}

}
