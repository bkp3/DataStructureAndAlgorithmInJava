package A2Z.step6_LinkedList.lec3_LLMediumProblems;

public class Node {
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }

    static Node createList(){
        int[] arr={5,3,4,1,2,9,7};
        Node head=new Node(arr[0]);
        Node cur=head;
        for(int i=1;i<arr.length;i++){
            Node tmp=new Node(arr[i]);
            cur.next=tmp;
            cur=cur.next;
        }
        return head;
    }

    static void printLinkedList(Node head){
        Node cur=head;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }
}
