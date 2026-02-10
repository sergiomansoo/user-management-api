package com.exercise.cadastro_usuario.infraestructure.repository;

import com.exercise.cadastro_usuario.infraestructure.entities.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    //pra extender o JPA é preciso colocar o nome da tabela que se refere e o tipo do campo ID
    //JPA ja tem metodos prontos
    Optional<Usuario> findByEmail(String email);
    @Transactional//caso ocorra algum erro ele nao pode deletar
    void deleteByEmail(String email);




}
