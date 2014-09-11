package br.edu.univas.si4.lab4.busProject2.controller;


import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.edu.univas.si4.lab4.busProject2.model.AlunoDAO;
import br.edu.univas.si4.lab4.busProject2.model.AlunoTO;
import br.edu.univas.si4.lab4.busProject2.model.InstituicaoDAO;
import br.edu.univas.si4.lab4.busProject2.model.InstituicaoTO;
import br.edu.univas.si4.lab4.busProject2.model.MotoristaDAO;
import br.edu.univas.si4.lab4.busProject2.model.MotoristaTO;
import br.edu.univas.si4.lab4.busProject2.model.Relatorio1TO;
import br.edu.univas.si4.lab4.busProject2.model.Relatorio2TO;
import br.edu.univas.si4.lab4.busProject2.model.RelatorioDAO;
import br.edu.univas.si4.lab4.busProject2.model.ViagemDAO;
import br.edu.univas.si4.lab4.busProject2.model.ViagemTO;
import br.edu.univas.si4.lab4.busProject2.model.Viagem_AlunoDAO;
import br.edu.univas.si4.lab4.busProject2.model.Viagem_AlunoTO;
import br.edu.univas.si4.lab4.busProject2.view.FrameBlSalvarPassageiro;
import br.edu.univas.si4.lab4.busProject2.view.FrameBusLayout;
import br.edu.univas.si4.lab4.busProject2.view.FrameCadastroAluno;
import br.edu.univas.si4.lab4.busProject2.view.FrameCadastroInstituicao;
import br.edu.univas.si4.lab4.busProject2.view.FrameCadastroMotorista;
import br.edu.univas.si4.lab4.busProject2.view.FrameListarAluno;
import br.edu.univas.si4.lab4.busProject2.view.FrameListarInstituicao;
import br.edu.univas.si4.lab4.busProject2.view.FrameListarMotorista;
import br.edu.univas.si4.lab4.busProject2.view.FramePrincipal;
import br.edu.univas.si4.lab4.busProject2.view.FrameRelatorio1;
import br.edu.univas.si4.lab4.busProject2.view.FrameRelatorio2;
import br.edu.univas.si4.lab4.busProject2.view.listener.FrameBlSalvarPassageiroListener;
import br.edu.univas.si4.lab4.busProject2.view.listener.FrameBusLayoutListener;
import br.edu.univas.si4.lab4.busProject2.view.listener.FrameCadastarMotoristaListener;
import br.edu.univas.si4.lab4.busProject2.view.listener.FrameCadastrarAlunoListener;
import br.edu.univas.si4.lab4.busProject2.view.listener.FrameCadastrarInstituicaoListener;
import br.edu.univas.si4.lab4.busProject2.view.listener.FrameListarAlunoListener;
import br.edu.univas.si4.lab4.busProject2.view.listener.FrameListarInstituicaoListener;
import br.edu.univas.si4.lab4.busProject2.view.listener.FrameListarMotoristaListener;
import br.edu.univas.si4.lab4.busProject2.view.listener.FramePrincipalListener;
import br.edu.univas.si4.lab4.busProject2.view.listener.FrameRelatorio1Listener;
import br.edu.univas.si4.lab4.busProject2.view.listener.FrameRelatorio2Listener;

public class BusProject2Control implements FrameBusLayoutListener,FramePrincipalListener, 
FrameCadastarMotoristaListener,FrameListarMotoristaListener,FrameCadastrarInstituicaoListener,
FrameListarInstituicaoListener,FrameCadastrarAlunoListener,FrameListarAlunoListener, FrameBlSalvarPassageiroListener,FrameRelatorio1Listener,FrameRelatorio2Listener {
	
	 private FramePrincipal frPrincipal;
	 private FrameBusLayout frBusLayout;
	 private FrameCadastroAluno frAluno;
	 private FrameCadastroMotorista frMotorista;
	 private FrameCadastroInstituicao frInstituicao;
	 private FrameListarAluno frListarAluno;
	 private FrameListarMotorista frListarMotorista;
	 private FrameListarInstituicao frListarInstituicao;
	 private FrameBlSalvarPassageiro frPassageiro;
	 private FrameRelatorio1 frRelatorio1;
	 private FrameRelatorio2 frRelatorio2;
	 
	 private MotoristaDAO motoristaDAO;
	 private AlunoDAO alunoDAO;
	 private InstituicaoDAO instituicaoDAO;
	 private Viagem_AlunoDAO viagem_AlunoDAO;
	 private ViagemDAO viagemDAO;
	 private RelatorioDAO relatorioDAO;
	
	public void init() {
		
		
		motoristaDAO = new MotoristaDAO();
		alunoDAO = new AlunoDAO();
		viagem_AlunoDAO = new Viagem_AlunoDAO();
		viagemDAO = new ViagemDAO();
		instituicaoDAO = new InstituicaoDAO();
		relatorioDAO = new RelatorioDAO();
		
		
		frListarInstituicao = new FrameListarInstituicao(this);
		frListarMotorista = new FrameListarMotorista(this);
		frListarAluno = new FrameListarAluno(this);
		frBusLayout = new FrameBusLayout(this);
		frAluno = new FrameCadastroAluno(this);
		frMotorista = new FrameCadastroMotorista(this);
		frInstituicao = new FrameCadastroInstituicao(this);
		frPassageiro = new FrameBlSalvarPassageiro(this);
		frPrincipal = new FramePrincipal(this);
		frPrincipal.setVisible(true);
	}
	
	@Override
	public void tratarBtPassageiro() {
		frPassageiro = new FrameBlSalvarPassageiro(this);
		frPassageiro.setVisible(true);
		frBusLayout.setVisible(false);
		System.out.println("Clicou botão Passageiro");
		
	}

	@Override
	public void tratarSaida() {
		JOptionPane.showMessageDialog(null,"Boa viagem !", "Sair",JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
		}

	@Override
	public void tratarMotoristaNovaViagem() {
		System.out.println("ALguem Clicou Nova Viagem");
		frPrincipal.setVisible(false);
		frBusLayout.setVisible(true);
		
		
	}

	@Override
	public void mostrarEditarAluno(AlunoTO aluno) {
		frAluno.setAluno(aluno);
		frListarAluno.setVisible(false);
		frAluno.setVisible(true);		
	}

	@Override
	public void salvar(AlunoTO to) {
		if(to.getId() == 0 ){
			alunoDAO.salvar(to);
		} else{
			alunoDAO.atualizar(to);
		}
		frListarAluno.setListaAlunos(alunoDAO.getAll());
		frAluno.setVisible(false);
		frListarAluno.setVisible(true);
		
	}

	@Override
	public void voltarAluno() {
		frAluno.setVisible(false);
		frPrincipal.setVisible(true);
		
	}

	@Override
	public void mostrarEditarInstituicao(InstituicaoTO instituicao) {
		
		frInstituicao.setInstituicao(instituicao);
		frListarInstituicao.setVisible(false);
		frInstituicao.setVisible(true);
		
	}

	@Override
	public void salvar(InstituicaoTO to) {
		if(to.getId() == 0 ){
			instituicaoDAO.salvar(to);
		} else{
			instituicaoDAO.atualizar(to);
		}
		
		frListarInstituicao.setListaContatos(instituicaoDAO.getAll());
		
		frInstituicao.setVisible(false);
		frListarInstituicao.setVisible(true);
		
		
	}

	@Override
	public void voltarInstituicao() {
		System.out.println("Alguem Clicou em Menu Principal no frame cadastro instituição");
		frInstituicao.setVisible(false);
		frPrincipal.setVisible(true);		
	}

	@Override
	public void mostrarEditarMotorista(MotoristaTO motorista) {
		frMotorista.setMotorista(motorista);
		frListarMotorista.setVisible(false);
		frMotorista.setVisible(true);
	}

	@Override
	public void voltarListar() {
		frListarAluno.setVisible(false);
		frListarInstituicao.setVisible(false);
		frListarMotorista.setVisible(false);
		frBusLayout.setVisible(false);
		frPrincipal.setVisible(true);
	}

	@Override
	public void salvar(MotoristaTO to) {
		if(to.getId() == 0 ){
			motoristaDAO.salvar(to);
		} else
		{
			motoristaDAO.atualizar(to);
		}
			
			frListarMotorista.setListaContatos(motoristaDAO.getAll());
			
			frMotorista.setVisible(false);
			frListarMotorista.setVisible(true);
	}

	@Override
	public void voltarMotorista() {
		frMotorista.setVisible(false);
		frPrincipal.setVisible(true);
		
	}

	@Override
	public void tratarMotoristaCadastro() {
			frPrincipal.setVisible(false);
			frMotorista.setMotorista(new MotoristaTO());
			frMotorista.setVisible(true);
	}

	@Override
	public void tratarMotoristaRelatorio() {
		System.out.println("Alguem Clicou em listar motorista no menu principal");
		frPrincipal.setVisible(false);		
		frListarMotorista.setListaContatos(motoristaDAO.getAll());		
		frListarMotorista.setVisible(true);
		
	}

	@Override
	public void tratarAlunoCadastro() {
		frPrincipal.setVisible(false);
		frAluno = new FrameCadastroAluno(this);
		frAluno.setAluno(new AlunoTO());
		frAluno.setVisible(true);
		
		
	}

	@Override
	public void tratarAlunoRelatorio() {
		frPrincipal.setVisible(false);
		frListarAluno.setListaAlunos(alunoDAO.getAll());
		frListarAluno.setVisible(true);
		
	}

	@Override
	public void tratarInstituicaCadastro() {
		frPrincipal.setVisible(false);
		frInstituicao.setInstituicao(new InstituicaoTO());
		frInstituicao.setVisible(true);		
	}

	@Override
	public void tratarInstituicaoRelatorio() {
		frPrincipal.setVisible(false);		
		frListarInstituicao.setListaContatos(instituicaoDAO.getAll());		
		frListarInstituicao.setVisible(true);
		
	}

	@Override
	public void remover(InstituicaoTO instituicao) {
		instituicaoDAO.remover(instituicao);
		frListarInstituicao.setListaContatos(instituicaoDAO.getAll());
		
	}

	@Override
	public void remover(MotoristaTO motorista) {
		motoristaDAO.remover(motorista);		
		frListarMotorista.setListaContatos(motoristaDAO.getAll());
		
	}

	@Override
	public void remover(AlunoTO aluno) {
		alunoDAO.remover(aluno);		
		frListarAluno.setListaAlunos(alunoDAO.getAll());		
	}

	@Override
	public void tratarBlBtSalvar(ViagemTO to) {
		viagemDAO.salvar(to);
		
	}

	@Override
	public void tratarBtSalvar(Viagem_AlunoTO to) {
		viagem_AlunoDAO.salvar(to);
		frPassageiro.setVisible(false);
		frBusLayout.setVisible(true);
		
	}

	@Override
	public void tratarBtVoltar() {
		frPassageiro.setVisible(false);
		frBusLayout.setVisible(true);		
	}

	@Override
	public ArrayList<InstituicaoTO> getListInstituicao() {
		return instituicaoDAO.getAll();
	}

	@Override
	public ArrayList<MotoristaTO> getListMotorista() {
		return motoristaDAO.getAll();
	}

	@Override
	public ArrayList<Relatorio2TO> getListaTabela() {
		return relatorioDAO.getDadosRelatorio2();
	}

	@Override
	public void voltarRelatorio1() {
		if(frRelatorio1 == null){
			
		} else {
		frRelatorio1.setVisible(false);
		frPrincipal.setVisible(true);
		}
		
	}

	@Override
	public ArrayList<AlunoTO> getListaAlunosRelatorio() {
		return relatorioDAO.getNomeAlunos();
	}

	@Override
	public Relatorio1TO getDadosRelatorio() {
		return relatorioDAO.getDadosRelatorio1();
	}

	@Override
	public void tratarRelatorio1() {
		frRelatorio1 = new FrameRelatorio1(this);
		frRelatorio1.setListaAlunos(relatorioDAO.getNomeAlunos());
		frPrincipal.setVisible(false);
		frRelatorio1.setVisible(true);
		
	}

	@Override
	public void tratarRelatorio2() {
		frRelatorio2 = new FrameRelatorio2(this);
		frRelatorio2.setListaContatos(relatorioDAO.getDadosRelatorio2());
		frPrincipal.setVisible(false);
		frRelatorio2.setVisible(true);
		
	}

	@Override
	public void voltarRelatorio2() {
		if(frRelatorio2 == null){
			
		} else {
			frRelatorio2.setVisible(false);
			frPrincipal.setVisible(true);
		}
		
	}

	@Override
	public int getIndexViagem() {
		return viagem_AlunoDAO.getIndexNow();
	}

}
