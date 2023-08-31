package mvcPattern.sadstill.webLibrary.dao;

import mvcPattern.sadstill.webLibrary.models.Book;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import mvcPattern.sadstill.webLibrary.models.Person;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO Person(name, surname, last_name, birth_date) values (?, ?, ?, ?)",
                person.getName(), person.getSurname(), person.getLastName(), person.getBirthDate());
    }

    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE id = ?", new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
    }

    public void update(int id, Person updatedPerson) {
        jdbcTemplate.update("UPDATE Person SET name = ?, surname = ?, last_name = ?, birth_date = ? WHERE id = ?",
                updatedPerson.getName(), updatedPerson.getSurname(),
                updatedPerson.getLastName(), updatedPerson.getBirthDate(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id = ?", id);
    }

    public Optional<Person> getPersonByFullName(String name, String surname, String lastName) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE name = ? AND surname = ? AND last_name = ?",
                new Object[]{name, surname, lastName}, new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }

    public List<Book> getBooksByPersonId(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE person_id = ?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Book.class));
    }
}
