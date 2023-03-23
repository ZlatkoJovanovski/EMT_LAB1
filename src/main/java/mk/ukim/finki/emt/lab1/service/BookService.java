package mk.ukim.finki.emt.lab1.service;

import mk.ukim.finki.emt.lab1.model.Author;
import mk.ukim.finki.emt.lab1.model.Book;
import mk.ukim.finki.emt.lab1.model.Category;
import mk.ukim.finki.emt.lab1.model.dto.BookDto;

import java.util.List;

public interface BookService {
    List<Book> listAllBooks();
    Book findById(Long id);
    Book save(String name, Category category, Author author, Integer availableCopies);
    Book save(BookDto bookDto);
    Book edit(Long Id, String name, Category category, Author author, Integer availableCopies);
    Book delete(Long id);
    Book markAsTaken(Long id, Integer availableCopies);
}
