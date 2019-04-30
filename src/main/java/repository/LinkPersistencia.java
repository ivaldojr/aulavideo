package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Link;

@Repository
public interface LinkPersistencia extends JpaRepository<Link, Long>{
	
	Link findByTituloVideo(String titulo);
	
}
