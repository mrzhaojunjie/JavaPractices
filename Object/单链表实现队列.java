package 队列;


//单链表实现队列
public class Queue {
    Node front;
    Node rear;
    int size = 0;
    public Queue(){
        front = rear = null;
    }
    public void offer(int val){
        Node newNode = new Node(0);
        newNode.val = val;
        newNode.next = null;
        if(front == null){
            front = rear = newNode;
        }else{
            rear.next = newNode;
            rear = newNode;
        }
        ++size;
    }
    public void poll(){
        if(front == null){
            return;
        }
        front = front.next;
        if(front == null){
            rear = null;
        }
        --size;
    }
    public int peek(){
        if(front == null){
            return -1;
        }
        return front.val;
    }
    public boolean isEmpty(){
        return front == null;
    }
    public int size(){
        return size;
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        System.out.println(q.isEmpty());
        System.out.println(q.size());
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5);
        System.out.println(q.size());
        System.out.println(q.peek());
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.poll();
        }

    }

}
