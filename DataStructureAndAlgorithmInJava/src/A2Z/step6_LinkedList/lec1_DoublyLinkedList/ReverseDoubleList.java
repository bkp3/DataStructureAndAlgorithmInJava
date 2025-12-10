package A2Z.step6_LinkedList.lec1_DoublyLinkedList;

public class ReverseDoubleList {

    static DNode reverseList(DNode head){
        if(head==null || head.next==null){
            return head;
        }
        DNode prev=null;
        DNode cur=head;
        while(cur!=null){
            prev=cur.prev;
            cur.prev=cur.next;
            cur.next=prev;
            cur=cur.prev;
        }
        return prev.prev;
    }

    static void main() {
        DNode head=DNode.createList();
        DNode.printDoubleList(head);

        DNode head1=reverseList(head);
        DNode.printDoubleList(head1);
    }
}
