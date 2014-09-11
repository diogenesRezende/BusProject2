package br.edu.univas.si4.lab4.busProject2.view.listener;

import java.util.ArrayList;

import br.edu.univas.si4.lab4.busProject2.model.MotoristaTO;
import br.edu.univas.si4.lab4.busProject2.model.ViagemTO;

public interface FrameBusLayoutListener{
	
	public void tratarBlBtSalvar(ViagemTO to);
	public void tratarBtPassageiro();
	public void voltarListar();
	public ArrayList<MotoristaTO> getListMotorista();

}
