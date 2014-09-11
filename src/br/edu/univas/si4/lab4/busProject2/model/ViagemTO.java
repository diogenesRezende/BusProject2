package br.edu.univas.si4.lab4.busProject2.model;

import java.sql.Date;





public class ViagemTO {

	private int id = 0;
	private int id_motorista = 0;
	private Date data = null;
	private String origem;
	private String destino;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_motorista() {
		return id_motorista;
	}
	public void setId_motorista(int id_motorista) {
		this.id_motorista = id_motorista;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}	
}
