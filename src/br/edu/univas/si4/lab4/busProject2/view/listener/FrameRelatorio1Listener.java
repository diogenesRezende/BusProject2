package br.edu.univas.si4.lab4.busProject2.view.listener;

import java.util.ArrayList;

import br.edu.univas.si4.lab4.busProject2.model.AlunoTO;
import br.edu.univas.si4.lab4.busProject2.model.Relatorio1TO;

public interface FrameRelatorio1Listener {
	
	public void voltarRelatorio1();
	public ArrayList<AlunoTO> getListaAlunosRelatorio();
	public Relatorio1TO getDadosRelatorio();
}
