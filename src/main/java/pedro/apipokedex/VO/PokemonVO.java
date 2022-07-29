package pedro.apipokedex.VO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import pedro.apipokedex.entity.Pokemon;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonVO {

    private Long id;
    private String nome;
    private String tipo;
    private String imagem;

    public PokemonVO(Pokemon pokemon){
        this.id = pokemon.getId();
        this.nome = pokemon.getNome();
        this.tipo = pokemon.getTipo();
        this.imagem = pokemon.getImagem();
    }
}
