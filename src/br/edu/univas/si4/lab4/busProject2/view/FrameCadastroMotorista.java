package br.edu.univas.si4.lab4.busProject2.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import br.edu.univas.si4.lab4.busProject2.model.MotoristaTO;
import br.edu.univas.si4.lab4.busProject2.view.listener.FrameCadastarMotoristaListener;

public class FrameCadastroMotorista extends JFrame {

	
	private static final long serialVersionUID = 1L;

	private FrameCadastarMotoristaListener listener;
	
	private MotoristaTO motorista;
	private String aux;
	private String[] catCnh={"Selecione","D","E"};
	
	private JLabel lbNome = new JLabel("Nome:");
	private JLabel lbCelular = new JLabel("Celular: ");
	private JLabel lbCategoriaCnh = new JLabel("Categoria Cnh: ");

	
	private JTextField txNome = new JTextField();
	//private JTextField txCelular = new JTextField();
	private JFormattedTextField txCelular;
	
	private JButton btSalvar;
	private JButton btVoltarMenuPrincipal;
	private JButton btLimparCampos;
	
	private JPanel painelBotoes;
	
	private JComboBox txCategoria = new JComboBox(catCnh);
	
	
	
	public FrameCadastroMotorista(FrameCadastarMotoristaListener listener) {
		this.listener = listener;
		init();
	}

	private void init() {
		Container panel = getContentPane();
		
		setSize(450,200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		BorderLayout layout = new BorderLayout();
		panel.setLayout(layout);
		
		panel.add(getDados(), BorderLayout.CENTER);
		panel.add(getPainelBotoes(), BorderLayout.SOUTH);
		
	}
	
	
	private JPanel getDados() {
		JPanel panel = new JPanel();
		GridBagLayout layout = new GridBagLayout();
		panel.setLayout(layout);
		
		
		
		panel.add(lbNome,new GBC(0, 0));		
		panel.add(txNome,new GBC(1, 0).setSpan(4, 1).setIpad(20, 0));
		
		panel.add(lbCelular,new GBC(0, 1).setSpan(1, 1));
		panel.add(getTxCelular(), new GBC(1, 1).setIpad(100, 0).setSpan(2, 1));
		
		panel.add(lbCategoriaCnh,new GBC(3, 1).setSpan(1, 1));
		panel.add(txCategoria,new GBC(4, 1).setIpad(30, 0).setSpan(1, 1));
		
		return panel;
	}
	
	
	public JButton getBtLimparCampos() {
		if(btLimparCampos == null){
			btLimparCampos = new JButton("Limpar dados");
			
			btLimparCampos.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					txNome.setText("");
					txCelular.setText("");
				}
			});
		}
		return btLimparCampos;
	}
	
	public JPanel getPainelBotoes() {
		if(painelBotoes == null){
			painelBotoes = new JPanel();
			painelBotoes.setLayout(new GridBagLayout());
			painelBotoes.add(getBtSalvar(),new GBC(0, 0));
			painelBotoes.add(getBtLimparCampos(),new GBC(2, 0));
			painelBotoes.add(getBtVoltarMenuPrincipal(),new GBC(5, 0));
		}
		return painelBotoes;
	}
	
	public JButton getBtSalvar() {
		if(btSalvar == null){
			btSalvar = new JButton("Salvar");
			
			btSalvar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					tratarBotaoSalvar();
				}
			});
			
		}
		return btSalvar;
	}
	
	public JButton getBtVoltarMenuPrincipal() {
		if(btVoltarMenuPrincipal == null){
			btVoltarMenuPrincipal = new JButton("Menu Principal");
			
			btVoltarMenuPrincipal.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
						listener.voltarMotorista();
				}
			});
		}
		return btVoltarMenuPrincipal;
	}
	
		
		private void tratarBotaoSalvar(){
			
				aux = catCnh[txCategoria.getSelectedIndex()];
				
					if(txNome.getText().isEmpty() || txCelular.getText().isEmpty()){
						JOptionPane.showMessageDialog(this, "Existe campo vazio.","Salvar",JOptionPane.WARNING_MESSAGE);
					}else{
						System.out.println("Alguém clicou o botão salvar.");
						
						
						motorista.setNome(txNome.getText());
						motorista.setCelular(txCelular.getText());
						motorista.setCategoriaCnh(aux);
						listener.salvar(motorista);
						
					}
				}
		public void setMotorista(MotoristaTO motorista){
			this.motorista = motorista;
			
			txNome.setText(motorista.getNome());
			txCelular.setText(motorista.getCelular());
		}
		
		public JFormattedTextField getTxCelular() {
			if(txCelular==null){
				  MaskFormatter mas = new MaskFormatter();  
			        try{  
			            mas.setMask("(##)####-####"); //Atribui a mascara  
			            mas.setPlaceholderCharacter(' '); //Caracter para preencimento   
			        }  
			        catch (Exception excecao) {  
			        excecao.printStackTrace();  
			        }   
				txCelular= new JFormattedTextField(mas);
				
			}
			return txCelular;
		}
	}
