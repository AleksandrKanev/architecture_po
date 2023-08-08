package hw_5;

import java.util.ArrayList;
import java.util.List;

public class DemoDAO {
    public static void main(String[] args) {
        Book book1 = new Book(1, "Война и мир", "Л.Н. Толстой", "1863 г.");
        Book book2 = new Book(3, "Преступление и наказание", "Ф.М. Достоквский", "1866 г.");
        DAO db = new BookDAOImp();
        db.add(book1);
        db.add(book2);
        db.getAll();
        book2.setPublicDate("1867 г.");
        db.update(book2);
        db.getAll();
        db.delete(3);
        db.getAll();

    }
}

class Book {
    private final int id;
    private String name;
    private String author;
    private String publicDate;

    Book(int id, String name, String author, String publicDate){
        this.name = name;
        this.author = author;
        this.publicDate = publicDate;
        this.id = id;
    }
    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(String publicDate) {
        this.publicDate = publicDate;
    }
}

interface DAO {
    void add(Book book);

    void getAll();

    void update(Book book);

    void delete(int id);

}

class BookDAOImp implements DAO {

    private List<Book> list;

    BookDAOImp() {
        this.list = new ArrayList<Book>();
    }

    @Override
    public void add(Book book) {
        list.add(book);

    }

    @Override
    public void getAll() {
        for (Book b : list) {
            System.out.println(b.getId() + "|" + b.getName() + "|" + b.getAuthor() + "|" + b.getPublicDate());
        }
    }


    @Override
    public void update(Book book) {
        boolean flag = false;
        for (Book b: list) {
            if(b.getId() == book.getId()){
                b.setAuthor(book.getAuthor());
                b.setName(book.getName());
                b.setPublicDate(book.getPublicDate());
                flag = true;
            }
        }
        if(!flag){
            throw new RuntimeException("Книги с индентификационным номером "+ book.getId() + " в базе не существкет!");
        }
    }

    @Override
    public void delete(int id) {
        List <Book> newList = new ArrayList<>();
        for (Book b:list) {
            if(b.getId()!=id){
                newList.add(b);
            }
        }
        this.list = newList;
    }
}