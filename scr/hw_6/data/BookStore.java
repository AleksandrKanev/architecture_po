package hw_6.data;

import hw_6.domain.IBook;

import java.util.ArrayList;
import java.util.List;

// Класс, реализующий хранилище книг с использованием коллекций
public class BookStore implements IBookStore{
    private List<IBook> books;

    public BookStore() {
        books = new ArrayList<>();
    }

    public void addBook(IBook book) {
        books.add(book);
    }

    public void removeBook(IBook book) {
        books.remove(book);
    }

    public List<IBook> getAllBooks() {
        return books;
    }
}
