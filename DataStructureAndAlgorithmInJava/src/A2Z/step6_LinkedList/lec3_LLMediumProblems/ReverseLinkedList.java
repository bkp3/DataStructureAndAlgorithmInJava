package A2Z.step6_LinkedList.lec3_LLMediumProblems;

public class ReverseLinkedList {

    static Node reverseList(Node head){
        Node cur=head;
        Node prev=null;
        Node next=head;
        while(cur!=null){
            cur=cur.next;
            next.next=prev;
            prev=next;
            next=cur;
        }
        return prev;
    }

    static Node reverseListRec(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node newHead=reverseListRec(head.next);
        Node next=head.next;
        next.next=head;
        head.next=null;
        return newHead;

    }


    static void main() {
        Node head=Node.createList();
        Node.printLinkedList(head);


        Node rev=reverseList(head);
        Node.printLinkedList(rev);

        Node rev1=reverseListRec(rev);
        Node.printLinkedList(rev1);
    }
}
