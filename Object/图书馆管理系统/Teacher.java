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
