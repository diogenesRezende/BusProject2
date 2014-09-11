package br.edu.univas.si4.lab4.busProject2.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class InstituicaoDAO {

	private Connection connection = null;
		
		public InstituicaoDAO(){
			connection = ConnectionController.createConnection();
		}
		
		public void salvar(InstituicaoTO to){
			
				String sql = "insert into instituicao(nome,telefone,endereco,num_end,bairro,email,cidade)" +
				" values (?,?,?,?,?,?,?)";
				PreparedStatement st = null;
			try{
				st = connection.prepareStatement(sql);
				
				
				st.setString(1, to.getNome());
				st.setString(2, to.getTelefone());
				st.setString(3, to.getEndereco());
				st.setInt(4, to.getNum_end());
				st.setString(5, to.getBairro());
				st.setString(6, to.getEmail());
				st.setString(7, to.getCidade());
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
				try {
					st.executeUpdate();
					JOptionPane.showMessageDialog(null, "Instituição salva com Sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Não foi Possivel o salvar a Instituição!", "Erro!", 0);
				}
			
			
		}

		public ArrayList<InstituicaoTO> getAll(){
			ArrayList<InstituicaoTO> instituicoes = new ArrayList<InstituicaoTO>();
			
			try {
				String sql = "SELECT * FROM instituicao";
				PreparedStatement statement = connection.prepareStatement(sql);
				
				ResultSet rs = statement.executeQuery();

				while(rs.next()) {
					InstituicaoTO to = new InstituicaoTO();
					
					to.setId(rs.getInt("id"));
					to.setNome(rs.getString("nome"));
					to.setEndereco(rs.getString("endereco"));
					to.setNum_end(rs.getInt("num_end"));
					to.setBairro(rs.getString("bairro"));
					to.setCidade(rs.getString("cidade"));
					to.setTelefone(rs.getString("telefone"));
					to.setEmail(rs.getString("email"));
					
					instituicoes.add(to);
					
				}
			} catch (SQLException exception) {
				exception.printStackTrace();
				JOptionPane.showMessageDialog(null, "Não foi Possivel pesquisar a Instituição!", "Erro!", 0);
			}
			
			return instituicoes;
		}
		
		public void remover(InstituicaoTO to){
			remover(to.getId());
		}
		
		public void remover(int cod){
			String sql =  "delete from instituicao where id = ?";
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setInt(1,  cod);
				
				statement.executeUpdate();
			} catch (SQLException exception) {
				JOptionPane.showMessageDialog(null, "Não foi possível deletar a Instituição!", "Erro!", 0);
			}
		}
		
		public void atualizar(InstituicaoTO to){
			String sql = "update instituicao set nome = ?, endereco = ?,num_end = ?,"
					+ "bairro = ?,cidade = ? , telefone = ?, email = ? where id = ?";
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setString(1,  to.getNome());
				statement.setString(2,  to.getEndereco());
				statement.setInt(3, to.getNum_end());
				statement.setString(4, to.getBairro());
				statement.setString(5, to.getCidade());
				statement.setString(6, to.getTelefone());
				statement.setString(7, to.getEmail());
				statement.setInt(8, to.getId());
				
				statement.executeUpdate();
			
				
			} catch (SQLException exception) {
				JOptionPane.showMessageDialog(null, "Não foi possível atualizar a Instituição!", "Erro!", 0);
			}
		}
			
}
