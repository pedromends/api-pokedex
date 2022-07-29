package pedro.apipokedex.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_pokemon", schema = "public")
@SequenceGenerator(name = "tb_pokemon", sequenceName = "seq_tb_pokemon", allocationSize = 1)
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_tb_pokemon")
    @Column
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "img")
    private String imagem;

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
