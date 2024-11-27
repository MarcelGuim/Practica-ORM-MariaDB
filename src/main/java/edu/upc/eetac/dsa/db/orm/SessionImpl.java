package edu.upc.eetac.dsa.db.orm;

import edu.upc.eetac.dsa.db.orm.Session;
import edu.upc.eetac.dsa.db.orm.util.ObjectHelper;
import edu.upc.eetac.dsa.db.orm.util.QueryHelper;
import jakarta.persistence.Table;

import java.sql.*;
import java.util.HashMap;
import java.util.List;


public class SessionImpl implements Session {
    private final Connection conn;

    public SessionImpl(Connection conn) {
        this.conn = conn;
    }

    public void save(Object entity) {
        // INSERT INTO Partida () ()
        String insertQuery = QueryHelper.createQueryINSERT(entity);
        // INSERT INTO User (ID, lastName, firstName, address, city) VALUES (0, ?, ?, ?,?)


        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(insertQuery);
            pstm.setObject(1, 0);
            int i = 2;
            for (String field: ObjectHelper.getFields(entity)) {
                pstm.setObject(i++, ObjectHelper.getter(entity, field));
            }
            pstm.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {

    }

//    @Override
//    public Object get(Class theClass, Object ID) {
//    }
    public Object get(Class theClass, Object ID){
        try{
            //Fem la query SQL: SELECT * FROM Users WHERE ID (PrimaryKey) = ?
            String tableName = theClass.getSimpleName();
            String sql = "SELECT * FROM " + tableName + " WHERE ID = ?";
            //String sql = QueryHelper.createQuerySELECT(tableName);
            //Crea un nou object del tipus theClass
            Object o = theClass.newInstance();

            PreparedStatement pstm = null;
            pstm = conn.prepareStatement(sql);
            pstm.setObject(1, ID);
            ResultSet res = pstm.executeQuery();
            if (res.next()){
                ResultSetMetaData rsmd = res.getMetaData();

                int numColumns = rsmd.getColumnCount();
                int i=1;

                while (i<numColumns+1) {
                    String key = rsmd.getColumnName(i);
                    Object value = res.getObject(i);

                    ObjectHelper.setter(o, key, value);
                    i++;
                }
                return o;
            }
            return null;
        }
        catch(Exception ex){
            return null;
        }
    }
//    public Object get(Class theClass, int ID) {
//        String sql = QueryHelper.createQuerySELECT(theClass);
//
//        Object o = theClass.newInstance();
//
//
//        ResultSet res = null;
//
//        ResultSetMetaData rsmd = res.getMetaData();
//
//        int numColumns = rsmd.getColumnCount();
//        int i=0;
//
//        while (i<numColumns) {
//            String key = rsmd.getColumnName(i);
//            String value = res.getObject(i);
//
//            ObjectHelper.setter(o, key, value);
//
//        }
//        return null;
//    }

    public void update(Object object) {

    }

    public void delete(Object object) {

    }

    public List<Object> findAll(Class theClass) {
        return null;
    }

    public List<Object> findAll(Class theClass, HashMap params) {
     /*   String theQuery = QueryHelper.createSelectFindAll(theClass, params);
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(theQuery);

        int i=1;
        for (Object value : params.values()) {
            pstm.setObject(i++, value );
        }
        //ResultSet rs = pstm.executeQuery();




        return result;
*/
     return null;
    }

    public List<Object> query(String query, Class theClass, HashMap params) {
        return null;
    }
}
