package 图书馆管理系统;

public class Book {
    String title; //书名
    String author;//作者
    int currentCount;//当前数量
    int totalCount;//总量
}



package 图书馆管理系统;

public abstract class User {  //定义抽象类
     public abstract void menu();
     public abstract void operation(int select);

}



package 图书馆管理系统;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookShelf {
    private static final BookShelf instance = new BookShelf();  //定义书架
    private BookShelf(){}
    public static BookShelf getBookShelf(){  //获取书架
        return instance;
    }
    List<Book> list = new ArrayList<>();
    public void add(Book book){
        list.add(book);
    }
    public Book[] getBooks(){
        Book[] array = new Book[list.size()];
        list.toArray(array);
        return array;
    }
    public void remove(String title){
        /*int Index = -1;
        for(int i=0;i<list.size();i++){
            Book book = list.get(i);
            if(book.title.equals(title)){
                Index = i;
            }
        }
        if(Index!=-1){
            list.remove(Index);
        }*/
        Iterator<Book> it = list.iterator();//迭代器删除
        while(it.hasNext()){
            Book book = it.next();
            if(book.title.equals(title)){
                it.remove();
            }
        }
    }
}



package 图书馆管理系统;

import java.util.Scanner;

public class Teacher extends User {
    @Override
    public void menu() {
        System.out.println("1、上架");
        System.out.println("2、下架");
        System.out.println("3、展示现有书籍");
    }

    @Override
    public void operation(int select) {
        switch (select){
            case 1:
                add();
                break;
            case 2:
                remove();
                break;
            case 3:
                show();
                break;
    
        }
    
    }
    
    private void show() {
        BookShelf bookShelf = BookShelf.getBookShelf();
        Book[] books = bookShelf.getBooks();
        System.out.println("书名  "+"作者  "+"当前数量  "+"总量");
        for(Book book:books){
            System.out.println(book.title+"  "+book.author+"  "+book.currentCount+"  "+book.totalCount);
        }
    }
    
    private void remove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要删除的书名");
        String title = scanner.nextLine();
        BookShelf bookShelf = BookShelf.getBookShelf();
        bookShelf.remove(title);
        System.out.println("成功");
    }
    
    private void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入书名");
        String title = scanner.nextLine();
        System.out.println("请输入作者");
        String author = scanner.nextLine();
        System.out.println("上架多少本书：");
        int count = scanner.nextInt();
        Book book = new Book();
        book.title = title;
        book.author = author;
        book.totalCount = count;
        book.currentCount = count;
        BookShelf bookShelf = BookShelf.getBookShelf();
        bookShelf.add(book);
        System.out.println("成功");
    
    }
}





package 图书馆管理系统;

import java.util.Scanner;

public class Student extends User {
    @Override
    public void menu() {
        System.out.println("1、借书");
        System.out.println("2、还书");
    }

    @Override
    public void operation(int select) {
        switch (select){
            case 1:
                borrow();
                break;
            case 2:
                returnbook();
        }
    }
    
    private void returnbook() {
        BookShelf bookShelf = BookShelf.getBookShelf();
        Book[] book = bookShelf.getBooks();
        System.out.println("所还书名：");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        for(Book book1:book){
            if(book1.title.equals(title)){
                System.out.println("还书成功");
                book1.currentCount++;
            }
        }
        System.out.println("该书不是本店的书！");
    
    }
    
    private void borrow() {
        BookShelf bookShelf = BookShelf.getBookShelf();
        Book[] book = bookShelf.getBooks();
        System.out.println("书名  "+"作者  "+"当前数量  "+"总量");
        for(Book book1:book){
            System.out.println(book1.title+"  "+book1.author+"  "+book1.currentCount+"  "+book1.totalCount);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("您要借哪本书");
        String title = scanner.nextLine();
        for(Book book1:book){
            if(book1.title.equals(title)){
                if(book1.currentCount>0){
                    System.out.println("借书成功");
                    book1.currentCount--;
                    return;
                }else{
                    System.out.println("没了");
                    return;
                }
    
            }
    
        }
        System.out.println("抱歉没这本书！");



    }

}



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