package mk.ukim.finki.emt.lab1.service.impl;

import mk.ukim.finki.emt.lab1.model.Author;
import mk.ukim.finki.emt.lab1.model.Book;
import mk.ukim.finki.emt.lab1.model.Category;
import mk.ukim.finki.emt.lab1.model.dto.BookDto;
import mk.ukim.finki.emt.lab1.model.exceptions.InvalidBookIdException;
import mk.ukim.finki.emt.lab1.repository.AuthorRepository;
import mk.ukim.finki.emt.lab1.repository.BookRepository;
import mk.ukim.finki.emt.lab1.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BookServiceImpl(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> listAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(InvalidBookIdException::new);
    }

    @Override
    public Book save(String name, Category category, Author author, Integer availableCopies) {
        Author authors = authorRepository.findById(author);
        Book book = new Book(name, category, authors, availableCopies);
        return bookRepository.save(book);
    }

    @Override
    public Book save(BookDto bookDto) {
        Book book = new Book(bookDto);
        return bookRepository.save(book);
    }

    @Override
    public Book edit(Long id, String name, Category category, Author author, Integer availableCopies) {
        Book book = this.findById(id);
        Author authors = authorRepository.findById(author);
        book.setName(name);
        book.setCategory(category);
        book.setAuthor(authors);
        book.setAvailableCopies(availableCopies);

        return bookRepository.save(book);
    }

    @Override
    public Book delete(Long id) {
        Book book = this.findById(id);
        bookRepository.delete(book);
        return book;
    }

    @Override
    public Book markAsTaken(Long id, Integer availableCopies) {
        Book book = this.bookRepository.findById(id).orElseThrow(InvalidBookIdException::new);
        book.setAvailableCopies(book.getAvailableCopies()-1);
        return this.bookRepository.save(book);
    }
}
