package A2Z.step6_LinkedList.lec1_LinkedList;

public class Node {
    int data;
    Node next;
    Node(int data,Node next){
        this.data=data;
        this.next=next;
    }
    Node(int data){
        this.data=data;
        this.next=null;
    }
    public static Node createList(){
        Node head=new Node(5);
        head.next=new Node(3);
        Node cur=head;
        cur=cur.next;
        cur.next=new Node(4);
        return head;
    }

    public static void printList(Node head){
        Node cur=head;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }
}
