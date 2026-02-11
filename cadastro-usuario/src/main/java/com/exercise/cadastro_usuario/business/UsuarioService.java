package com.exercise.cadastro_usuario.business;

import com.exercise.cadastro_usuario.infraestructure.entities.Usuario;
import com.exercise.cadastro_usuario.infraestructure.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;
    public UsuarioService (UsuarioRepository repository){
        this.repository= repository;
    } //injecao
    public void salvarUsuario(Usuario usuario){
        repository.saveAndFlush(usuario);
    }
    public Usuario buscarUsuarioEmail(String email){
        return repository.findByEmail(email).orElseThrow(
                ()-> new RuntimeException("Email não encontrado")
        );//
    }

    public void deletarPorEmail(String email){
        repository.deleteByEmail(email);
    }
    @Transactional
    public Usuario atualizarUsuarioPorId(Integer id,Usuario usuario){
        Usuario usuarioEntity=repository.findById(id).
                orElseThrow(()->new RuntimeException("Usuário nao encontrado"));
        if (usuario.getNome() != null) {
            usuarioEntity.setNome(usuario.getNome());
        }
        if (usuario.getEmail() != null) {
            usuarioEntity.setEmail(usuario.getEmail());
        }
        return usuarioEntity;


    }

}
