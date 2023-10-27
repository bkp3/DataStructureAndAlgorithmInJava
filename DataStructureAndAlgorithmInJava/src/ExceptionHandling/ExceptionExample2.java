package ExceptionHandling;

public class ExceptionExample2 {

	public static void div(int a, int b) {
		int ans = 0;
		try {
			
			if(b==0) {
				throw new Exception("b can not be zero ");
			}
			ans=a/b;
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
