package BTCoBan2;

/**
 *
 * @author Quốc Hùng
 */
public class Account {
    String accID,password;

    public Account() {
    }

    public Account(String accID, String password) {
        this.accID = accID;
        this.password = password;
    }

    public String getAccID() {
        return accID;
    }

    public void setAccID(String accID) {
        this.accID = accID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
    
}
