package si.um.feri.jee.petapp.jsf;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Data;
import si.um.feri.jee.petapp.dao.PetDao;
import si.um.feri.jee.petapp.ejb.MyFirstEjb;
import si.um.feri.jee.petapp.vao.Pet;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Named("petsbean")
@SessionScoped
@Data
public class MainViewJSFBean implements Serializable {

    Logger log=Logger.getLogger(this.getClass().getName());

    String nameOfNewPet;
    String kindOfNewPet;
    int idOfNewPet;
    List<Pet> petsInTheTable;

    @EJB
    PetDao dao;

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

    public List<Pet> getPetsInTheTable() {
        log.info("getPetsInTheTable");
        petsInTheTable=dao.getAll();
        return petsInTheTable;
    }

}
