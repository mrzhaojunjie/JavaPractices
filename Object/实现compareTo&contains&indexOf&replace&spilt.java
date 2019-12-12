package 作业;

import java.util.ArrayList;
import java.util.List;

//实现方法 compareTo, 能够实现按照字典序比较字符串大小
//实现方法 contains, 能够判定字符串中是否包含子串
//实现方法 indexOf, 能够找出字符串子串存在的位置
//实现方法 replace, 能够替换字符串中的某个部分
//实现方法 split, 能够指定分割符将字符串拆分成字符串数组(不必支持正则表达式)
public class JavaSE_1 {
    public static int compareTo(String s1,String s2){
        int slength = 0;         //找出最短长度
        if(s1.length()<s2.length()){
            slength = s1.length();
        }else{
            slength = s2.length();
        }

        for(int i =0;i<slength;i++){
            if(s1.charAt(i)<s2.charAt(i)){
                return -1;
            }
            if(s1.charAt(i)>s2.charAt(i)){
                return 1;
            }
        }
        if(s1.length() == s2.length()){
            return 0;
        }
        return (s1.length()-s2.length())>0? 1:-1;

    }
    public static boolean contains(String s1,String s2){
        int count = 0;//用count记录所比较的次数，每比较一次，次数加一
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i) == s2.charAt(0)){   //先与s2的首字母进行比较
                count =0;                      //重置count防止死循环
                for(int j=0;j<s2.length();j++){
                    if(i+j<s1.length()){
                        if(s1.charAt(i+j)!=s2.charAt(j)){  //如果s1中的字符不等于s2中的字符则跳出
                            break;
                        }
                        count ++;//比较一次count++
                    }
                }
                if(count==s2.length()){  //比较次数为s2的长度  则是子字符串
                    return true;
                }
            }
        }
        return false;

    }
    public static int indexOf(String s1,String s2){   //判断是否为子串  若是返回头下标，若不是则返回1
        int count =0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)==s2.charAt(0)){
                count = 0;
                for(int j=0;j<s2.length();j++){
                    if(i+j<s1.length()){
                        if(s1.charAt(i+j)!=s2.charAt(j)){
                            break;
                        }
                        count++;
                    }
                }
                if(count == s2.length()){
                    return i;
                }
            }
        }
        return -1;
    }
    public static StringBuilder replace(String s1,int from,int to,String s2){   //替换[from,to)的部分
        StringBuilder st = new StringBuilder();
        String news1 = s1.substring(0,from);
        String news2 = s1.substring(to+1,s1.length());
        st.append(news1);
        st.append(s2);
        st.append(news2);
        return st;
    }
    public static String[] split(String s1,String s2){   //返回为String类型的数组
        List<String> list = new ArrayList<>();//创建String线性表来存储分割后的字符串数组
        while(contains(s1,s2)){
            int index = indexOf(s1,s2);
            String temp = s1.substring(0,index);  //保存分割符前边的字符串
            list.add(temp);//将其保存在线性表中
            s1 = s1.substring((temp+s2).length()); //被分割的字符串就从删除标记后开始，前边的就没有了
        }
        list.add(s1);//最后一次切割完再存入线性表
        String[] str = new String[list.size()];
        for(int i=0;i<list.size();i++){
            str[i] = list.get(i);
        }
        return str;
    }
    public static void main(String[] args) {
        String s1 = "bi,teke,ji";
        String s2 = "ke";
        String s3 = ",";
        StringBuilder s =replace(s1,1,3,s2);
        System.out.println(s);
        System.out.println(contains(s1,s2));
        System.out.println(indexOf(s1,s2));
        System.out.println(split(s1,s3));
    }
}
