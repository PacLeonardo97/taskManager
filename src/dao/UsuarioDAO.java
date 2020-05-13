package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Usuario;

public class UsuarioDAO {
	private Connection conexao;
	
	public UsuarioDAO() {
		this.conexao = ConnectionFactory.conectar();
	}

	public void cadastrar(Usuario usuario) {
			
		String inserir = "INSERT INTO usuario "
				+ " (email, senha, nome) "
				+ " VALUES (?, ?, ?) ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setString(1, usuario.getEmail());
			pst.setString(2, usuario.getSenha());
			pst.setString(3, usuario.getNome());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela usuario.");
			ex.printStackTrace();
			
		}
	}
	
	public void alterar(Usuario usuario) {
		
		String alterar = "UPDATE usuario "
				+ "SET senha = ?, nome = ? "
				+ " WHERE email = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(alterar) ) {
			
			pst.setString(1, usuario.getSenha());
			pst.setString(2, usuario.getNome());
			pst.setString(3, usuario.getEmail());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela usuario.");
			ex.printStackTrace();
			
		}
	}
	
	public void excluir(Usuario usuario) {
		
		String excluir = "DELETE FROM usuario "
				+ " WHERE email = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(excluir) ) {
			
			pst.setString(1, usuario.getEmail());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela usuario.");
			ex.printStackTrace();
		}
	}
	
	public Usuario consultar(String email, String senha) {
		
		String consultar = "SELECT * FROM usuario "
				+ " WHERE email = ? && senha = ?";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(consultar) ) {
			
			pst.setString(1, email);
			pst.setString(2, senha);
			ResultSet resultado = pst.executeQuery();
			
			Usuario u = new Usuario();
			if (resultado.next()) {
				u.setEmail(resultado.getString("email"));
				u.setSenha(resultado.getString("senha"));
				u.setNome(resultado.getString("nome"));
			}
			return u;
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela usuario.");
			ex.printStackTrace();
			
			return null;
		}
	}

	
	public ArrayList<Usuario> listar() {
		String consultar = "SELECT * FROM usuario";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(consultar) ) {
			
			ResultSet resultado = pst.executeQuery();
			
			ArrayList<Usuario> lista = new ArrayList<>();
			while (resultado.next()) {
				Usuario u = new Usuario();
				u.setEmail(resultado.getString("email"));
				u.setSenha(resultado.getString("senha"));
				u.setNome(resultado.getString("nome"));
				lista.add(u);
			}
			return lista;
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela usuario.");
			ex.printStackTrace();
			
			return null;
		}
	}
}
