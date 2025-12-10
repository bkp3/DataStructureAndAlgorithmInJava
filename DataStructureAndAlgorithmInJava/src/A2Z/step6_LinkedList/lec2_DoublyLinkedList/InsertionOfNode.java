package A2Z.step6_LinkedList.lec2_DoublyLinkedList;

public class InsertionOfNode {


    static DNode insertBeforeHead(DNode head, int val){
        DNode tmp=new DNode(val);
        tmp.next=head;
        head.prev=tmp;
        return tmp;
    }

    static DNode insertBeforeTail(DNode head, int val){
        if(head.next==null){
            insertBeforeHead(head,val);
        }
        DNode tmp=new DNode(val);
        DNode cur=head;
        while(cur.next.next!=null){
            cur=cur.next;
        }
        tmp.next=cur.next;
        cur.next.prev=tmp;
        tmp.prev=cur;
        cur.next=tmp;
        return head;
    }

    static DNode insertBeforeKthNode(DNode head,int val, int k){
        if(k==1){
            return insertBeforeHead(head,val);
        }
        DNode tmp=new DNode(val);
        int cnt=0;
        DNode cur=head;
        while (cur.next!=null){
            cnt++;
            if(cnt==k) break;
            cur=cur.next;
        }
        tmp.next=cur;
        tmp.prev=cur.prev;
        cur.prev.next=tmp;
        cur.prev=tmp;
        return head;
    }

    static void insertBeforeNode(DNode node,int val){
        DNode tmp=new DNode(val);
        tmp.next=node;
        tmp.prev=node.prev;
        node.prev.next=tmp;
        node.prev=tmp;
    }

    static void main() {
        DNode head=DNode.createList();
        DNode.printDoubleList(head);

        //insert before head
        int val1=10;
        DNode head1=insertBeforeHead(head,val1);
        DNode.printDoubleList(head1);

        //insert before tail

        int val2=50;
        DNode head2=insertBeforeTail(head1,val2);
        DNode.printDoubleList(head2);


        // insert before kth node

        int val3=100;
        int k=5;
        DNode head3=insertBeforeKthNode(head2,val3,k);
        DNode.printDoubleList(head3);

        //insert before node
        int val4=200;
        insertBeforeNode(head3.next.next,val4);
        DNode.printDoubleList(head3);


    }
}
