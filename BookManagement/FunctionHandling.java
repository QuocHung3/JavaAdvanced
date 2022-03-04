    package BookManagement;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
/**
 *
 * @author Quốc Hùng
 */
public class FunctionHandling {

    public List<Sach> GetDataSach() {
        List<Sach> listSachs = new ArrayList<>();
        Connection conn = Connect.ConnectSQL();
        
        try {
            PreparedStatement ps = conn.prepareStatement("select t.*,s.tenTG,s.soTrang \n" 
                                                        + "from TaiLieu as t,Sach as s\n" 
                                                        + "where t.maTL = s.maTL");
            ResultSet result = ps.executeQuery();
            
            while (result.next()) {
                Sach sach = new Sach();
                
                sach.setMaTaiLieu(result.getString("maTL"));
                sach.setTenNSB(result.getString("tenNSB"));
                sach.setSoBanPhatHanh(result.getInt("soBanPhatHanh"));
                sach.setTenTG(result.getString("tenTG"));
                sach.setSoTrang(result.getInt("soTrang"));
                
                listSachs.add(sach);
            }
            return listSachs;
        } catch (SQLException ex) {
            Logger.getLogger(FunctionHandling.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<TapChi> GetDataTapChi() {
        List<TapChi> listTapchis = new ArrayList<>();
        Connection conn = Connect.ConnectSQL();
        
        try {
            PreparedStatement ps = conn.prepareStatement("select t.*,tc.soPhatHanh,tc.thangPhatHanh \n" 
                                                        + "from TaiLieu as t,TapChi as tc\n" 
                                                        + "where t.maTL = tc.maTL");
            ResultSet result = ps.executeQuery();
            
            while (result.next()) {
                TapChi tc = new TapChi();
                
                tc.setMaTaiLieu(result.getString("maTL"));
                tc.setTenNSB(result.getString("tenNSB"));
                tc.setSoBanPhatHanh(result.getInt("soBanPhatHanh"));
                tc.setSoPhatHanh(result.getString("soPhatHanh"));
                tc.setThangPhatHanh(result.getInt("thangPhatHanh"));
                
                
                listTapchis.add(tc);
            }
            return listTapchis;
        } catch (SQLException ex) {
            Logger.getLogger(FunctionHandling.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Bao> GetDataBao() {
        List<Bao> listBaos = new ArrayList<>();
        Connection conn = Connect.ConnectSQL();
        
        try {
            PreparedStatement ps = conn.prepareStatement("select t.*,b.ngayPhatHanh \n" 
                                                        + "from TaiLieu as t,Bao as b\n" 
                                                        + "where t.maTL = b.maTL");
            ResultSet result = ps.executeQuery();
            
            while (result.next()) {
                Bao bao = new Bao();
                
                bao.setMaTaiLieu(result.getString("maTL"));
                bao.setTenNSB(result.getString("tenNSB"));
                bao.setSoBanPhatHanh(result.getInt("soBanPhatHanh"));
                java.sql.Date date = result.getDate("ngayPhatHanh");
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String dateStr = dateFormat.format(date);
                bao.setNgayPhatHanh(dateStr);
                
                listBaos.add(bao);
            }
            return listBaos;
        } catch (SQLException ex) {
            Logger.getLogger(FunctionHandling.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public void AddNewBook(Sach sach) {
        Connection conn = Connect.ConnectSQL();
        
        try {
            PreparedStatement ps = conn.prepareStatement("insert into TaiLieu values(?,?,?)");
                                                        
            PreparedStatement ps1 = conn.prepareStatement("insert into Sach values(?,?,?)");
            ps.setString(1, sach.getMaTaiLieu());
            ps.setString(2, sach.getTenNSB());
            ps.setInt(3, sach.getSoBanPhatHanh());
            
            ps1.setString(1, sach.getMaTaiLieu());
            ps1.setString(2, sach.getTenTG());
            ps1.setInt(3, sach.getSoTrang());
            
            int result = ps.executeUpdate();
            int result1 = ps1.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FunctionHandling.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Lỗi! \nVui lòng kiểm tra lại cacs "
                    + "trường nhập", "Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
    
    public void AddNewTC(TapChi tc) {
        Connection conn = Connect.ConnectSQL();
        
        try {
            PreparedStatement ps = conn.prepareStatement("insert into TaiLieu values(?,?,?)");
                                                        
            PreparedStatement ps1 = conn.prepareStatement("insert into TapChi values(?,?,?)");
            ps.setString(1, tc.getMaTaiLieu());
            ps.setString(2, tc.getTenNSB());
            ps.setInt(3, tc.getSoBanPhatHanh());
            
            ps1.setString(1, tc.getMaTaiLieu());
            ps1.setString(2, tc.getSoPhatHanh());
            ps1.setInt(3, tc.getThangPhatHanh());
            
            int result = ps.executeUpdate();
            int result1 = ps1.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FunctionHandling.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Lỗi! \nVui lòng kiểm tra lại cacs "
                    + "trường nhập", "Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
    
    public void AddNewBao(Bao bao) {
        Connection conn = Connect.ConnectSQL();
        
        try {
            PreparedStatement ps = conn.prepareStatement("insert into TaiLieu values(?,?,?)");
                                                        
            PreparedStatement ps1 = conn.prepareStatement("insert into Bao values(?,?)");
            ps.setString(1, bao.getMaTaiLieu());
            ps.setString(2, bao.getTenNSB());
            ps.setInt(3, bao.getSoBanPhatHanh());
            
            ps1.setString(1, bao.getMaTaiLieu());
            ps1.setString(2, bao.getNgayPhatHanh());
            
            int result = ps.executeUpdate();
            int result1 = ps1.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FunctionHandling.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Lỗi! \nVui lòng kiểm tra lại cacs "
                    + "trường nhập", "Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
    
    public void DeleteRowSach(String maTL) {
        Connection conn = Connect.ConnectSQL();
        
        try {
            PreparedStatement ps = conn.prepareStatement("delete from Sach where maTL = ?");
                                                        
            PreparedStatement ps1 = conn.prepareStatement("delete from TaiLieu where maTL = ?");
            ps.setString(1, maTL);
            ps1.setString(1, maTL);
            
            int result = ps.executeUpdate();
            int result1 = ps1.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FunctionHandling.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Lỗi!", "Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
    
    public void DeleteRowTC(String maTL) {
        Connection conn = Connect.ConnectSQL();
        
        try {
            PreparedStatement ps = conn.prepareStatement("delete from TapChi where maTL = ?");
                                                        
            PreparedStatement ps1 = conn.prepareStatement("delete from TaiLieu where maTL = ?");
            ps.setString(1, maTL);
            ps1.setString(1, maTL);
            
            int result = ps.executeUpdate();
            int result1 = ps1.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FunctionHandling.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Lỗi!", "Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
    
    public void DeleteRowBao(String maTL) {
        Connection conn = Connect.ConnectSQL();
        
        try {
            PreparedStatement ps = conn.prepareStatement("delete from Bao where maTL = ?");
                                                        
            PreparedStatement ps1 = conn.prepareStatement("delete from TaiLieu where maTL = ?");
            ps.setString(1, maTL);
            ps1.setString(1, maTL);
            
            int result = ps.executeUpdate();
            int result1 = ps1.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FunctionHandling.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Lỗi!", "Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
}


