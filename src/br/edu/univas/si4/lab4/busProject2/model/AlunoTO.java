package br.edu.univas.si4.lab4.busProject2.model;

public class AlunoTO {

	
	private int id = 0;
	private String nome = null;
	private String celular = null;
	private String endereco = null;
	private int num_end = 0;
	private int id_instituicao = 0;
	
	public int getId_instituicao() {
		return id_instituicao;
	}
	public void setId_instituicao(int id_instituicao) {
		this.id_instituicao = id_instituicao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getNum_end() {
		return num_end;
	}
	public void setNum_end(int num_end) {
		this.num_end = num_end;
	}
	@Override
	public String toString() {
		return nome;
	}
	
}
