package service;

import java.util.List;

import model.Link;

public interface LinkService {

	public void cadastrarLink(Link link) throws Exception;
	
	public Link atualizarLink(Link link);
	
	public Link buscarLinkPorTitulo(String titulo) throws Exception;
	
	public void deletarLink(Link link) throws Exception;
	
	public List<Link> findAll() throws Exception;
	
	public Link findById(Long id) throws Exception;
	
}
