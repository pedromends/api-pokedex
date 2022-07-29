package pedro.apipokedex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pedro.apipokedex.entity.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
}
