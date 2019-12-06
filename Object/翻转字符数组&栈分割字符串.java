package 问题练习;

import java.util.Stack;


public class practice12_9 {
    //在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
//
//给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
//
//返回可以通过分割得到的平衡字符串的最大数量。
//输入：s = "RLRRLLRLRL"
//输出：4
//解释：s 可以分割为 "RL", "RRLL", "RL", "RL", 每个子字符串中都包含相同数量的 'L' 和 'R'。
    public int balancedStringSplit(String s) {
        int count =0;
        Stack<Character> stack = new Stack<>();
        for(char c:s.toCharArray()){ //遍历
            if(stack.isEmpty()){
                stack.add(c);
            }else if(stack.peek()==c){
                stack.add(c);
            }else{
                stack.remove(stack.peek());
                if(stack.isEmpty()){
                    count++;
                }
            }
        }
        return count;

    }
    //编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
    //
    //不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
    //
    //你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符
    //输入：["h","e","l","l","o"]
    //输出：["o","l","l","e","h"]
    public void reverseString(char[] s) {
        swap(0,s.length-1,s);

    }
    public void swap(int start,int end,char[] s){
        if(start>end){
            return ;
        }
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        swap(start+1,end-1,s);

    }
    

}
