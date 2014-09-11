package br.edu.univas.si4.lab4.busProject2.view.listener;

import br.edu.univas.si4.lab4.busProject2.model.AlunoTO;

public interface FrameListarAlunoListener {

	public void remover(AlunoTO aluno);
	
	public void mostrarEditarAluno(AlunoTO aluno);
	
	public void voltarListar();
	
}
