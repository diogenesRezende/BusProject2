package br.edu.univas.si4.lab4.busProject2.view.listener;

import br.edu.univas.si4.lab4.busProject2.model.MotoristaTO;


public interface FrameListarMotoristaListener {
	
	public void remover(MotoristaTO motorista);
	
	public void mostrarEditarMotorista(MotoristaTO motorista);
	
	public void voltarListar();
}
