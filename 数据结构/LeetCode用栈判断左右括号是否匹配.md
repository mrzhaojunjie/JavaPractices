import java.util.Stack;
/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

        有效字符串需满足：
    
        左括号必须用相同类型的右括号闭合。
        左括号必须以正确的顺序闭合。
        注意空字符串可被认为是有效字符串。
*/
//解决方法：
//左括号入栈
//若遇到右括号，获取栈顶元素并且删除，判断栈顶元素是否和右括号相匹配，若匹配
//继续遍历剩余的字符，若不匹配，直接返回false
//最后判断栈是否为空 若为空，则返回true 否则返回false
public class MatchDemo {
    public static boolean matchdemo(String s){
        final char[][] array = {{'(',')'},{'{','}'},{'[',']'}}; //给出char二位维数组存储括号
        Stack<Character> st = new Stack<>();  //泛型给出栈空间
        for(int i = 0;i<s.length();i++){
            char curCh = s.charAt(i);//curCh获取i位置的括号
            int flag = 0; //进行标记
            for(int j=0;j<array.length;j++){
                if(curCh == array[j][0]){ //若为左括号则入栈并将其标记
                    st.push(curCh);
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){ //若为右括号
                if(st.isEmpty()){  //若栈空则肯定不匹配直接返回false
                    return false;
                }
                char topCh = st.pop();  //取栈顶元素
                for(int k=0;k<array.length;k++){
                    if(topCh == array[k][0]){  //栈顶元素为左括号
                        if(curCh == array[k][1]){  //当前元素为右括号
                            break;//匹配跳出
                        }else{
                            return false;
                        }
                    }
                }
            }
        }
        return st.empty();  //栈空则全部匹配完成；
    }
    public static void main(String[] args) {
        String sb = "(()]";
        System.out.println(matchdemo(sb));
    }
}