package pedro.apipokedex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pedro.apipokedex.VO.PokemonVO;
import pedro.apipokedex.entity.Pokemon;
import pedro.apipokedex.repository.PokemonRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    public PokemonVO criarPokemon(PokemonVO pokemonVO){

        Pokemon pokemon = new Pokemon();

        pokemon.setNome(pokemonVO.getNome());
        pokemon.setId(pokemonVO.getId());
        pokemon.setTipo(pokemonVO.getTipo());
        pokemon.setImagem(pokemonVO.getImagem());

        pokemonRepository.save(pokemon);
        return pokemonVO;
    }

    public List<PokemonVO> listarPokemon(){

        List<PokemonVO> listaVO = new ArrayList<>();
        List<Pokemon> lista = pokemonRepository.findAll();

        for(Pokemon poke : lista){
            listaVO.add(new PokemonVO(poke));
        }

        return listaVO;
    }

    public PokemonVO atualizarPokemon(){
        return new PokemonVO();
    }

    public PokemonVO deletarPokemon(){
        return new PokemonVO();
    }
}
