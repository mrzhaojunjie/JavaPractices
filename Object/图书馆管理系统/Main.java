package 图书馆管理系统;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user = login();
        while(true){
            user.menu();
            System.out.println("请选择：");
            int select = scanner.nextInt();
            user.operation(select);

        }
    }

    private static User login() {
        System.out.println("请输入您的姓名");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("欢迎您，"+name);
        System.out.println("请选择您的身份:1、老师  2、学生");
        int choice = scanner.nextInt();
        User u = null;
        if(choice == 1){
            u = new Teacher();
        }else if(choice == 2){
            u = new Student();
        }
        return u;


    }
}
