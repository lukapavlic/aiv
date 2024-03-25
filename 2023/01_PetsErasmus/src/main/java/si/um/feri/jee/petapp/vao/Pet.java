package si.um.feri.jee.petapp.vao;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Pet {

    public Pet() {

    }

    public Pet(int id, String kind, String name) {
        this.id = id;
        this.petKind = kind;
        this.petName = name;
    }

    @OneToMany
    private List<Owner> owners;

    public List<Owner> getOwners() {
        return owners;
    }

    public void setOwners(List<Owner> owners) {
        this.owners = owners;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String petKind;

    String petName;

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", kind='" + petKind + '\'' +
                ", name='" + petName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPetKind() {
        return petKind;
    }

    public void setPetKind(String petKind) {
        this.petKind = petKind;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String name) {
        this.petName = name;
    }

}
