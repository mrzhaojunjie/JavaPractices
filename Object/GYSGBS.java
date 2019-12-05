package 问题练习;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;
//求两数的最大公约数和最小公倍数;

public class GYSGBS {
    public static void main(String[] args) {
        System.out.println("输入两个整数：");
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int GYS = 0;//最大公约数
        int GBS = 0;//最小公倍数
        GBS = num1*num2;
        int temp = 1;
        if(num1<num2){
            temp = num1;
            num1 = num2;
            num2 = temp;
        }
        while(temp!=0){
            temp = num1%num2;
            num1 = num2;
            num2 = temp;
        }
        GYS = num1;
        GBS = GBS/GYS;
        System.out.println("最大公约数为："+GYS);
        System.out.println("最小公倍数为："+GBS);


    }
}
