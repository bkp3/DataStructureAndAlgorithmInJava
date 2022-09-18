
class ArithmeticDemo {
	int a, b;

	public ArithmeticDemo(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public ArithmeticDemo() {

	}

	int sum() {
		return a + b;
	}
}

class Adder extends ArithmeticDemo {

	Adder() {
	}

	int add(int a, int b) {
		super.a = b;
		super.b = b;
		return sum();
	}

}

public class InheritanceDemo {

	public static void main(String[] args) {
		Adder obj = new Adder();
		System.out.println(obj.add(3, 4));

	}

}
