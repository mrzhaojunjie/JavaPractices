package 问题练习;


import java.util.Stack;
/*给定一个经过编码的字符串，返回它解码后的字符串。

        编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

        你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

        此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。

        示例:

        s = "3[a]2[bc]", 返回 "aaabcbc".
        s = "3[a2[c]]", 返回 "accaccacc".
        s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".*/


public class practice12_10 {
    public String decodeString(String s){
      StringBuilder sb = new StringBuilder();
      Stack<Character> stack = new Stack<>();
      StringBuilder str,num;
      for(char c:s.toCharArray()){
          if(c!=']'){
              stack.push(c);
          }else {
              boolean flag = false; //遇到数字做标记
              num = new StringBuilder();
              str = new StringBuilder();
              while(!stack.isEmpty()){
                  if(stack.peek()>='0'&&stack.peek()<='9'){
                      flag = true;
                      num.insert(0,stack.pop());
                  }else{
                      if(flag){
                          break;  //遇到数字又遇到字母表示一个k[encode_string]结束
                      }
                      if(stack.peek()=='['){
                          stack.pop();
                      }else{
                          str.insert(0,stack.pop());
                      }
                  }
              }
              int number = Integer.parseInt(num.toString());
              if(!stack.isEmpty()){
                  for(int i=0;i<number;i++){
                      for(Character ch:str.toString().toCharArray()){
                          stack.push(ch);
                      }
                  }
              }else{
                  for(int i=0;i<number;i++){
                      sb.append(str);
                  }
              }

          }
      }
      int length = sb.length();
      while(!stack.isEmpty()){
          sb.insert(length,stack.pop());
      }
      return sb.toString();
    }




//给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。

//示例 1：

//输入：S = "ab#c", T = "ad#c"
//输出：true
//解释：S 和 T 都会变成 “ac”。

    public boolean backspaceCompare(String S, String T){
        Stack<Character> s = new Stack<>();
        Stack<Character> t = new Stack<>();
        for(Character c:S.toCharArray()){ //遍历字符串
            if(c=='#'&&!s.isEmpty()){
                s.pop();  //删除栈顶元素即退格
            }else if(c!='#'){
                s.push(c);
            }
        }
        for(Character c:T.toCharArray()){
            if(c=='#'&&!t.isEmpty()){
                t.pop();
            }else if(c!='#'){
                t.push(c);
            }
        }
        if(s.size()!=t.size()){
            return false;
        }
        while(s.size()!=0){
            if(!s.isEmpty()&&!t.isEmpty()&&s.pop()!=t.pop()){
                return false;
            }
        }
        return true;
    }
}
