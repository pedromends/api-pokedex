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
    private String name;
    private String type;
    private String img;

    public PokemonVO(Pokemon pokemon){
		this.id  = pokemon.getId();
        this.name = pokemon.getName();
        this.type = pokemon.getType();
		this.img = pokemon.getImg();
    }
}
