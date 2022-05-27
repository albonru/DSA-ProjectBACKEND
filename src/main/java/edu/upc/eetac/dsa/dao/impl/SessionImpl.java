package edu.upc.eetac.dsa.dao.impl;

import edu.upc.eetac.dsa.dao.Session;
import edu.upc.eetac.dsa.util.ObjectHelper;
import edu.upc.eetac.dsa.util.QueryHelper;

import java.beans.IntrospectionException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class SessionImpl<E> implements Session<E> {

    private final Connection conn;

    SessionImpl(Connection conn) {
        this.conn = conn;
    }

    // FET
    @Override
    public void save(E entity) {
        String query = QueryHelper.createQueryINSERT(entity);
        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(query);

            int i = 0;
            for (String f: ObjectHelper.getFields(entity)) {
                pstm.setObject(i++, ObjectHelper.getter(entity,f));
            }
            pstm.executeQuery();

        } catch (SQLException | IntrospectionException e) {
            e.printStackTrace();
        }
    }

    // FET
    @Override
    public void close() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public E get(E entity) throws IntrospectionException {
        String query = QueryHelper.createQuerySELECT(entity);
        PreparedStatement pstm = null;
        E res = null;

        try {
            pstm = conn.prepareStatement(query);

            pstm.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

    // FET
    @Override
    public E getById(Class theClass, String id) {
        String query = QueryHelper.createQuerySELECTById(theClass, id);
        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(query);
            pstm.executeQuery();
            ResultSet rs = pstm.getResultSet();
            ResultSetMetaData rsmd = rs.getMetaData();

            Object entity = theClass.newInstance();
            if(ObjectHelper.getter(entity,"id").equals(null)) {
                return null;
            }

            while(rs.next()) {
                for (int i = 1; i<rsmd.getColumnCount(); i++) {
                    ObjectHelper.setter(entity,rsmd.getColumnName(i),rs.getObject(i));
                }
            }
            return (E) entity;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }

        return null;
    }

    // FET
    @Override
    public E getByName(Class theClass, String name) {
        String query = QueryHelper.createQuerySELECTByName(theClass, name);
        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(query);
            pstm.executeQuery();
            ResultSet rs = pstm.getResultSet();
            ResultSetMetaData rsmd = rs.getMetaData();

            Object entity = theClass.newInstance();
            if(ObjectHelper.getter(entity,"name").equals(null)) {
                return null;
            }

            while(rs.next()) {
                for (int i = 1; i<rsmd.getColumnCount(); i++) {
                    ObjectHelper.setter(entity,rsmd.getColumnName(i),rs.getObject(i));
                }
            }
            return (E) entity;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }

        return null;
    }

    // FET
    @Override
    public List<E> getAll(Class theClass) {
        String query = QueryHelper.createQuerySELECTAll(theClass);
        PreparedStatement pstm = null;
        List<E> res = new LinkedList<E>();

        try {
            pstm = conn.prepareStatement(query);
            pstm.executeQuery();
            ResultSet rs = pstm.getResultSet();
            ResultSetMetaData rsmd = rs.getMetaData();

            while(rs.next()) {
                Object entity = theClass.newInstance();
                for (int i = 1; i<rsmd.getColumnCount(); i++) {
                    ObjectHelper.setter(entity,rsmd.getColumnName(i),rs.getObject(i));
                }
                res.add((E) entity);
            }
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void update(E entity) throws IntrospectionException {
        String query = QueryHelper.createQueryUPDATE(entity);
        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(query);

            int i = 0;


            pstm.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // FET
    @Override
    public void delete(E entity) throws IntrospectionException {
        String query = QueryHelper.createQueryDELETE(entity);
        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(query);
            pstm.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
