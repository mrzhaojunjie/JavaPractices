package 问题练习;

public class Book implements Comparable<Book>{
    public String ISBN;
    public String title;
    public String author;
    public int price;

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(!(obj instanceof Book)){
            return false;
        }
        Book book = (Book)obj;
        return this.ISBN.equals(book.ISBN);
    }
    @Override
    public int compareTo(Book book){
        if(this.price<book.price){
            return -1;
        }else if(this.price == book.price){
            return 0;
        }else{
            return 1;
        }
    }

    public static void main(String[] args) {
        Book book1 = new Book();
        book1.ISBN = "119";
        book1.author = "陈沛鑫";
        book1.price = 100;
        book1.title = "救火指南";
        Book book2 = new Book();
        book2.ISBN = "119";
        book2.author = "陈沛鑫";
        book2.price = 100;
        book2.title = "救火指南";
        System.out.println(book1.equals(book2));
        System.out.println(book1.compareTo(book2));

    }
}
