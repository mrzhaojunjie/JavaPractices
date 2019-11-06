import java.util.Arrays;
public class JavaCode11_6 {
    //冒泡排序实际上就是把最大的数往最后一位移动
    /*public static void bubbleSort(int[] arry){
        for(int i = 0;i<arry.length-1;i++){  //外层循环表示移动的次数次数
            for(int j = 1;j<arry.length- i;j++){  //内层循环表示交换
                if(arry[j-1] > arry[j]){
                    swap(arry,j-1,j);
                }
            }
        }

    }
    public static void swap(int[] a,int i,int j){
           int t = a[i];
           a[i] = a[j];
           a[j] = t;
    }*/
    //二分查找
   /* public static  int binarySearch(int[] a,int value) {
        int left = 0;
        int right = a.length;

        while (left < right) {
            int mid = (right + left) / 2;
            if (value == a[mid]) {
                return mid;
            }else if (value < a[mid]) {
                right = mid-1 ;
            } else if (value > a[mid]) {
                left = mid+1;
            }

        }
        return -1;

    }*/
   //数组的复制
    /*public static int[] copyOf(int[] a,int newlength) {
        int[] b = new int[newlength];
        for (int i = 0; i < newlength; i++) {
                b[i] = a[i];
        }
        return b;
    }*/
    public static int[] copyOfRange(int[] a,int from,int to){
        int[] b = new int[to-from];
        for(int i = from;i<to;i++){
            b[i-from] = a[i];
        }
        return b;

    }
    public static void fill(int[] a,int val){   //将val赋值给数组
        for(int i = 0;i<a.length;i++){
            a[i] = val;
        }
    }
    public static boolean equals(int[] a,int[] b){ //比较两个数组是否相等
        if(a.length !=b.length){
            return false;
        }
        for(int i = 0;i<a.length;i++){
            if(a[i]!=b[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a ={1,5,3,6,2};
        System.out.println(Arrays.toString(copyOfRange(a,2,4));
        /*int length = 5;
        System.out.println(Arrays.toString(copyOf(a,length)));*/

        /*int[] a = {2,5,9,6,1,3,4,8,7};
        int value = 4;
        System.out.println(binarySearch(a,value));*/
//        bubbleSort(a);
//        System.out.println(Arrays.toString(a));

        /* int[] a = {100, 20};
         swap(a,0,1);
        System.out.println(Arrays.toString(a));*/
    }
}
