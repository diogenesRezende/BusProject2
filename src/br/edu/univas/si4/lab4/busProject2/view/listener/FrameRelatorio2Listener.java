package br.edu.univas.si4.lab4.busProject2.view.listener;

import java.util.ArrayList;

import br.edu.univas.si4.lab4.busProject2.model.Relatorio1TO;
import br.edu.univas.si4.lab4.busProject2.model.Relatorio2TO;

public interface FrameRelatorio2Listener {

	public void voltarRelatorio2();
	public ArrayList<Relatorio2TO> getListaTabela();
	public Relatorio1TO getDadosRelatorio();
}
