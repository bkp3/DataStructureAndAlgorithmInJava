package Array;


//153

public class ArmstrongNumber {

	public static void main(String[] args) {

		int n = 153;
		int num = n;
		int len = 0;
		
		while (num > 0) {
			len++;
			num = num / 10;
		}
		
		int s = 0;
		
		while (n > 0) {
			s = s + (int) Math.pow(n % 10, len);
			n = n / 10;
		}
		
		System.out.println(s);

	}

}
