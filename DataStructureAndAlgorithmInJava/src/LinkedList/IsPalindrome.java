package LinkedList;

/*
Linked List is:- 4 8 11 8 4 
Check if linked list is palindrome or not :- 
true

*/
import java.util.*;
public class IsPalindrome {
	
	private ListNode head;
	
	private static class ListNode{
		private int data;
		private ListNode next;
		
		public ListNode(int data) {
			this.data=data;
			this.next=null;
		}
	}
	
	//Display the list
	public void display() {
		System.out.print("Linked List is:- ");
		ListNode current = head;
		while(current!=null) {
			System.out.print(current.data+" ");
			current=current.next;
		}
		System.out.println();
		
	}
	
	public boolean isPali() {
		if(head==null) {
			return true;
		}
		
		Stack<Integer>st=new Stack<>();
		ListNode current=head;
		while(current!=null) {
			st.push(current.data);
			current=current.next;
		}
		
		ListNode temp=head;
		while(temp!=null) {
			if(temp.data != st.peek()) {
				return false;
			}
			st.pop();
			temp=temp.next;
		}
		return true;
	}
	
	
	public static void main(String []args) {
		IsPalindrome obj=new IsPalindrome();
		obj.head = new ListNode(4);
		ListNode second = new ListNode(8);
		ListNode third = new ListNode(11);
		ListNode fourth = new ListNode(8);
		ListNode five = new ListNode(4);
		
		Scanner sc = new Scanner(System.in);
		
		// ow we will connect them together to form a chain
		obj.head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = five;
		
		//Display the list
		obj.display();
		System.out.println("Check if linked list is palindrome or not :- ");
		boolean ans=obj.isPali();
		System.out.println(ans);
		
		
		
		
		
	}

}
