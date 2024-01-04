package MultiThreading;

// creating our thread using runnable interface



/*

value of i is : 0
value of i is : 1
value of i is : 2
value of i is : 3
value of i is : 4
value of i is : 5
value of i is : 6
value of i is : 7
value of i is : 8
value of i is : 9s

*/
public class RunnableDemo implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Value of i is : " + i);
			try {
				// 1sec
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {

		RunnableDemo obj = new RunnableDemo();

		Thread t = new Thread(obj);

		t.start();

	}

}
