package pedro.apipokedex.service;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pedro.apipokedex.VO.PokemonVO;
import pedro.apipokedex.entity.Pokemon;
import pedro.apipokedex.repository.PokemonRepository;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    public void criarPokemon(String nome, String tipo, MultipartFile arquivo) throws IOException {

        Pokemon pokemon = new Pokemon();
		byte[] arr = arquivo.getBytes();
        String img = Base64.encodeBase64String(arr);

        pokemon.setNome(nome);
        pokemon.setTipo(tipo);
        pokemon.setImagem(img);
        pokemonRepository.save(pokemon);
    }

    public List<PokemonVO> listarPokemon(){

        List<PokemonVO> listaVO = new ArrayList<>();
        List<Pokemon> lista = pokemonRepository.findAll();

        for(Pokemon poke : lista)
            listaVO.add(new PokemonVO(poke));

        return listaVO;
    }

    public void atualizarPokemon(Long id, String nome, String tipo, MultipartFile arquivo) throws IOException {

		Pokemon pokemon = pokemonRepository.getById(id);
		byte[] arr = arquivo.getBytes();
		String img = Base64.encodeBase64String(arr);

		pokemon.setNome(nome);
		pokemon.setTipo(tipo);
		pokemon.setImagem(img);
		pokemonRepository.save(pokemon);
    }

    public PokemonVO deletarPokemon(){
        return new PokemonVO();
    }
}
