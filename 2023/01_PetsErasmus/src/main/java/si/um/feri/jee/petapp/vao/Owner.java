package si.um.feri.jee.petapp.vao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Owner {

    private String name;

    @Id
    private int id;

    @ManyToOne
    private Pet mytPet;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pet getMytPet() {
        return mytPet;
    }

    public void setMytPet(Pet mytPet) {
        this.mytPet = mytPet;
    }
}
