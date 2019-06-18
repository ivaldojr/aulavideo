package com.leydiane.aulavideo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leydiane.aulavideo.model.Link;

@Repository
public interface LinkPersistencia extends JpaRepository<Link, Long>{
	
	Link findByTituloVideo(String titulo);
	
}
