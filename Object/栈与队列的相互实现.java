package 队列;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//用队列实现栈
public class QueueStack {
    class MyStack1{

    }
    class MyStack {
        private Queue<Integer> a;
        public MyStack() {
            a = new LinkedList<>();
        }

        public void push(int x) {
            a.offer(x);
        }

        public int pop() {
            for(int i=0;i<a.size()-1;i++){

                a.offer(a.poll());
            }


            return a.poll();
        }

        public int top() {
            for(int i=0;i<a.size()-1;i++){

                a.offer(a.poll());
            }
            int top = a.poll();
            a.offer(top);

            return top;
        }

        public boolean empty() {
            if(!a.isEmpty()){
                return false;
            }
            return true;
        }
    }
    //栈实现队列
    class MyQueue {
        private Stack<Integer> s1;
        private Stack<Integer> s2;

        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }


        public void push(int x) {
            s1.push(x);
        }


        public int pop() {
            if(s2.isEmpty()){
                int sz = s1.size();
                for(int i=0;i<sz;i++){
                    s2.push(s1.pop());
                }
            }
            return s2.pop();
        }

        public int peek() {
            if(s2.isEmpty()){
                int sz = s1.size();
                for(int i=0;i<sz;i++){
                    s2.push(s1.pop());
                }
            }
            return s2.peek();
        }

        public boolean empty() {
            if(s1.isEmpty()&&s2.isEmpty()){
                return true;
            }
            return false;
        }
    }
}

