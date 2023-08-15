package hw_6.presentation;
import hw_6.data.BookStore;
import hw_6.data.IBookStore;
import hw_6.domain.Book;
import hw_6.domain.IBook;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        IBookStore bookStore = new BookStore();

        // Добавляем книги в магазин
        IBook book1 = new Book("1", "Clean Code", "Robert C. Martin", 34.99);
        IBook book2 = new Book("2", "Effective Java", "Joshua Bloch", 29.99);
        bookStore.addBook(book1);
        bookStore.addBook(book2);

        // Получаем список всех книг в магазине
        List<IBook> allBooks = bookStore.getAllBooks();
        for (IBook book : allBooks) {
            System.out.println("Книга: " + book.getTitle() + ", Автор: " + book.getAuthor() + ", Цена: $" + book.getPrice());
        }
    }
}