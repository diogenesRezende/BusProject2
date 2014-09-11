package br.edu.univas.si4.lab4.busProject2.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class RelatorioDAO {

	private Connection connection =null;
	
	public RelatorioDAO() {
		connection = ConnectionController.createConnection();
	}
	
	public ArrayList<AlunoTO> getNomeAlunos(){
		ArrayList<AlunoTO> alunos = new ArrayList<AlunoTO>();
		try{
			String sql = "select a.nome from viagem as v join aluno_viagem as av join aluno as a on av.id_aluno = a.id on av.id_viagem = v.id where v.data = current_date";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()){
				AlunoTO aluno = new AlunoTO();
				aluno.setNome(rs.getString("nome"));
				
				alunos.add(aluno);
			}
			
		} catch(SQLException exception){
			exception.printStackTrace();
			JOptionPane.showMessageDialog(null, "Não foi Possivel o pesquisar o nome dos alunos!", "Erro!", 0);
		}
		return alunos;

	}
	
	public Relatorio1TO getDadosRelatorio1(){
		Relatorio1TO to = null;
		try{
			String sql = "select v.origem,v.destino,m.nome,v.data,count(a.id) qtde from motorista as m join viagem as v join aluno_viagem as av join aluno as a on a.id = av.id_aluno on av.id_viagem = v.id on m.id = v.id_motorista where v.data = current_date group by v.origem,v.destino,m.nome,v.data order by qtde desc limit 1";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()){
				to = new Relatorio1TO();
				to.setNome(rs.getString("nome"));
				to.setOrigem(rs.getString("origem"));
				to.setDestino(rs.getString("destino"));
				to.setData(rs.getDate("data"));
				to.setQtde(rs.getInt("qtde"));
			}
				
			
		} catch(SQLException exception){
			exception.printStackTrace();
			JOptionPane.showMessageDialog(null, "Não foi Possivel o pesquisar os dados da viagem", "Erro!", 0);
		}
		
		return to;
	}
	
	public ArrayList<Relatorio2TO> getDadosRelatorio2(){
		ArrayList<Relatorio2TO> instituicoes = new ArrayList<Relatorio2TO>();
		
		try {
			String sql = "select i.nome,count(a.id)qtde from instituicao as i join aluno as a join aluno_viagem as av join viagem as v on av.id_viagem = v.id on av.id_aluno = a.id on a.id_instituicao = i.id where v.data = current_date group by i.nome order by qtde desc";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet rs = statement.executeQuery();
			while(rs.next()){
				Relatorio2TO to = new Relatorio2TO();
				
				to.setNome(rs.getString("nome"));
				to.setQtde(rs.getInt("qtde"));
				
				instituicoes.add(to);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi Possivel o pesquisar os dados das Instituições!", "Erro!", 0);
			e.printStackTrace();
		}
		return instituicoes;
		
	}
	
	
}
