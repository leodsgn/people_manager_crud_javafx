package repository;

import models.BaseModel;
import models.Person;

import java.util.List;

public interface IRepository<T extends BaseModel> {
    T create(T model);
    T read(T model);
    List<T> readAll(T model);
    T update(T model);
    boolean destroy(T model);
    boolean destroy(int id);
}
