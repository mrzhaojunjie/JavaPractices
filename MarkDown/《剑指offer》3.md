//输入一个链表，按链表从尾到头的顺序返回一个ArrayList

 import java.util.ArrayList;

 public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
         ArrayList<Integer> list = new ArrayList<>();
         ListNode cur = listNode;
        while(cur!=null){
            list.add(0,cur.val);   //此处调用ArrayList中的add方法 add(index,val)在index索引处插入val;将旧链表头插入新链表即可;
            cur = cur.next;
        }
        return list;
    }

