package br.edu.univas.si4.lab4.busProject2.view.listener;

import br.edu.univas.si4.lab4.busProject2.model.Viagem_AlunoTO;

public interface FrameBlSalvarPassageiroListener {
	
	public void tratarBtSalvar(Viagem_AlunoTO to);
	public void tratarBtVoltar();
	public int getIndexViagem();
}
