package com.losung.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.losung.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
