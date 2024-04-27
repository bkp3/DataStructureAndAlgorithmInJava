package Array;


//54321
public class PalindromeNumber {

	public static void main(String[] args) {
		int n = 12345;
		int num = n;
		int s = 0;

		while (num > 0) {

			s = s * 10 + num % 10;
			num = num / 10;

		}
		System.out.println(s);

	}

}
