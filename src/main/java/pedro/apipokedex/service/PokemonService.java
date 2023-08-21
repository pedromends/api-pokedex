package pedro.apipokedex.service;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pedro.apipokedex.VO.PokemonVO;
import pedro.apipokedex.entity.Pokemon;
import pedro.apipokedex.repository.PokemonRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    public void createPokemon(String name, String type, MultipartFile arch) throws IOException {

        Pokemon pokemon = new Pokemon();
		byte[] arr = arch.getBytes();
        String img = Base64.encodeBase64String(arr);

        pokemon.setName(name);
        pokemon.setType(type);
        pokemon.setImg(img);
        pokemonRepository.save(pokemon);
    }

    public List<PokemonVO> listPokemon(){

        List<PokemonVO> listVO = new ArrayList<>();
        List<Pokemon> list = pokemonRepository.findAll();

        for(Pokemon poke : list)
            listVO.add(new PokemonVO(poke));

        return listVO;
    }

    public void updatePokemon(Long id, String nome, String tipo, String oldimg, Optional<MultipartFile> img) throws IOException {

		Pokemon pokemon = pokemonRepository.getById(id);

		pokemon.setName(nome);
		pokemon.setType(tipo);

        if(img.isPresent()){
            byte[] arr = img.get().getBytes();
            String bytes = Base64.encodeBase64String(arr);
            pokemon.setImg(bytes);
        }else
            pokemon.setImg(oldimg);

		pokemonRepository.save(pokemon);
    }

    public HttpStatus deletePokemon(Long id){
		pokemonRepository.deleteById(id);
		return HttpStatus.OK;
    }
}
