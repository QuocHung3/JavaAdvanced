package BTCoBan2;

/**
 *
 * @author Quốc Hùng
 */
public class Staff {
    String ID,name,address,phoneNumber,email;
    boolean gender;

    public Staff() {
    }

    public Staff(String ID, String name, String address, String phoneNumber, String email, boolean gender) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
    }

    
    
    public String getID() {
        return ID;
    }
    

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Staff{" + "ID=" + ID + ", name=" + name + ", address=" + address + ", phoneNumber=" + phoneNumber + ", email=" + email + ", gender=" + gender + '}';
    }
    
    
}
