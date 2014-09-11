package br.edu.univas.si4.lab4.busProject2.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class MotoristaDAO {

	private Connection connection = null;
	
	public MotoristaDAO(){
		connection = ConnectionController.createConnection();
	}
	
	public void salvar(MotoristaTO to){
		PreparedStatement st = null;
		try {
			String sql = "insert into motorista(nome,celular,categoriaCNH)" +
			" values (?,?,?)";
			st = connection.prepareStatement(sql);
			
			st.setString(1, to.getNome());
			st.setString(2, to.getCelular());
			st.setString(3, to.getCategoriaCnh());
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		try{
			st.executeUpdate();
			JOptionPane.showMessageDialog(null, "Motorista salvo com Sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException exception) {
			exception.printStackTrace();
			JOptionPane.showMessageDialog(null, "Não foi Possivel o salvar o motorista!", "Erro!", 0);

		}
		
	}

	public ArrayList<MotoristaTO> getAll(){
		ArrayList<MotoristaTO> motoristas = new ArrayList<MotoristaTO>();
		
		try {
			String sql = "SELECT * FROM motorista";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet rs = statement.executeQuery();

			while(rs.next()) {
				
				
				
				MotoristaTO to = new MotoristaTO();
				
				to.setId(rs.getInt("id"));
				to.setNome(rs.getString("nome"));
				to.setCelular(rs.getString("celular"));
				to.setCategoriaCnh(rs.getString("categoriaCNH"));
				
				motoristas.add(to);
				
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
			JOptionPane.showMessageDialog(null, "Não foi Possivel pesquisar os motoristas!", "Erro!", 0);
		}
		
		return motoristas;
	}
	
	public void remover(MotoristaTO to){
		remover(to.getId());
	}
	
	public void remover(int id){
		String sql =  "delete from motorista where id = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1,  id);
			
			statement.executeUpdate();
		
			//close(connection, statement);
		} catch (SQLException exception) {
			JOptionPane.showMessageDialog(null, "Não foi Possivel remover o motorista!", "Erro!", 0);
		}
	}
	
	public void atualizar(MotoristaTO to){
		String sql = "update motorista set nome = ?, celular = ?,categoriaCNH = ?"
				+ " where id = ?";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			
			statement.setString(1,  to.getNome());
			statement.setString(2,  to.getCelular());
			statement.setString(3,  to.getCategoriaCnh());
			statement.setInt(4, to.getId());
		}catch(Exception exception){
			exception.printStackTrace();
		}
		try{
			statement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Motorista atualizado com sucesso!", "Erro!", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (SQLException exception) {
			JOptionPane.showMessageDialog(null, "Não foi Possivel atualizar o motorista!", "Erro!", 0);
		}
	}

}
