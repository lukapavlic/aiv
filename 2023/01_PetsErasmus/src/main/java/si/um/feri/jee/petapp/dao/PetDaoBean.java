package si.um.feri.jee.petapp.dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import si.um.feri.jee.petapp.vao.Pet;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class PetDaoBean implements PetDao {

    //private List<Pet> pets=new ArrayList<>();

    @PersistenceContext
    EntityManager em;

    @Override
    public void add(Pet newOne) {
        System.out.println("Adding new pet "+newOne);
        //pets.add(newOne);

        em.persist(newOne);

        //newOne.setPetName("This is the name!");
    }

    @Override
    public List<Pet> getAll() {
        System.out.println("Getting pets");
       // return pets;
        return em.createQuery("select p from Pet p").getResultList();
    }

    @Override
    public Pet findOne(int id) {
        return em.find(Pet.class,id);
//        for (Pet p: pets)
//            if (p.getId()==id)
//                return p;
//        return null;
    }

}
