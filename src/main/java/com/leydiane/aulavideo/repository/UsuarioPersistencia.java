package com.leydiane.aulavideo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leydiane.aulavideo.model.Usuario;

@Repository
public interface UsuarioPersistencia extends JpaRepository<Usuario, Long> {
	
	Usuario findByCpf(String cpf);
	
}
