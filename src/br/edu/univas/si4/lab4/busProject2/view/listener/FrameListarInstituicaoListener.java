package br.edu.univas.si4.lab4.busProject2.view.listener;

import br.edu.univas.si4.lab4.busProject2.model.InstituicaoTO;


public interface FrameListarInstituicaoListener {

	public void remover(InstituicaoTO instituicao);
	
	public void mostrarEditarInstituicao(InstituicaoTO instituicao);
	
	public void voltarListar();
}
