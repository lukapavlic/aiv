package si.um.feri.jee.petapp.dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import si.um.feri.jee.petapp.vao.Pet;
import java.util.List;

@Stateless
public class PetDaoBean implements PetDao {

    @PersistenceContext
    EntityManager em;

    @Override
    public void add(Pet newOne) {
        System.out.println("Adding new pet "+newOne);
        em.persist(newOne);
    }

    @Override
    public List<Pet> getAll() {
        System.out.println("Getting pets");
        return em.createQuery("select p from Pet p").getResultList();
    }

    @Override
    public Pet findOne(int id) {
        return em.find(Pet.class,id);
    }

}
