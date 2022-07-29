package pedro.apipokedex.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pedro.apipokedex.VO.PokemonVO;
import pedro.apipokedex.service.PokemonService;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    @Autowired
    PokemonService pokemonService;

    @PostMapping("/criar")
    public PokemonVO criarPokemon(@RequestBody PokemonVO pokemonVO)  {
        return pokemonService.criarPokemon(pokemonVO);
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
