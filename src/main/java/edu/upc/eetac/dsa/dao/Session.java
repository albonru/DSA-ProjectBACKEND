package edu.upc.eetac.dsa.dao;

import java.util.HashMap;
import java.util.List;

public interface Session<E> {
    void save(E entity);
    void close();
    E get(E entity);
    E getById(Class theClass, String id);
    E getByName(Class theClass, String name);
    List<E> getAll(Class theClass);
    void update(E entity);
    void delete(E entity);
}
