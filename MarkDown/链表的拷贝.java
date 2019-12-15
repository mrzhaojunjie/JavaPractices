package 链表;

import java.util.List;

public class Copy {
    public static ListNode copy(ListNode head){
        ListNode cur = head;
        ListNode newNode = new ListNode(0);
        ListNode nNode = newNode;

        while(cur!=null){
            ListNode node = new ListNode(cur.val);
            newNode.next = node;
            newNode = newNode.next;
            cur = cur.next;

        }
        return nNode.next;
    }
    public static ListNode create(){
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4,n5);
        ListNode n3 = new ListNode(3,n4);
        ListNode n2 = new ListNode(2,n3);
        ListNode n1 = new ListNode(1,n2);
        return n1;
    }
    public static void print(ListNode head){
        ListNode cur = head;
        while(cur!=null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
    public static void main(String[] args) {
            ListNode head = create();
            print(copy(head));

    }
}
