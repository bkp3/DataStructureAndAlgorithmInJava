package A2Z.step6_LinkedList.lec3_LLMediumProblems;

import java.util.Stack;

public class IsPalindromeLL {

    static boolean isPalindromeUsingStack(Node head){
        Stack<Node>st=new Stack<>();
        Node cur=head;
        while(cur!=null){
            st.push(cur);
            cur=cur.next;
        }
//        st.stream().forEach(x-> System.out.println(x.data));
        cur=head;
        while(cur!=null){
            if(cur.data!=st.pop().data){
                return false;
            }
            cur=cur.next;
        }
        return true;
    }

    static Node reverse(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node newHead=reverse(head.next);
        Node next=head.next;
        next.next=head;
        head.next=null;
        return newHead;
    }

    static boolean isPalindrome(Node head){
        Node slow=head;
        Node fast=head;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        Node newHead=reverse(slow.next);
        Node curHead=head;
        while(curHead!=null&&newHead!=null){
            if(curHead.data!=newHead.data){
                return false;
            }
            curHead=curHead.next;
            newHead=newHead.next;
        }
        return true;
    }



    static void main() {
        Node head=Node.createList();
        Node.printLinkedList(head);

        boolean flag=isPalindromeUsingStack(head);
        System.out.println(flag);

        boolean flag1=isPalindrome(head);
        System.out.println(flag1);

    }
}
