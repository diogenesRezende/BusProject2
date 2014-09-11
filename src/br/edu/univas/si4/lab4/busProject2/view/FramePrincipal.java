package br.edu.univas.si4.lab4.busProject2.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import br.edu.univas.si4.lab4.busProject2.view.listener.FramePrincipalListener;

public class FramePrincipal extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private JMenuBar barraDeMenu;
	
	private JMenu menuNovo;
	
	private JMenu menuMotorista;
	private JMenu menuAluno;
	private JMenu menuInstituicao;
	private JMenu menuViagem;	
	private JMenu menuVisualizar;
	private JMenu menuRelatorio;
	private JMenu menuAjuda;
	
	private JMenuItem cadastrarMotorista;
	private JMenuItem cadastrarAluno;
	private JMenuItem cadastrarInstituicao;
	private JMenuItem cadastrarViagem;
	private JMenuItem menuSair;
	private JMenuItem menuSobre;
	
	private JMenuItem listarMotorista;
	private JMenuItem listarAluno;
	private JMenuItem listarInstituicao;
	
	private JMenuItem relatorio1;
	private JMenuItem relatorio2;
	
	private FramePrincipalListener listener;
	
	private JLabel lbImagem;
	
	public FramePrincipal(FramePrincipalListener listener) {
		this.listener = listener;
		init();
	}
	
	private void init() {
		
		Container c = getContentPane();
		
		//listener = new BusProject2Control();
		
		
		//setSize(1366, 678);
		setSize(1024,768);
		setTitle("Menu Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		c.setLayout(new BorderLayout());
		c.add(getBarraDeMenu(),BorderLayout.NORTH);
		c.add(getLbImagem(),BorderLayout.CENTER);
	}
	
	public JLabel getLbImagem() {
		if(lbImagem == null){
			ImageIcon imageOnibus = new ImageIcon(getClass().getResource("fotos//Onibus_escolar_faculdade_BomRepouso.jpg"));
			lbImagem = new JLabel(imageOnibus);
		}
		return lbImagem;
	}
	
	public JMenuBar getBarraDeMenu() {
		if(barraDeMenu==null){
			barraDeMenu = new JMenuBar();
			barraDeMenu.add(getMenuNovo());
			barraDeMenu.add(getMenuVisualizar());
			barraDeMenu.add(getMenuRelatorio());
			barraDeMenu.add(getMenuAjuda());
		}
		return barraDeMenu;
	}
	
	public JMenu getMenuNovo() {
		if(menuNovo==null){
			menuNovo=new JMenu("   Novo   ");
			menuNovo.add(getMenuMotorista());
			menuNovo.add(getMenuAluno());
			menuNovo.add(getMenuInstituicao());
			menuNovo.add(getMenuSair());
			
		}
		return menuNovo;
	}
	
	public JMenu getMenuVisualizar() {
		if(menuVisualizar==null){
			menuVisualizar = new JMenu("   Visualizar   ");
			menuVisualizar.add(getListarMotorista());
			menuVisualizar.add(getListarAluno());
			menuVisualizar.add(getListarInstituicao());
		}
		return menuVisualizar;
	} public JMenu getMenuAjuda() {
		if (menuAjuda == null) {
			menuAjuda = new JMenu("    Ajuda   ");
			menuAjuda.add(getMenuSobre());
			
		}
		return menuAjuda;
	}
	public JMenuItem getMenuSobre() {
		if(menuSobre == null){
			menuSobre = new JMenuItem("   Sobre   ");
			menuSobre.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Desenvolvedores :\nFront end : Diógenes Aparecido Rezende\nContato : (035) 9937 0714\nBack end : João Paulo Nakajima Pereira\nContato : (035) 9997 1286", "Sobre", JOptionPane.INFORMATION_MESSAGE);
					
				}
			});
		}
		return menuSobre;
	}
	
	public JMenu getMenuRelatorio() {
		if(menuRelatorio == null){
			menuRelatorio = new JMenu("Visualizar Relatórios");
			menuRelatorio.add(getRelatorio1());
			menuRelatorio.add(getRelatorio2());
		}
		return menuRelatorio;
	}
	
	public JMenu getMenuMotorista() {
		if(menuMotorista==null){
			
			menuMotorista =new JMenu("   Motorista   ");
			menuMotorista.add(getCadastrarMotorista());
			menuMotorista.add(getMenuViagem());
		}
		
		return menuMotorista;
	}
	
	public JMenu getMenuAluno() {
		if(menuAluno==null){
			menuAluno = new JMenu("   Aluno   ");
			menuAluno.add(getCadastrarAluno());
		}
		return menuAluno;
	}
	
	public JMenu getMenuInstituicao() {
		if(menuInstituicao==null){
			menuInstituicao = new JMenu("   Instituição   ");
			menuInstituicao.add(getCadastrarInstituicao());
		}
		return menuInstituicao;
	}
	
	public JMenu getMenuViagem() {
		if(menuViagem==null){			
			menuViagem = new JMenu("   Viagem   ");
			menuViagem.add(getCadastrarViagem());
		}		
		return menuViagem;
	}
	
	public JMenuItem getCadastrarMotorista() {
		if(cadastrarMotorista==null){
			cadastrarMotorista = new JMenuItem("Cadastrar Motorista");
			cadastrarMotorista.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					listener.tratarMotoristaCadastro();
					
				}
			});
		}
		return cadastrarMotorista;
	}
	
	public JMenuItem getCadastrarAluno() {
		if(cadastrarAluno==null){
			cadastrarAluno = new JMenuItem("Cadastrar Aluno");
			
			cadastrarAluno.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					listener.tratarAlunoCadastro();
					
				}
			});
		}
		return cadastrarAluno;
	}
	
	public JMenuItem getCadastrarInstituicao() {
		if(cadastrarInstituicao==null){
			cadastrarInstituicao = new JMenuItem("Cadastrar Intituição");
			
			cadastrarInstituicao.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					listener.tratarInstituicaCadastro();
					
				}
			});
		}
		return cadastrarInstituicao;
	}
	
	public JMenuItem getCadastrarViagem() {
		if(cadastrarViagem==null){
			cadastrarViagem = new JMenuItem("Nova Viagem");
			cadastrarViagem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					listener.tratarMotoristaNovaViagem();
					
				}
			});
		}
		return cadastrarViagem;
	}
	
	public JMenuItem getMenuSair() {
		if(menuSair==null){
			menuSair=new JMenuItem("   Sair   ");
			menuSair.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					listener.tratarSaida();					
				}
			});
		}
		return menuSair;
	}
	
	public JMenuItem getListarMotorista() {
		if(listarMotorista==null){
			listarMotorista=new JMenuItem("Listar Motoristas");
			
			listarMotorista.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					listener.tratarMotoristaRelatorio();
					
				}
			});
		}
		return listarMotorista;
	}
	
	public JMenuItem getListarAluno() {
		if(listarAluno==null){
			listarAluno = new JMenuItem("Listar Alunos");
			
			listarAluno.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					listener.tratarAlunoRelatorio();
					
				}
			});
		}
		return listarAluno;
	}
	
	public JMenuItem getListarInstituicao() {
		if(listarInstituicao==null){
			listarInstituicao= new JMenuItem("Listar Instituições");
			
			listarInstituicao.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					listener.tratarInstituicaoRelatorio();
					
				}
			});
		}
		return listarInstituicao;
	}
	public JMenuItem getRelatorio1() {
		if(relatorio1 == null){
			relatorio1 = new JMenuItem("Comprovante de Viagem");
			relatorio1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					listener.tratarRelatorio1();
				}
			});
		}
		return relatorio1;
	}
	public JMenuItem getRelatorio2() {
		if(relatorio2 == null){
			relatorio2 = new JMenuItem("Relatório de Instituições");
			relatorio2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					listener.tratarRelatorio2();
				}
			});
		}
		return relatorio2;
	}
}
