package si.um.feri.jee.petapp.dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import si.um.feri.jee.petapp.vao.Pet;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class PetDaoBean implements PetDao {

    Logger log=Logger.getLogger(this.getClass().getName());

    @PersistenceContext
    EntityManager em;

    @Override
    public void add(Pet newOne) {
        log.info("Adding new pet "+newOne);
        em.persist(newOne);
    }

    @Override
    public List<Pet> getAll() {
        log.info("Getting pets");
        return em.createQuery("select p from Pet p").getResultList();
    }

    @Override
    public Pet findOne(int id) {
        return em.find(Pet.class,id);
    }

}
