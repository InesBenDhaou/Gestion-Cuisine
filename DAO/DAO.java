package DAO;
import java.sql.Connection;
import java.util.ArrayList;

public abstract class DAO <T> {
    protected Connection cnx ;

    public DAO(Connection cnx) {
        this.cnx = cnx;
    }

    public abstract ArrayList<T> findall ();
    public abstract T find (String id);
    public abstract boolean create (T obj);
    public abstract boolean update (T obj);
    public abstract boolean delete (T obj);  
}
