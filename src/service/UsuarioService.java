package service;

import java.util.ArrayList;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioService {
	private UsuarioDAO usuarioDao;
	
	public UsuarioService() {
		this.usuarioDao = new UsuarioDAO();
	}
	
	public void cadastrar(Usuario usuario) {
		this.usuarioDao.cadastrar(usuario);
	}
	
	public void alterar(Usuario usuario) {
		this.usuarioDao.alterar(usuario);
	}
	
	public void excluir(Usuario usuario) {
		this.usuarioDao.excluir(usuario);
	}
	
	public Usuario consultar(String email, String senha) {
		return this.usuarioDao.consultar(email, senha);
	}
	
	public ArrayList<Usuario> listar() {
		return this.usuarioDao.listar();
	}
}
