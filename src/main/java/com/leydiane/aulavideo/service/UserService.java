package com.leydiane.aulavideo.service;

import java.util.List;

import com.leydiane.aulavideo.model.Usuario;

public interface UserService {

	public void cadastrarUsuario(Usuario user) throws Exception;
	
	public Usuario atualizarUsuario(Usuario user);
	
	public Usuario buscarUsuarioPorCPF(String cpf) throws Exception;
	
	public void deletarUsuario(Usuario user) throws Exception;
	
	public List<Usuario> findAll() throws Exception;
	
	public Usuario findById(Long id) throws Exception;
}
