package br.edu.univas.si4.lab4.busProject2.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import br.edu.univas.si4.lab4.busProject2.model.InstituicaoTO;
import br.edu.univas.si4.lab4.busProject2.view.listener.FrameCadastrarInstituicaoListener;

public class FrameCadastroInstituicao extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JLabel lbNome= new JLabel("Nome:");
	private JTextField txNome = new JTextField();
	
	private JLabel lbEndereco= new JLabel("Endereco:");
	private JTextField txEndereco = new JTextField();
	
	private JLabel lbNumero= new JLabel("Numero:");
	private JTextField txNumero = new JTextField();	
	
	private JLabel lbBairro= new JLabel("Bairro:");
	private JTextField txBairro = new JTextField();
	
	private JLabel lbCidade= new JLabel("Cidade:");
	private JTextField txCidade = new JTextField();
	
	private JLabel lbTelefone= new JLabel("Telefone:");
	//private JTextField txTelefone = new JTextField();
	private JFormattedTextField txTelefone;
	
	private JLabel lbEmail= new JLabel("Email:");
	private JTextField txEmail = new JTextField();
	
	private JButton btClearAll;
	private JButton btMenuPrincipal;
	private JButton btSalvar;
	
	private JPanel painelBotoes;
	private JPanel painelDados;
	
	private InstituicaoTO instituicao;
	
	private FrameCadastrarInstituicaoListener listener;
	
	public FrameCadastroInstituicao(FrameCadastrarInstituicaoListener listener) {
		this.listener = listener;
		init();
	}

	private void init() {
		Container panel = getContentPane();
		
		setSize(500, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Cadastro Instituição");
		
		panel.setLayout(new BorderLayout());
		
		//panel.add(new JLabel("Dados Instituição"),BorderLayout.NORTH);
		panel.add(getPainelBotoes(),BorderLayout.SOUTH);
		panel.add(getPainelDados(),BorderLayout.CENTER);
		
		
		

	}
	
	public JButton getBtClearAll() {
		if(btClearAll == null){
			btClearAll=new JButton("Limpar Campos");
			btClearAll.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					txBairro.setText("");
					txCidade.setText("");
					txEmail.setText("");
					txEndereco.setText("");
					txNome.setText("");
					txNumero.setText("");
					txTelefone.setText("");
				}
			});
		}
		return btClearAll;
	}
	
	public JButton getBtMenuPrincipal() {
		if(btMenuPrincipal==null){
			
			btMenuPrincipal = new JButton("Menu Principal");
			btMenuPrincipal.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					listener.voltarInstituicao();
				}
			});
			
		}
		return btMenuPrincipal;
	}
	
	public JButton getBtSalvar() {
		if(btSalvar==null){
			btSalvar = new JButton("Salvar");
			btSalvar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					tratarInstituicaoSalvar();
					
				}

				

				});
			}
		return btSalvar;
	}
	
	public JPanel getPainelBotoes() {
		if(painelBotoes==null){
			painelBotoes = new JPanel();
			painelBotoes.setLayout(new GridBagLayout());
			painelBotoes.add(getBtSalvar(),new GBC(0, 0));
			painelBotoes.add(getBtClearAll(),new GBC(2, 0));
			painelBotoes.add(getBtMenuPrincipal(),new GBC(5, 0));
		}
		return painelBotoes;
	}
	
	public JPanel getPainelDados() {
		if(painelDados==null){
			
			painelDados = new JPanel();			
			
			painelDados.setLayout(new GridBagLayout());
			
			painelDados.add(lbNome,new GBC(0, 0));
			painelDados.add(txNome,new GBC(1, 0).setSpan(6, 1));
			
			painelDados.add(lbEndereco,new GBC(0, 1));
			painelDados.add(txEndereco,new GBC(1, 1).setSpan(4, 1).setIpad(120, 0));
			
			painelDados.add(lbNumero,new GBC(5, 1));
			painelDados.add(txNumero,new GBC(6, 1));
			
			painelDados.add(lbBairro,new GBC(0, 2));
			painelDados.add(txBairro,new GBC(1, 2).setSpan(2, 1).setIpad(120, 0));
			
			painelDados.add(lbCidade,new GBC(4, 2));
			painelDados.add(txCidade,new GBC(5, 2).setSpan(2, 1).setIpad(120, 0));
			
			painelDados.add(lbEmail,new GBC(0, 3));
			painelDados.add(txEmail,new GBC(1, 3).setSpan(3, 1).setIpad(120, 0));
			
			painelDados.add(lbTelefone, new GBC(4, 3));
			painelDados.add(getTxTelefone(), new GBC(5, 3).setSpan(2, 1).setIpad(120, 0));
			
			
		};
		return painelDados;
	}
	
	private void tratarInstituicaoSalvar() {
		if(txBairro.getText().isEmpty() || txCidade.getText().isEmpty() || txEmail.getText().isEmpty() || txEndereco.getText().isEmpty() ||
				txNome.getText().isEmpty() || txNumero.getText().isEmpty() || txTelefone.getText().isEmpty()){
			JOptionPane.showMessageDialog(this, "Existe campo vazio.","Salvar",JOptionPane.ERROR_MESSAGE);
			
		}else{
			
			instituicao.setBairro(txBairro.getText());
			instituicao.setCidade(txCidade.getText());
			instituicao.setEmail(txEmail.getText());
			instituicao.setEndereco(txEndereco.getText());
			instituicao.setNome(txNome.getText());
			try {
				instituicao.setNum_end(Integer.parseInt(txNumero.getText()));
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Insira um Número no campo número","Salvar",JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
			instituicao.setTelefone(txTelefone.getText());
			listener.salvar(instituicao);
		}
	}
	
	public JFormattedTextField getTxTelefone() {
		if(txTelefone==null){
			MaskFormatter mas = new MaskFormatter();  
	        try{  
	            mas.setMask("(##)####-####"); //Atribui a mascara  
	            mas.setPlaceholderCharacter(' '); //Caracter para preencimento   
	        }  
	        catch (Exception excecao) {  
	        excecao.printStackTrace();  
	        }  
	        txTelefone=new JFormattedTextField(mas);
		}
		return txTelefone;
	}
	
	public void setInstituicao(InstituicaoTO instituicao){
		this.instituicao = instituicao;
		
		txNome.setText(instituicao.getNome());
		txTelefone.setText(instituicao.getTelefone());
		txNumero.setText("" + instituicao.getNum_end());
		txEndereco.setText(instituicao.getEndereco());
		txEmail.setText(instituicao.getEmail());
		txCidade.setText(instituicao.getCidade());
		txBairro.setText(instituicao.getBairro());

		
		
	}

}
