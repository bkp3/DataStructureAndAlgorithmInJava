package A2Z.step6_LinkedList.lec1_LinkedList;

public class InsertNode {
    static void main() {
        Node head=Node.createList();
        Node.printList(head);

        //insert at head
        Node tmp=new Node(8);

        tmp.next=head;
        head=tmp;
        Node.printList(head);

        // insert at last

        Node tmp1=new Node(1);
        Node cur=head;
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=tmp1;
        Node.printList(head);

    }
}
