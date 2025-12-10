package A2Z.step6_LinkedList.lec2_DoublyLinkedList;

public class DNode {
    int data;
    DNode next;
    DNode prev;
    DNode(int data){
        this.data=data;
        this.next=null;
        this.prev=null;
    }

    static DNode createList(){
        int[] arr={5,1,6,4,7,3,2,8};
        DNode head=new DNode(arr[0]);
        DNode cur=head;
        for(int i=1;i<arr.length;i++){
            DNode tmp=new DNode(arr[i]);
            cur.next=tmp;
            tmp.prev=cur;
            cur=cur.next;
        }
        return head;
    }

    static void printDoubleList(DNode head){
        DNode cur=head;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }
}
