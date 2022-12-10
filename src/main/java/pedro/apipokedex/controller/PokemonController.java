package pedro.apipokedex.controller;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pedro.apipokedex.VO.PokemonVO;
import pedro.apipokedex.service.PokemonService;

import java.io.IOException;

@CrossOrigin("*")
@RestController
@RequestMapping("/pokedex")
public class PokemonController {

    @Autowired
    PokemonService pokemonService;

    @PostMapping("/criar")
    public ResponseEntity<Object> criarPokemon(@RequestParam("nome")String nome, @RequestParam("tipo")String tipo, @RequestParam("imagem")MultipartFile imagem) throws IOException {
		pokemonService.criarPokemon(nome, tipo, imagem);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<Object> listarPokemon()  {
        return new ResponseEntity<>(pokemonService.listarPokemon(), HttpStatus.OK);
    }

    /*@GetMapping("/atualizar")
    public ResponseEntity<Object> atualizarPokemon()  {
        return new ResponseEntity<>(pokemonService.atualizarPokemon());
    }

    @GetMapping("/deletar")
    public ResponseEntity<Object> deletarPokemon()  {
        return new ResponseEntity<>(pokemonService.deletarPokemon());
    }*/

}
