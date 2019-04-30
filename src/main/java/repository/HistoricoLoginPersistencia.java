package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.HistoricoLogin;
import model.Usuario;

@Repository
public interface HistoricoLoginPersistencia extends JpaRepository<HistoricoLogin, Long>{

	List<HistoricoLogin> findByUser(Usuario user);
	
}
