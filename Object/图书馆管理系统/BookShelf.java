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
