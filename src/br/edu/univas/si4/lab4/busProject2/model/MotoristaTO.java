package br.edu.univas.si4.lab4.busProject2.model;

public class MotoristaTO {

		private int id = 0;
		private String nome = null;
		private String celular = null;
		private String categoriaCnh = null;
		
		
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
		public String getCategoriaCnh() {
			return categoriaCnh;
		}
		public void setCategoriaCnh(String categoriaCnh) {
			this.categoriaCnh = categoriaCnh;
		}
		@Override
		public String toString() {
			return  nome ;
		}
		
		
}
