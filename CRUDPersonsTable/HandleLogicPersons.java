package CRUDPersonsTable;

import java.util.List;

/**
 *
 * @author Quốc Hùng
 */
public class HandleLogicPersons {
    private CRUDPersons crud;
    
    public HandleLogicPersons () {
        crud = new CRUDPersons();  
    }
    
    //tra ve danh sach kieu Persons
    public List<Persons> GetAllPersons() {
        return crud.getAllPersons();     
    }
    
    public void AddNewPersons(Persons person) {
        crud.AddPersons(person);
    }
    
    public void DeletePersons(String Id ) {
        crud.DeletePerson(Id);
    }
    
    public Persons GetPersonByID(String IDperson) {
        return crud.GetPesronByID(IDperson);
    }
        
    
    public void EditPersons(Persons person) {
        crud.UpdatePerson(person);
    }
        
}
