package ExceptionHandling;

/*

thats the default outputExceptionHandling.MyException: I dont want this
20


*/
class MyException extends Exception {

	public MyException(String str) {
		super(str);
	}
}

public class CustomException {

	public static void main(String[] args) {
		int age=20;
		try {
			if (age < 21) {
				throw new MyException("I dont want this");
			}

		} catch (MyException e) {
			System.out.println("thats the default output" + e);
		} catch (Exception e) {
			System.out.println("something went wrong" + e);
		}
		System.out.println(age);

	}

}
