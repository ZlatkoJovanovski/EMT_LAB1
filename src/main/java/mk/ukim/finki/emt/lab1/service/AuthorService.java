package mk.ukim.finki.emt.lab1.service;

import mk.ukim.finki.emt.lab1.model.Author;
import mk.ukim.finki.emt.lab1.model.Country;

import java.util.List;

public interface AuthorService {
    List<Author> listAll();
    Author findById(Long id);
    Author save(String name, String surname, Country country);
}
