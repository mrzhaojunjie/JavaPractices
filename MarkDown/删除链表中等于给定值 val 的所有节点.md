1. 删除链表中等于给定值 **val** 的所有节点。
   
   ```
    class  ListNode{
          int val;
          ListNode next;
          ListNode(ListNode next,int val){
              this.next = null;
              this.val = val;
          }
          ListNode(int val){
              this(null,val);
          }
          @Override
          public String toString(){
              return String.format("ListNode{%d}",val);
          }
   
   }
   public class LeetCode {
       public static void printLinkedList(ListNode head){
           ListNode cur = head;
           while(cur != null){
               System.out.println(cur.val);
               cur = cur.next;
           }
       }
   ```
   
   

    public static ListNode buildLinkedList() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
    
        return n1;
    }
    /*public static ListNode deleteListNode(int val,ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                if(head.val == val){
                    head = head.next;
                }else{
                    prev.next = cur.next;
                }
    
            }else{
                prev = cur;
            }
            cur = cur.next;
    
        }
        return head;
    }*/
      
    public static ListNode deleteListNode(int val,ListNode head){
        if(head == null){
            return null;
        }
        ListNode prev = head;
        ListNode cur = head.next;
        while(cur != null){
            if(cur.val == val){
                prev.next = cur.next;
            }else{
                prev = cur;
            }
            cur = cur.next;
        }
        if(head.val == val){
            head = head.next;
        }
        return head;
    }
    
    public static void main(String[] args) {
       ListNode head =  buildLinkedList();
       printLinkedList(head);
       deleteListNode(3,head);
        printLinkedList(head);


    }

}