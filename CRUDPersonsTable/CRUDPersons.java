package CRUDPersonsTable;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Quốc Hùng
 */
public class CRUDPersons {
    
    
    //ham tra ve danh sach kieu Persons 
    public List<Persons> getAllPersons() {
        List<Persons> persons = new ArrayList<Persons>();
        Connection conn = Connect.ConnectSQL();
        
        try {
            PreparedStatement ps = conn.prepareStatement("select * from Persons");
            ResultSet result = ps.executeQuery();
            
            while (result.next()) {
                Persons person = new Persons();
                
                person.setID(result.getString("ID"));
                person.setName(result.getString("Name"));
                person.setAddress(result.getString("Address"));
                
                persons.add(person);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUDPersons.class.getName()).log(Level.SEVERE, null, ex);
        }
        return persons;
    }
    
    //Ham lay ra Persons theo ID
    public Persons GetPesronByID(String IDperson) {
        Connection conn = Connect.ConnectSQL();
        
        try {
            PreparedStatement ps = conn.prepareStatement("select * from Persons where ID = ?");
            ps.setString(1, IDperson);
            ResultSet result = ps.executeQuery();
            
            Persons person = new Persons();
            while (result.next()) {
                person.setID(result.getString("ID"));
                person.setName(result.getString("Name"));
                person.setAddress(result.getString("Address"));
            }
            return person;
        } catch (SQLException ex) {
            Logger.getLogger(CRUDPersons.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(IDperson.equals(null)) {
            System.out.println("GetPesronByID() person is null.");
        }
        return null;
    }
    
    //Ham them 1 nguoi dung
    public void AddPersons(Persons person) {
        
        Connection conn = Connect.ConnectSQL();
        
        try {
            PreparedStatement ps = conn.prepareStatement("insert into Persons values (?,?,?)");
            ps.setString(1, person.getID());
            ps.setString(2, person.getName());
            ps.setString(3, person.getAddress());    
            
            int result = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CRUDPersons.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    
    //Ham sua  nguoi dung
    public void UpdatePerson (Persons person) {
        
        Connection conn = Connect.ConnectSQL();
        
        try {
            PreparedStatement ps = conn.prepareStatement("update Persons set Name = ?, Address = ? where ID = ?");
            
            ps.setString(1, person.getName());
            ps.setString(2, person.getAddress());  
            ps.setString(3, person.getID());
            
            int result = ps.executeUpdate();
            System.out.println(result);
        } catch (SQLException ex) {
            Logger.getLogger(CRUDPersons.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    
    // Ham xoa nguoi dung
    public void DeletePerson (String Id) {
        Connection conn = Connect.ConnectSQL();
        
        try {
            PreparedStatement ps = conn.prepareStatement("delete from Persons where ID = ?");
            ps.setString(1,Id);
            
            int result = ps.executeUpdate();
            System.out.println(result);
        } catch (SQLException ex) {
            Logger.getLogger(CRUDPersons.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
