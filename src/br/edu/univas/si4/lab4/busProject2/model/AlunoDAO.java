package br.edu.univas.si4.lab4.busProject2.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class AlunoDAO{

private Connection connection = null;
	
	public AlunoDAO(){
		connection = ConnectionController.createConnection();
	}
	
	public void salvar(AlunoTO to){
		
			String sql = "insert into aluno(nome,celular,endereco,num_end,id_instituicao)" +
			" values (?,?,?,?,?)";
			Connection connection = ConnectionController.createConnection();
			PreparedStatement st = null;
		try {
			st = connection.prepareStatement(sql);
		
			st.setString(1, to.getNome());
			st.setString(2, to.getCelular());
			st.setString(3, to.getEndereco());
			st.setInt(4, to.getNum_end());
			st.setInt(5, to.getId_instituicao());
			} catch (SQLException exception) {
				exception.printStackTrace();
				
			}
		try{
			st.executeUpdate();
			JOptionPane.showMessageDialog(null, "Aluno salvo com Sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Não foi Possivel o salvar o aluno!", "Erro!", 0);
		}
		
	}

	public ArrayList<AlunoTO> getAll(){
		ArrayList<AlunoTO> alunos = new ArrayList<AlunoTO>();
		
		try {
			String sql = "SELECT * FROM aluno";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet rs = statement.executeQuery();

			while(rs.next()) {
				AlunoTO to = new AlunoTO();
				
				to.setId(rs.getInt("id"));
				to.setNome(rs.getString("nome"));
				to.setCelular(rs.getString("celular"));
				to.setEndereco(rs.getString("endereco"));
				to.setNum_end(rs.getInt("num_end"));
				to.setId_instituicao(rs.getInt("id_instituicao"));
				
				alunos.add(to);
				
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
			JOptionPane.showMessageDialog(null, "Não foi Possivel pesquisar os alunos!", "Erro!", 0);
		}
		
		return alunos;
	}
	
	public void remover(AlunoTO to){
		remover(to.getId());
	}
	
	public void remover(int id){
		String sql =  "delete from aluno where id = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1,  id);
			
			statement.executeUpdate();
		
		} catch (SQLException exception) {
			JOptionPane.showMessageDialog(null, "Não foi Possivel remover o aluno!", "Erro!", 0);
		}
	}
	
	public void atualizar(AlunoTO to){
		String sql = "update aluno set nome = ?, celular = ?, endereco = ?,num_end = ?,"
				+ "id_instituicao = ? where id = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1,  to.getNome());
			statement.setString(2,  to.getCelular());
			statement.setString(3,  to.getEndereco());
			statement.setInt(4, to.getNum_end());
			statement.setInt(5, to.getId_instituicao());
			statement.setInt(6, to.getId());
			
			statement.executeUpdate();
		
			
		} catch (SQLException exception) {
			JOptionPane.showMessageDialog(null, "Não foi possível atualizar o aluno!", "Erro!", 0);
		}
	}
				
	}

