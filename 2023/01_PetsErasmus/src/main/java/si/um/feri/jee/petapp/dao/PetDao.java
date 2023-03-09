package si.um.feri.jee.petapp.dao;

import si.um.feri.jee.petapp.vao.Pet;
import java.util.ArrayList;
import java.util.List;

public class PetDao {

    private List<Pet> pets=new ArrayList<>();

    public void add(Pet newOne) {
        System.out.println("Adding new pet "+newOne);
        pets.add(newOne);
    }

    public List<Pet> getAll() {
        System.out.println("Getting pets");
        return pets;
    }

    public Pet findOne(int id) {
        for (Pet p: pets)
            if (p.getId()==id)
                return p;
        return null;
    }

}
