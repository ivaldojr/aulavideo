package com.leydiane.aulavideo.service;

import java.util.List;

import com.leydiane.aulavideo.model.HistoricoLogin;
import com.leydiane.aulavideo.model.Usuario;

public interface HistoricoLoginService {

	public void cadastrarHistoricoLogin(HistoricoLogin histLogin) throws Exception;
	
	public List<HistoricoLogin> buscarHistoricoLoginPorUsuario(Usuario user) throws Exception;
	
	public List<HistoricoLogin> findAll();
	
	public HistoricoLogin findById(Long id);
	
}
