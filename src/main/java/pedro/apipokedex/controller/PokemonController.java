package pedro.apipokedex.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pedro.apipokedex.service.PokemonService;

import java.io.IOException;

@CrossOrigin("*")
@RestController
@RequestMapping("/pokedex")
public class PokemonController {

    @Autowired
    PokemonService pokemonService;

    @PostMapping("/criar")
    public ResponseEntity<Object> criarPokemon(@RequestParam("name")String nome,
											   @RequestParam("type")String tipo,
											   @RequestParam("img")MultipartFile imagem) throws IOException {
		pokemonService.criarPokemon(nome, tipo, imagem);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<Object> listarPokemon()  {
        return new ResponseEntity<>(pokemonService.listarPokemon(), HttpStatus.OK);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Object> atualizarPokemon(@RequestParam("id")Long id,
												   @RequestParam("nome")String nome,
												   @RequestParam("tipo")String tipo,
												   @RequestParam("imagem")MultipartFile imagem) throws IOException {
        pokemonService.atualizarPokemon(id, nome, tipo, imagem);
		return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarPokemon(@PathVariable Long id)  {
        return new ResponseEntity<>(pokemonService.deletarPokemon(id));
    }

}
