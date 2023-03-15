package si.um.feri.jee.petapp.vao;

import jakarta.persistence.*;

@Entity
public class Pet {

    public Pet() {

    }

    public Pet(int id, String kind, String name) {
        this.id = id;
        this.petKind = kind;
        this.petName = name;
    }

    @Id
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
