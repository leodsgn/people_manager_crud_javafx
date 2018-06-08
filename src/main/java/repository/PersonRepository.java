package repository;

import database.Database;
import models.BaseModel;
import models.Person;

import java.util.List;

public class PersonRepository extends Database implements IRepository<Person> {

    @Override
    public Person create(Person model) {
        return null;
    }

    @Override
    public Person read(Person model) {
        return null;
    }

    @Override
    public List<Person> readAll(Person model) {
        return null;
    }

    @Override
    public Person update(Person model) {
        return null;
    }

    @Override
    public boolean destroy(Person model) {
        return false;
    }

    @Override
    public boolean destroy(int id) {
        return false;
    }
}
