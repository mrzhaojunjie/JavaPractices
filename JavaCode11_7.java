import java.util.Arrays;
import java.util.Scanner;
public class JavaCode11_7 {
    //给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
        /*public static void sum(int[] nums,int target){
            int[] res = new int[2];
            for(int i=0;i<nums.length - 1;i++){
                for(int j=i+1;j<nums.length;j++){  //遍历数组  从第一个数开始则第二个数为 i+1
                    if(nums[i]+nums[j] == target){
                        res[0] = i;
                        res[1] = j;
                    }
                }
            }
            System.out.println(Arrays.toString(res));  //java中输出数组用Arrays包  否则出现乱码
        }
        public static void main(String args[]){
            int[] nums = {2,7,11,15};
            int target = 22;
            sum(nums,target);


        }*/
    //给定两个大小为 m 和 n 的有序数组 nums1 和 nums2,请你找出这两个有序数组的中位数
    public static void bubbleSort(int[] arry){
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
    }
    public static int searchMid(int[] a,int[] b){
        int[] nums = new int[a.length+b.length];
        for(int i = 0;i<nums.length;i++){
            if(i<a.length){
                nums[i] = a[i];
            }else if(i>=a.length){
                nums[i] = b[i-a.length];
            }
        }
        bubbleSort(nums);
        if(nums.length % 2!=0){
            return nums[(nums.length-1)/2];
        }else if(nums.length % 2==0){
            return (nums[(nums.length-1)/2]+nums[(nums.length-1)/2+1])/2;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums1 = {1,3,6,9};
        int[] nums2 = {2,7,8};
        System.out.println(searchMid(nums1,nums2));
    }
}
