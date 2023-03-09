package si.um.feri.jee.petapp.vao;

public class Pet {

    public Pet() {

    }

    public Pet(int id, String kind, String name) {
        this.id = id;
        this.kind = kind;
        this.name = name;
    }

    int id;

    String kind;

    String name;

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", kind='" + kind + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
