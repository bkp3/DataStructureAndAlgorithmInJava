package A2Z.step6_LinkedList.lec1_LinkedList;

public class SearchElementLinkedList {
    static void main() {
        Node head=Node.createList();
        Node.printList(head);

        int target=999;
        boolean flag=false;
        Node cur=head;
        while(cur.next!=null){
            if(cur.data==target){
                flag=true;
                break;
            }
            cur=cur.next;
        }
        System.out.println(flag);
    }
}
