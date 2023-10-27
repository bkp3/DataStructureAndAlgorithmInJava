package ExceptionHandling;

public class ExceptionExample3 {

	public static void fun() throws Exception {
		System.out.println("Inside fun method");
		throw new Exception("Hello World");
	}

	public static void main(String[] args) {
		try {
			fun();
		} catch (Exception e) {
			System.out.println("in main method");
			e.printStackTrace();
		}

	}

}
