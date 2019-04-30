package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Usuario;

@Repository
public interface UsuarioPersistencia extends JpaRepository<Usuario, Long> {
	
	Usuario findByCpf(String cpf);
	
}
