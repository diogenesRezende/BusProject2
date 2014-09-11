package br.edu.univas.si4.lab4.busProject2.model;

public class InstituicaoTO {

	private int id = 0;
	private String nome = null;
	private String email = null;
	private String telefone = null;
	private String cidade = null;
	private String endereco = null;
	private String bairro = null;
	private int num_end = 0;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
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
