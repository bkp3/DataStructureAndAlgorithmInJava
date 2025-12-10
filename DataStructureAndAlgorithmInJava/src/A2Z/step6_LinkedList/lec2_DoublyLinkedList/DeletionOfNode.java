package A2Z.step6_LinkedList.lec2_DoublyLinkedList;

public class DeletionOfNode {

    static DNode deleteHead(DNode head){
        if(head==null|| head.next==null){
            return null;
        }
        DNode cur=head;
        head=head.next;
        cur.next=null;
        head.prev=null;
        return head;
    }

    static DNode deleteTail(DNode head){
        if(head==null || head.next==null){
            return null;
        }
        DNode cur=head;
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.prev.next=null;
        cur.prev=null;
        return head;

    }

    static DNode deleteKthNode(DNode head, int k){
        if(head==null||head.next==null){
            return null;
        }
        int cnt=0;
        DNode cur=head;
        while(cur.next!=null){
            cnt++;
            if(cnt==k) break;
            cur=cur.next;
        }
        DNode prev=cur.prev;
        DNode next=cur.next;
        prev.next=next;
        next.prev=prev;
        cur.next=null;
        cur.prev=null;
        return head;
    }

    static void deleteGivenNode(DNode node){
        DNode prev=node.prev;
        DNode next=node.next;
        prev.next=next;
        next.prev=prev;
        node.next=null;
        node.prev=null;
    }

    static void main() {
        DNode head=DNode.createList();
        DNode.printDoubleList(head);

        //Delete head
        DNode head1=deleteHead(head);
        DNode.printDoubleList(head1);

        //delete tail
        DNode head2=deleteTail(head1);
        DNode.printDoubleList(head2);

        //delete kth node
        int k=3;
        DNode head3=deleteKthNode(head2,k);
        DNode.printDoubleList(head3);

        //delete the given node

        deleteGivenNode(head3.next.next);
        DNode.printDoubleList(head3);

    }
}
