package br.edu.univas.si4.lab4.busProject2.view.listener;

import java.util.ArrayList;

import br.edu.univas.si4.lab4.busProject2.model.AlunoTO;
import br.edu.univas.si4.lab4.busProject2.model.InstituicaoTO;


public interface FrameCadastrarAlunoListener {

	public void salvar(AlunoTO to);
	
	public ArrayList<InstituicaoTO> getListInstituicao();
	
	public void voltarAluno();
	
}
