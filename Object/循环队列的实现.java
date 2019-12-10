package 队列;

public class MyCircularQueue {
    private int[] array;
    private int front = 0;
    private int rear = 0;
    private int size;
    public MyCircularQueue(int k) {
        size = k+1;
        array = new int[size];
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }else{
            array[rear] = value;
            rear = (rear+1)%size;
            return true;
        }
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }else{
            front = (front+1)%size;
            return true;
        }
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return array[front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return array[(rear-1+size)%size];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return front == rear;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (rear+1)%size == front;
    }
}
