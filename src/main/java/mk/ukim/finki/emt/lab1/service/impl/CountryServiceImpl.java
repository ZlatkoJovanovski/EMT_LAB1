package mk.ukim.finki.emt.lab1.service.impl;

import mk.ukim.finki.emt.lab1.model.Country;
import mk.ukim.finki.emt.lab1.model.exceptions.InvalidCountryIdException;
import mk.ukim.finki.emt.lab1.repository.CountryRepository;
import mk.ukim.finki.emt.lab1.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> listAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Country findById(Long id) {
        return this.countryRepository.findById(id).orElseThrow(InvalidCountryIdException::new);
    }

    @Override
    public Country save(String name, String continent) {
        Country country = new Country(name, continent);
        return this.countryRepository.save(country);
    }
}
