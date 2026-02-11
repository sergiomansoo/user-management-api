package com.exercise.cadastro_usuario.controller;

import com.exercise.cadastro_usuario.business.UsuarioService;
import com.exercise.cadastro_usuario.infraestructure.entities.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @PostMapping
    public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario){
        usuarioService.salvarUsuario(usuario);
        return ResponseEntity.ok().build(); //qualquer resposta http vai ser aceita
    }
    @GetMapping
    public ResponseEntity<Usuario> buscarUsuario(@RequestParam String email){
        usuarioService.buscarUsuarioEmail(email);
        return ResponseEntity.ok(usuarioService.buscarUsuarioEmail(email)); // coloca o objeto retornado junto
    }
    @DeleteMapping
    ResponseEntity<Void> deletarUsuario (@RequestParam String email){ // email é um parametro de user
        usuarioService.deletarPorEmail(email);
        return ResponseEntity.ok().build(); //retorna o status 200, mas o corpo sem sem nada
    }
    @PutMapping
    public ResponseEntity <Void> atualizarUsuario (@RequestParam Integer id,
    @RequestBody Usuario usuario){ //como nao há um objeto nem nada a ser retornado, ele tem que ser void
        usuarioService.atualizarUsuarioPorId(id,usuario);
        return ResponseEntity.ok().build();
    }
}
