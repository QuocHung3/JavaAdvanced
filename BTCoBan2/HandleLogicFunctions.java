package BTCoBan2;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Quốc Hùng
 */
public class HandleLogicFunctions {
    public List<Staff> GetAllStaff() {
        List<Staff> staffs = new ArrayList<Staff>();
        Connection conn = ConnectSQLServer.ConnectSQL();
        
        try {
            PreparedStatement ps = conn.prepareStatement("select * from Staff");
            ResultSet result = ps.executeQuery();
            
            while (result.next()) {
                Staff staff = new Staff();
                
                staff.setID(result.getString("ID"));
                staff.setName(result.getString("name"));
                staff.setAddress(result.getString("address"));
                staff.setEmail(result.getString("email"));
                staff.setPhoneNumber(result.getString("phoneNumber"));
                staff.setGender(result.getBoolean("gender"));
                
                staffs.add(staff);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HandleLogicFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return staffs;
    }
    
    public List<Account> GetAllAccount() {
        List<Account> accounts = new ArrayList<Account>();
        Connection conn = ConnectSQLServer.ConnectSQL();
        
        try {
            PreparedStatement ps = conn.prepareStatement("select * from Account");
            ResultSet result = ps.executeQuery();
            
            while (result.next()) {
                Account account = new Account();
                
                account.setAccID(result.getString("accID"));
                account.setPassword(result.getString("password"));
                
                accounts.add(account);
            }
            return accounts;
        } catch (SQLException ex) {
            Logger.getLogger(HandleLogicFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Account TestLogin(String ID) {
        Connection conn = ConnectSQLServer.ConnectSQL();
        
        try {
            PreparedStatement ps = conn.prepareStatement("select * from Account");
            ResultSet result = ps.executeQuery();
            
            while (result.next()) {
                if(result.getString("accID").equals(ID)) {
                    Account acc = new Account();
                    System.out.println(ID);
                    acc.setAccID(result.getString("accID"));
                    acc.setPassword(result.getString("password"));
                    
                    return acc;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(HandleLogicFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void SigupAccount(Account account) {
        Connection conn = ConnectSQLServer.ConnectSQL();
        
        try {
            PreparedStatement ps = conn.prepareStatement("insert into Account values (?,?)");
            ps.setString(1, account.getAccID());
            ps.setString(2, account.getPassword());
            
            int result  = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HandleLogicFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void AddNewStaff(Staff staff) {
        Connection conn = ConnectSQLServer.ConnectSQL();
        
        try {
            PreparedStatement ps = conn.prepareStatement("insert into Staff values (?,?,?,?,?,?)");
            ps.setString(1, staff.getID());
            ps.setString(2, staff.getName());
            ps.setString(3, staff.getAddress());
            ps.setString(4, staff.getEmail());
            ps.setString(5, staff.getPhoneNumber());
            ps.setBoolean(6, staff.isGender());
                
            
            int result  = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HandleLogicFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void DeleteStaff(String ID) {
        Connection conn = ConnectSQLServer.ConnectSQL();
        
        try {
            PreparedStatement ps = conn.prepareStatement("delete from Staff where ID = ?");
            ps.setString(1, ID);

            int result  = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HandleLogicFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void UpdateStaff(Staff staff) {
        Connection conn = ConnectSQLServer.ConnectSQL();
        
        try {
            PreparedStatement ps = conn.prepareStatement("update Staff "
                    + "set name = ?,address = ?,email = ?,phoneNumber = ?,gender = ?"
                    + "where ID = ?");
            ps.setString(1, staff.getName());
            ps.setString(2, staff.getAddress());
            ps.setString(3, staff.getEmail());
            ps.setString(4, staff.getPhoneNumber());
            ps.setBoolean(5, staff.isGender());
            ps.setString(6, staff.getID());

            int result  = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HandleLogicFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Staff> GetResultSearch(String searchType,String valueSearch) {
        List<Staff> staffs = new ArrayList<>();
        Connection conn = ConnectSQLServer.ConnectSQL();
        
        try {
            PreparedStatement ps = null;
            switch(searchType) {
            case "ID" : 
                 ps = conn.prepareStatement("select * from Staff where ID = ?");
                ps.setObject(1, valueSearch);  
                break;
            
            case "Name" : 
                 ps = conn.prepareStatement("select * from Staff where name = ?");
                ps.setObject(1, valueSearch);  
                break;
             
            case "Address" : 
                 ps = conn.prepareStatement("select * from Staff where address = ?");
                ps.setObject(1, valueSearch);  
                break;
                
            case "Email" : 
                 ps = conn.prepareStatement("select * from Staff where email = ?");
                ps.setObject(1, valueSearch);  
                break;   
             
            case "Phone Number" : 
                 ps = conn.prepareStatement("select * from Staff where phoneNumber = ?");
                ps.setObject(1, valueSearch);  
                break;
            }
            

            ResultSet result = ps.executeQuery();
            
            while(result.next()) {
                Staff staff = new Staff();
                
                staff.setID(result.getString("ID"));
                staff.setName(result.getString("name"));
                staff.setAddress(result.getString("address"));
                staff.setEmail(result.getString("email"));
                staff.setPhoneNumber(result.getString("phoneNumber"));
                if(result.getString("gender").equals(1)) {
                    staff.setGender(true);
                } else {
                    staff.setGender(false);
                }
                    
                staffs.add(staff);
            }
            return staffs;
        } catch (SQLException ex) {
            Logger.getLogger(HandleLogicFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
