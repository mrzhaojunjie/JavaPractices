import java.util.Random;
import java.util.Scanner;

public class GuessGame {
    public static int selectDifficult(){
        System.out.println("1、简单");
        System.out.println("2、中等");
        System.out.println("3、高级");
        Scanner scanner = new Scanner(System.in);
        int difficult = scanner.nextInt();
        scanner.nextLine();  //读取/n
        return difficult;
    }
    public static int generateRandom(int difficult){
        Random random = new Random();
        switch (difficult){
            case 1:
                return random.nextInt(50);
            case 2:
                return random.nextInt(100);
            case 3:
                return random.nextInt(150);

        }
        return -1;
    }
    public static int selectTime(int difficult){
        switch (difficult){
            case 1:
                return 10;
            case 2:
                return 6;
            case 3:
                return 3;
        }
        return -1;
    }
    public static boolean guess(int r){
        System.out.println("请输入一个数字！");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        scanner.nextLine();
        if(x == r){
            System.out.println("你猜对了！");
            return true;
        }else if(x > r){
            System.out.println("你猜大了！");
        }else{
            System.out.println("你猜小了！");
        }
        return false;
    }


    public static void main(String[] args) {
        int difficult = selectDifficult();//选择难度
        int r = generateRandom(difficult);//生成随机数
        int times = selectTime(difficult);
        boolean success = false;
        for(int i = times;i >0 ;i--){
            System.out.println("您还有"+i+"次机会");
            success = guess(r);
        }
        if(success){
            System.out.println("你真聪明！");
        }else{
            System.out.println("你真笨！");
        }



    }

}
