package edu.upc.eetac.dsa.dao.impl;

import edu.upc.eetac.dsa.dao.Session;
import edu.upc.eetac.dsa.util.QueryHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class SessionImpl<E> implements Session<E> {

    private final Connection conn;

    SessionImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void save(E entity) {
        String query = QueryHelper.createQueryINSERT(entity);
        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
    public E get(E entity) {
        String query = QueryHelper.createQuerySELECT(entity);
        PreparedStatement pstm = null;
        E res = null;

        try {
            pstm = conn.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

    @Override
    public E getById(Class theClass, String id) {
        String query = QueryHelper.createQuerySELECTById(theClass, id);
        PreparedStatement pstm = null;
        E res = null;

        try {
            pstm = conn.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

    @Override
    public E getByName(Class theClass, String name) {
        String query = QueryHelper.createQuerySELECTByName(theClass, name);
        PreparedStatement pstm = null;
        E res = null;

        try {
            pstm = conn.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

    @Override
    public List<E> getAll(Class theClass) {
        String query = QueryHelper.createQuerySELECTAll(theClass);
        PreparedStatement pstm = null;
        List<E> res = new LinkedList<E>();

        try {
            pstm = conn.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

    @Override
    public void update(E entity) {
        String query = QueryHelper.createQueryUPDATE(entity);
        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(E entity) {
        String query = QueryHelper.createQueryDELETE(entity);
        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
