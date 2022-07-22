package StringZone;

public class StringPrefix {

	static String fun(String str, int m) {
		String tm = "";
		for (int i = 0; i < m; i++) {
			tm = tm + str.charAt(i);
		}
		return tm;
	}

	public static void main(String[] args) {
		String[] str = { "Ankush", "Anshul", "Ankit", "Anuj", "Vijay", "Prince" };
		String temp = "An";
		int n = str.length;
		int m = temp.length();
		int count = 0;
		for (int i = 0; i < n; i++) {
			String st = fun(str[i], m);

			if (st.equals(temp)) {
				count++;
			}
		}
		System.out.println(count);

	}

}
