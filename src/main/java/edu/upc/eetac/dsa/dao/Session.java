package edu.upc.eetac.dsa.dao;

import java.util.HashMap;
import java.util.List;

public interface Session {
    void save(Object entity);
    void close();
    Object get(Class theClass, String id);
    void update(Object object);
    void delete(Object object);
    List<Object> findAll(Class theClass);
    List<Object> findAll(Class theClass, HashMap params);
    List<Object> query(String query, Class theClass, HashMap params);
    Object singleQuery(String query, Class theClass, HashMap params);
}
