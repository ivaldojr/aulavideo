package service;

import java.util.List;

import model.HistoricoLogin;
import model.Usuario;

public interface HistoricoLoginService {

	public void cadastrarHistoricoLogin(HistoricoLogin histLogin) throws Exception;
	
	public List<HistoricoLogin> buscarHistoricoLoginPorUsuario(Usuario user) throws Exception;
	
	public List<HistoricoLogin> findAll();
	
	public HistoricoLogin findById(Long id);
	
}
