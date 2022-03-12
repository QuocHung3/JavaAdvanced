package BTCoBan2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Quốc Hùng
 */
public class ConnectSQLServer {
    public static Connection ConnectSQL (){
        String url = "net.sourceforge.jtds.jdbc.Driver";
        try {
            Class.forName(url);
            String dbUrl = "jdbc:jtds:sqlserver://DESKTOP-KMNS09Q:1433/BTCoBan2";
            return DriverManager.getConnection(dbUrl);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BankAccount.ConnectSQLServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
