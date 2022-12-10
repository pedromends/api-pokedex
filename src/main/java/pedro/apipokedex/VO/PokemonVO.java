package pedro.apipokedex.VO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile;
import pedro.apipokedex.entity.Pokemon;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonVO {

    private String nome;
    private String tipo;

    private String imagem;

    public PokemonVO(Pokemon pokemon){
        this.nome = pokemon.getNome();
        this.tipo = pokemon.getTipo();
		this.imagem = pokemon.getImagem();
    }
}
