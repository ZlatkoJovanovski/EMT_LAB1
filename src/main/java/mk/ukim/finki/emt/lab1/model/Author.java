package mk.ukim.finki.emt.lab1.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @ManyToOne(fetch = FetchType.EAGER)
    private Country country;

    public Author() {

    }
    public Author(String name, String surname, Country country) {
    }
    public Author(Long id, String name, String surname, Country country) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.country = country;
    }
}
