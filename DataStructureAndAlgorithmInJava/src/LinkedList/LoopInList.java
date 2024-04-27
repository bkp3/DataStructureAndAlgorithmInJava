package LinkedList;

/*
Loop Detected
3
3
6
Linked List is:- 0 1 2 3 4 5 6 


*/
import java.util.*;

public class LoopInList {

	private ListNode head;

	private static class ListNode {
		private int data;
		private ListNode next;

		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	// Display the list
	public void display() {
		System.out.print("Linked List is:- ");
		ListNode current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();

	}

	public void detectLoop() {
		ListNode slow = head;
		ListNode fast = head.next;
		ListNode tmp = fast;
		boolean isLoop = false;
		while (slow != null && fast != null && fast.next != null) {
			if (slow == fast) {
				isLoop = true;
				break;
			}
			slow = slow.next;
			tmp = fast.next;
			fast = fast.next.next;
		}
		if (isLoop) {
			System.out.println("Loop Detected");
			System.out.println(slow.data);
			System.out.println(fast.data);
			System.out.println(tmp.data);
			tmp.next = null;
			display();
		}

	}

	public static void main(String[] args) {
		LoopInList obj = new LoopInList();
		obj.head = new ListNode(0);
		ListNode second = new ListNode(1);
		ListNode third = new ListNode(2);
		ListNode fourth = new ListNode(3);
		ListNode five = new ListNode(4);
		ListNode six = new ListNode(5);
		ListNode seven = new ListNode(6);

		Scanner sc = new Scanner(System.in);

		// ow we will connect them together to form a chain
		obj.head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = five;
		five.next = six;
		six.next = seven;
		seven.next = fourth;

		// Display the list
		// obj.display();
		obj.detectLoop();
		// obj.display();

	}

}
