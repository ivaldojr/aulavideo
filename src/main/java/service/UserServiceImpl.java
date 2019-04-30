package service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Usuario;
import repository.UsuarioPersistencia;

@Service
public class UserServiceImpl  implements UserService {
	
	@Autowired
	UsuarioPersistencia user;
	
	@Override
	public void cadastrarUsuario(Usuario user) throws Exception {
		
		Usuario usuarioBase = this.user.findByCpf(user.getCpf());
		if(usuarioBase!=null) {
			throw new Exception("Usuario já cadastrado!");
		}
		this.user.save(user);
		
	}

	@Override
	public Usuario atualizarUsuario(Usuario user) {
		
		Usuario usuarioBase = this.user.findById(user.getId()).get();
		
		usuarioBase.setCpf(user.getCpf());
		usuarioBase.setEmail(user.getEmail());
		usuarioBase.setNomeUsuario(user.getNomeUsuario());
		usuarioBase.setSenha(user.getSenha());
		usuarioBase.setSexo(user.getSexo());
		
		return this.user.save(usuarioBase);
	}

	@Override
	public Usuario buscarUsuarioPorCPF(String cpf) throws Exception {
		
		Usuario usuarioBase = this.user.findByCpf(cpf);
		
		if(usuarioBase==null) {
			throw new Exception("Usuário inexistente");
		}
		
		return usuarioBase;
	}

	@Override
	public void deletarUsuario(Usuario user) throws Exception {
		Usuario usuarioBase = this.user.findById(user.getId()).get();
		
		if(usuarioBase==null) {
			throw new Exception("Usuário inexistente");
		}
		
		this.user.delete(usuarioBase);
		
	}

	@Override
	public List<Usuario> findAll() throws Exception {
		return this.user.findAll();
	}

	@Override
	public Usuario findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return this.user.findById(id).get();
	}
	
	
	
}
