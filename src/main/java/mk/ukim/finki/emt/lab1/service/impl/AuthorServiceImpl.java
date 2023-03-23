package mk.ukim.finki.emt.lab1.service.impl;

import mk.ukim.finki.emt.lab1.model.Author;
import mk.ukim.finki.emt.lab1.model.Country;
import mk.ukim.finki.emt.lab1.model.exceptions.InvalidAuthorIdException;
import mk.ukim.finki.emt.lab1.repository.AuthorRepository;
import mk.ukim.finki.emt.lab1.repository.CountryRepository;
import mk.ukim.finki.emt.lab1.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> listAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Author findById(Long id) {
        return this.authorRepository.findById(id).orElseThrow(InvalidAuthorIdException::new);
    }

    @Override
    public Author save(String name, String surname, Country country) {
        Author author = new Author(name, surname, country);
        return this.authorRepository.save(author);
    }

}
