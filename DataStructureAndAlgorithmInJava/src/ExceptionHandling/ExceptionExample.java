package ExceptionHandling;

public class ExceptionExample {

	public static void div(int a, int b) {
		int ans = 0;
		try {
			ans = a / b;
			System.out.println("try : " + ans);
		} catch (Exception e) {
			System.out.println("Exception op :" + e.getMessage());

		} finally {
			System.out.println("finally : " + ans);
		}
		System.out.println("outside : " + ans);
	}

	public static void main(String[] args) {
		div(100, 0);

	}

}
