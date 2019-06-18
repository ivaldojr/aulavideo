package com.leydiane.aulavideo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leydiane.aulavideo.model.HistoricoLogin;
import com.leydiane.aulavideo.model.Usuario;
import com.leydiane.aulavideo.repository.HistoricoLoginPersistencia;

@Service
public class HistoricoLoginImpl implements HistoricoLoginService{

	@Autowired
	HistoricoLoginPersistencia histRepository;
	
	@Override
	public void cadastrarHistoricoLogin(HistoricoLogin histLogin) throws Exception {
		this.histRepository.save(histLogin);
		
	}

	@Override
	public List<HistoricoLogin> buscarHistoricoLoginPorUsuario(Usuario user) throws Exception {
		return this.histRepository.findByUser(user);
	}

	@Override
	public List<HistoricoLogin> findAll() {
		// TODO Auto-generated method stub
		return this.histRepository.findAll();
	}

	@Override
	public HistoricoLogin findById(Long id) {
		// TODO Auto-generated method stub
		return this.histRepository.findById(id).get();
	}

	
	
}
