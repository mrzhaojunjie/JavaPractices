```
Java线性表的头插尾插、头删尾删、根据坐标插入删除

import java.util.Arrays;
public class MyArrayList {
//    long factorial(int n){
//        return n>2? factorial(n-1)*n:n;
//    }
    //顺序表中存储的元素是int类型的
    //增删减改（Create Delete Retrive Update）
    //增删为主要
    //插入：头插void pushFront(int element)尾插void pushBack(int element)；
    //删除：头删void popFront()尾删void popBack()根据下标进行删除void erase(int index);
    private int[] array;
    private int size;
    public MyArrayList(){
        array = new int[10];
        size = 0;
    }
    //尾插
    public void pushBack(int element){
        array[size] = element;
        size++;
```



    }
    //头插
    public void pushFront(int element){
        //将原有数据全部后移一个单位
        for(int i = size-1;i>=0;i--){
            //将数据赋给后边一位
            array[i+1] = array[i];
        }
        //将新数据放入0下标处
            array[0] = element;
            size++;
    }
    //头删
    public void popFront(){
        if(size == 0){
            System.out.println("线性表为空");
            return;
        }
        for(int i=1;i<size;i++){
            array[i-1] = array[i];
        }
        size--;
        array[size] = 0;
        //array[--size] = 0;
    
    }
    //尾删
    public void popBack(){
        if(size<=0){
            System.out.println("线性表为空");
        }
        size--;
        array[size] = 0;
        //array[--size] = 0;
    
    }
    @Override
    public String toString(){
        return Arrays.toString(array);
        //return Arrays.toString(Arrays.copyOf(array,size));//拷贝size个到array
    }
    //根据下标进行删除
    public void erase(int index){
        if(size == 0){
            System.out.println("线性表为空");
            return;
        }
        for(int i=index;i<size;i++){
            array[i]=array[i+1];
        }
        array[--size] = 0;


    }
    public void insert(int element,int index){  //在index位置插入element
            for(int i = size-1;i>=index;i--){
                //将数据赋给后边一位
                array[i+1] = array[i];
            }
            //将新数据放入0下标处
            array[index] = element;
            size++;
    
        }


    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);
        list.pushFront(10);
        list.pushFront(20);
        list.pushFront(30);
        System.out.println(list);
        list.popFront();
        System.out.println(list);
        list.insert(30,3);
        System.out.println(list);
        list.erase(2);
        System.out.println(list);
        /*list.popBack();
        System.out.println(list);*/


    }

}