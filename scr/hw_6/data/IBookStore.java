package hw_6.data;

import hw_6.domain.IBook;

import java.util.ArrayList;
import java.util.List;

public interface IBookStore {

    void addBook(IBook book);
    void removeBook(IBook book);
    List<IBook> getAllBooks();
}
