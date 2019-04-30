package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Link;
import model.Usuario;
import repository.LinkPersistencia;

@Service
public class LinkServiceImpl implements LinkService {

	@Autowired
	LinkPersistencia linkRepository;

	@Override
	public void cadastrarLink(Link link) throws Exception {
		Link linkBase = this.linkRepository.findByTituloVideo(link.getTituloVideo());
		if(linkBase!=null) {
			throw new Exception("Link já cadastrado!");
		}
		this.linkRepository.save(link);
		
	}

	@Override
	public Link atualizarLink(Link link) {
		
		Link linkBase = this.linkRepository.findById(link.getId()).get();
		
		linkBase.setTituloVideo(link.getTituloVideo());
		linkBase.setUrl(link.getUrl());
		
		return this.linkRepository.save(linkBase);
	}

	@Override
	public Link buscarLinkPorTitulo(String titulo) throws Exception {
	
		Link linkBase = this.linkRepository.findByTituloVideo(titulo);
		
		if(linkBase==null) {
			throw new Exception("Link não encontrado !");
		}
		
		return linkBase;
	}

	@Override
	public void deletarLink(Link link) throws Exception {
		Link linkBase = this.linkRepository.findById(link.getId()).get();
		
		if(linkBase==null) {
			throw new Exception("Link Inexistente");
		}
		
		this.linkRepository.delete(linkBase);
		
	}

	@Override
	public List<Link> findAll() throws Exception {
		// TODO Auto-generated method stub
		return this.linkRepository.findAll();
	}

	@Override
	public Link findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return this.linkRepository.findById(id).get();
	}
	
	
	
	
}
