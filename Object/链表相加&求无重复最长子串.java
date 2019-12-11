package 问题练习;
//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//示例：
//输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }
public class practice12_11 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);   //创建新结点
        if(l1!=null||l2!=null){
            dummy.val = ((l1!=null)? l1.val:0)+((l2!=null)? l2.val:0);
            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2 = l2.next;
            }
            if(dummy.val>=10){   //如果相加的数字大于或等于10了就要进位   由于是逆序  则向下一个结点进位；
                if(l1!=null){
                    l1.val+=1;
                }else{
                    l1 = new ListNode(1);
                    dummy.val%=10;
                }
            }
        }else{
            return null;
        }
        return dummy;
    }
/*    给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

    示例 1:

    输入: "abcabcbb"
    输出: 3
    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。*/
     public int lengthOfLongestSubstring(String s){
         int i = 0;
         int flag = 0;
         int length = 0;
         int result = 0;
         while(i<s.length()){
             int pos = s.indexOf(s.charAt(i),flag);  //从flag位置开始查找i位置的字符至字符串结尾
             if(pos<i){
                 if(length>result){
                     result = length;
                 }
                 if(result>=s.length()-pos-1){
                     return result;
                 }
                 length = i-pos-1;
                 flag = pos +1;
             }
             length++;
             i++;
         }
         return length;
     }


}
