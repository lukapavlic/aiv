package si.um.feri.jee.petapp.dao;

import jakarta.ejb.Local;
import si.um.feri.jee.petapp.vao.Pet;
import java.util.List;

@Local
public interface PetDao {
    void add(Pet newOne);

    List<Pet> getAll();

    Pet findOne(int id);

}
