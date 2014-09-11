package br.edu.univas.si4.lab4.busProject2.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class ViagemDAO {


private Connection connection = null;
	
	public ViagemDAO(){
		connection = ConnectionController.createConnection();
	}
	
	public void salvar(ViagemTO to){
		PreparedStatement st = null;
		try {
			String sql = "insert into viagem(origem,destino,id_motorista)" +
			" values (?,?,?)";
			st = connection.prepareStatement(sql);
			
			st.setString(1, to.getOrigem());
			st.setString(2, to.getDestino());			
			st.setInt(3, to.getId_motorista());
		}catch (Exception exception){
			exception.printStackTrace();
		}
		try{
		
			st.executeUpdate();
			JOptionPane.showMessageDialog(null, "Viagem salva com sucesso!", "Sucesso",JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException exception) {
			exception.printStackTrace();
			JOptionPane.showMessageDialog(null, "Não foi Possivel o salvar a viagem!", "Erro!", 0);
		}
		
	}

	public ArrayList<ViagemTO> getAll(){
		ArrayList<ViagemTO> viagens = new ArrayList<ViagemTO>();
		
		try {
			String sql = "SELECT * FROM viagem";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet rs = statement.executeQuery();

			while(rs.next()) {
				ViagemTO to = new ViagemTO();
				
				to.setId(rs.getInt("id"));
				to.setId_motorista(rs.getInt("id_motorista"));
				to.setData(rs.getDate("data"));
				to.setOrigem(rs.getString("origem"));
				to.setDestino(rs.getString("destino"));				
				viagens.add(to);
				
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
			JOptionPane.showMessageDialog(null, "Não foi Possivel o pesquisar as viagens!", "Erro!", 0);
		}
		
		return viagens;
	}

}
