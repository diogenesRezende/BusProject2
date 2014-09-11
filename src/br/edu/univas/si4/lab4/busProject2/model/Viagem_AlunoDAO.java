package br.edu.univas.si4.lab4.busProject2.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Viagem_AlunoDAO {

private Connection connection = null;
	
	public Viagem_AlunoDAO(){
		connection = ConnectionController.createConnection();
	}
	
	public void salvar(Viagem_AlunoTO to){
		PreparedStatement st = null;
		try {
			String sql = "insert into aluno_viagem(id_aluno,id_viagem)" +
			" values (?,?)";
			st = connection.prepareStatement(sql);
			
			st.setInt(1, to.getId_aluno());
			st.setInt(2, to.getId_viagem());
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		try{
			st.executeUpdate();
			JOptionPane.showMessageDialog(null, "Salvo!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException exception) {
			exception.printStackTrace();
			JOptionPane.showMessageDialog(null, "Não foi Possivel o salvar o viagem_aluno!", "Erro!", 0);
		}
		
	}

	public ArrayList<Viagem_AlunoTO> getAll(){
		ArrayList<Viagem_AlunoTO> alunos = new ArrayList<Viagem_AlunoTO>();
		
		try {
			String sql = "SELECT * FROM aluno_viagem";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet rs = statement.executeQuery();

			while(rs.next()) {
				Viagem_AlunoTO to = new Viagem_AlunoTO();
				
				to.setId_aluno(rs.getInt("id_aluno"));
				to.setId_viagem(rs.getInt("id_viagem"));
				
				alunos.add(to);
				
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
			JOptionPane.showMessageDialog(null, "Não foi Possivel o pesquisar o viagem_aluno!", "Erro!", 0);
		}
		
		return alunos;
	}
	public int getIndexNow(){
		
		
		int aux = 0;
		try {
			String sql = "select v.id from viagem as v where v.data = current_date";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while(rs.next()){
				aux = rs.getInt("id");
			}
			
			
			
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi Possivel o pesquisar o indexador de viagem!", "Erro!", 0);
			e.printStackTrace();
		}
		return aux;
		
	}

}
