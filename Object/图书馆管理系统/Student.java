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
