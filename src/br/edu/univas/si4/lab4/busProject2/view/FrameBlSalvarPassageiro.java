package br.edu.univas.si4.lab4.busProject2.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.edu.univas.si4.lab4.busProject2.model.AlunoDAO;
import br.edu.univas.si4.lab4.busProject2.model.AlunoTO;
import br.edu.univas.si4.lab4.busProject2.model.ViagemTO;
import br.edu.univas.si4.lab4.busProject2.model.Viagem_AlunoDAO;
import br.edu.univas.si4.lab4.busProject2.model.Viagem_AlunoTO;
import br.edu.univas.si4.lab4.busProject2.view.listener.FrameBlSalvarPassageiroListener;

public class FrameBlSalvarPassageiro extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private FrameBlSalvarPassageiroListener listener;
	
	private JButton btSalvar;
	private JButton btVoltar;
	
	private JComboBox jcAluno;
	private JLabel lbAluno = new JLabel("Escolha um aluno:");
	
	private JPanel pnBoToes;
	private JPanel pnJlist;
	
	public FrameBlSalvarPassageiro(FrameBlSalvarPassageiroListener listener) {
		this.listener=listener;
		init();
	}
	
	private void init() {
		 Container panel = getContentPane();
		 
		 setTitle("");
		 setSize(400, 300);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setLocationRelativeTo(null);
		 
		 panel.setLayout(new BorderLayout());
		 panel.add(getPnBoToes(),BorderLayout.SOUTH);
		 panel.add(getPnJcAluno(),BorderLayout.CENTER);

	}
	public JComboBox getJcAluno() {
		if(jcAluno==null){
			jcAluno = new JComboBox();
			AlunoDAO dao = new AlunoDAO();
			ArrayList<AlunoTO> alunos = dao.getAll();
			jcAluno.addItem("Selecione");
			for(int i=0 ;i<alunos.size();i++){
				jcAluno.addItem(alunos.get(i));
			}
		}
		return jcAluno;
	}
	
	public JPanel getPnJcAluno() {
		if(pnJlist==null){
			pnJlist = new JPanel();
			pnJlist.setLayout(new GridBagLayout());
			pnJlist.add(lbAluno,new GBC(1, 0));
			pnJlist.add(getJcAluno(),new GBC(1, 1).setSpan(2, 1));
		}
		return pnJlist;
	}
	
	public JPanel getPnBoToes() {
		if(pnBoToes==null){
			pnBoToes = new JPanel();
			pnBoToes.setLayout(new GridBagLayout());
			pnBoToes.add(getBtSalvar(),new GBC(0, 0));
			pnBoToes.add(getBtVoltar(),new GBC(2, 0));
			
		}
		
		return pnBoToes;
	}
	
	public JButton getBtSalvar() {
		if(btSalvar==null){
			btSalvar = new JButton("Salvar");
			
			btSalvar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					tratarBtSalvar();
					
				}
			});
		}		
		return btSalvar;
	}
	
	public JButton getBtVoltar() {
		if(btVoltar==null){
			btVoltar= new JButton("Voltar");
			btVoltar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					listener.tratarBtVoltar();
					
				}
			});
		}
		return btVoltar;
	}
	
	private void tratarBtSalvar() {
		
		int index = listener.getIndexViagem();
		Viagem_AlunoTO to = new Viagem_AlunoTO();
		AlunoTO ato = new AlunoTO();
		
		ato = (AlunoTO)getJcAluno().getSelectedItem();
		
		to.setId_aluno(ato.getId());
		to.setId_viagem(index);
		listener.tratarBtSalvar(to);
	}

}
