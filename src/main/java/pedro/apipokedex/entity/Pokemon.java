package pedro.apipokedex.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pokemon", schema = "pokedex")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "img")
    private String img;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Pokemon pokemon = (Pokemon) o;
        return id != null && Objects.equals(id, pokemon.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
