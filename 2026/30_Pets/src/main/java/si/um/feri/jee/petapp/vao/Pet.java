package si.um.feri.jee.petapp.vao;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@Entity
public class Pet {

    public Pet(int id, String kind, String name) {
        this.id = id;
        this.petKind = kind;
        this.petName = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String petKind;

    String petName;

}
