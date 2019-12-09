package 队列;

public class Node {
    Node next;
    int val;
    Node(int val,Node next){
        this.val = val;
        this.next = next;
    }
    Node(int val){
        this(val,null);
    }
}
