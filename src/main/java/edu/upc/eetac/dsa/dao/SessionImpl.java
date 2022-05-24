package edu.upc.eetac.dsa.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class SessionImpl implements Session {

    private final Connection conn;

    SessionImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void save(Object entity) {

    }

    @Override
    public void close() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object get(Class theClass, String pk) {
        return null;
    }

    @Override
    public void update(Object object) {

    }

    @Override
    public void delete(Object object) {

    }

    @Override
    public List<Object> findAll(Class theClass) {
        return null;
    }

    @Override
    public List<Object> findAll(Class theClass, HashMap params) {
        return null;
    }

    @Override
    public List<Object> query(String query, Class theClass, HashMap params) {
        return null;
    }

    @Override
    public Object singleQuery(String query, Class theClass, HashMap params) {
        return null;
    }
}
