package 队列;

import java.util.Arrays;
//数组实现栈
public class Stack {
    private int[] array;
    private int size;
    public Stack(int n){
        array = new int[n];
        size = 0;
    }

    public void push(int value){
        if(size == array.length){ //扩容
            array = Arrays.copyOf(array,2*size);
        }
        array[size++] = value;
    }
    public void pop(){
        if(size>0)
        size--;
    }
    public int peek(){
        return array[size-1];
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public static void main(String[] args) {
        Stack st = new Stack(2);

        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(6);
        System.out.println(st.size());
        System.out.println(st.peek());
        st.pop();
        while(!st.isEmpty()){
            System.out.println(st.peek());
            st.pop();
        }

    }
}
