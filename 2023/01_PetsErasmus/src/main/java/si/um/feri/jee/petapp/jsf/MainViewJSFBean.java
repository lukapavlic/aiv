package si.um.feri.jee.petapp.jsf;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import si.um.feri.jee.petapp.dao.PetDao;
import si.um.feri.jee.petapp.ejb.MyFirstEjb;
import si.um.feri.jee.petapp.vao.Pet;
import java.io.Serializable;
import java.util.List;

@Named("petsbean")
@SessionScoped
public class MainViewJSFBean implements Serializable {

    String nameOfNewPet;

    String kindOfNewPet;

    int idOfNewPet;

    PetDao dao=new PetDao();

    List<Pet> petsInTheTable;

    @EJB
    MyFirstEjb ejb;
    public void addNewPet() {
        Pet newOne=new Pet(idOfNewPet,kindOfNewPet,nameOfNewPet);
        dao.add(newOne);
        kindOfNewPet="";
        nameOfNewPet="";
        //call EJB
        ejb.sayHello("John");
    }

    public String getNameOfNewPet() {
        return nameOfNewPet;
    }

    public void setNameOfNewPet(String nameOfNewPet) {
        this.nameOfNewPet = nameOfNewPet;
    }

    public String getKindOfNewPet() {
        return kindOfNewPet;
    }

    public void setKindOfNewPet(String kindOfNewPet) {
        this.kindOfNewPet = kindOfNewPet;
    }

    public int getIdOfNewPet() {
        return idOfNewPet;
    }

    public void setIdOfNewPet(int idOfNewPet) {
        this.idOfNewPet = idOfNewPet;
    }

    public PetDao getDao() {
        return dao;
    }

    public void setDao(PetDao dao) {
        this.dao = dao;
    }

    public List<Pet> getPetsInTheTable() {
        System.out.println("getPetsInTheTable");
        petsInTheTable=dao.getAll();
        return petsInTheTable;
    }

    public void setPetsInTheTable(List<Pet> petsInTheTable) {
        this.petsInTheTable = petsInTheTable;
    }

}
