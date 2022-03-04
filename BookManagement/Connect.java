package BookManagement;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Quốc Hùng
 */
public class Connect {
    
    public static Connection ConnectSQL (){
        String url = "net.sourceforge.jtds.jdbc.Driver";
        try {
            Class.forName(url);
            String dbUrl = "jdbc:jtds:sqlserver://DESKTOP-KMNS09Q:1433/BookManagement";
            return DriverManager.getConnection(dbUrl);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}