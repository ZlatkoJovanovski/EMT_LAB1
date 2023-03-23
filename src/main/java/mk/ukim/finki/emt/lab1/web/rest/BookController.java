package mk.ukim.finki.emt.lab1.web.rest;

import mk.ukim.finki.emt.lab1.model.Author;
import mk.ukim.finki.emt.lab1.model.Book;
import mk.ukim.finki.emt.lab1.model.Category;
import mk.ukim.finki.emt.lab1.model.dto.BookDto;
import mk.ukim.finki.emt.lab1.service.AuthorService;
import mk.ukim.finki.emt.lab1.service.BookService;
import mk.ukim.finki.emt.lab1.service.CountryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping({"/","/books"})
public class BookController {
    private final AuthorService authorService;
    private final BookService bookService;
    private final CountryService countryService;

    public BookController(AuthorService authorService, BookService bookService, CountryService countryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.countryService = countryService;
    }

    @GetMapping
    public List<Book> findAll(){
        return this.bookService.listAllBooks();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id) {
        return this.bookService.findById(id);
    }
    @PostMapping("/add")
    public Book save(BookDto bookDto) {
        return this.bookService.save(bookDto);
    }

    @PutMapping("/edit/{id}")
    public Book save(@PathVariable Long id, String name, Category category, Author author, Integer availableCopies) {
        return this.bookService.edit(id, name, category, author, availableCopies);
    }

    @DeleteMapping("/delete/{id}")
    public Book deleteById(@PathVariable Long id) {
        return this.bookService.delete(id);
    }

    @PostMapping("/taken/{id}")
    public Book markAsTaken(@PathVariable Long id, Integer availableCopies){
        return this.bookService.markAsTaken(id, availableCopies);
    }
}
