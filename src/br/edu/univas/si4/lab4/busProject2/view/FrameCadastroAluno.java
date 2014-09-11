package br.edu.univas.si4.lab4.busProject2.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import br.edu.univas.si4.lab4.busProject2.model.AlunoTO;
import br.edu.univas.si4.lab4.busProject2.model.InstituicaoTO;
import br.edu.univas.si4.lab4.busProject2.view.listener.FrameCadastrarAlunoListener;

public class FrameCadastroAluno extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private FrameCadastrarAlunoListener listener;

	private AlunoTO aluno;
	
	private JLabel lbNome = new JLabel("Nome:");
	private JTextField txNome = new JTextField();
	
	private JLabel lbEndereco = new JLabel("Endereço:");
	private JTextField txEndereco = new JTextField();
	
	private JLabel lbNumero = new JLabel("Número:");
	private JTextField txNumero = new JTextField();
	
	private JLabel lbCelular = new JLabel("Celular:");
	//private JTextField txCelular = new JTextField();
	private JFormattedTextField txCelular;
	
	private JLabel lbInstituicao = new JLabel("Instituição:");
	private JComboBox comboLista;
	
	
	private JPanel painelDados;
	private JPanel painelBotoes;
	
	private JButton btSalvar;
	private JButton btClearAll;
	private JButton btMenuPrincipal;	
	
	public FrameCadastroAluno(FrameCadastrarAlunoListener listener) {
		this.listener = listener;
		init();
	}
	
	private void init() {
		
		Container panel = getContentPane();
		
		setSize(600, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		panel.setLayout(new BorderLayout());
		panel.add(getPainelBotoes(),BorderLayout.SOUTH);
		panel.add(getPainelDados(),BorderLayout.CENTER);

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
			
			painelDados.add(lbNome,new GBC(0, 0).setSpan(1, 1));
			painelDados.add(txNome,new GBC(1, 0).setSpan(7, 1).setIpad(120, 0));
			
			painelDados.add(lbEndereco,new GBC(0, 1));
			painelDados.add(txEndereco,new GBC(1, 1).setSpan(3, 1).setIpad(120, 0));
			
			painelDados.add(lbCelular,new GBC(6, 1));
			painelDados.add(getTxCelular(),new GBC(7, 1).setIpad(120, 0));
			
			painelDados.add(lbNumero,new GBC(4, 1));
			painelDados.add(txNumero,new GBC(5, 1).setIpad(30, 0));			
			
			painelDados.add(lbInstituicao, new GBC(0, 2));
			painelDados.add(getComboLista(),new GBC(1, 2).setSpan(5, 1));
			
			
			
			
		}
		return painelDados;
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
	
	public JButton getBtClearAll() {
		if(btClearAll==null){
			
			btClearAll = new JButton("Limpar Campos");
			btClearAll.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					txCelular.setText("");
					txEndereco.setText("");
					txNome.setText("");
					txNumero.setText("");
					
				}
			});
			
		}
		return btClearAll;
	}
	
	public JButton getBtMenuPrincipal() {
		if(btMenuPrincipal==null){
			
			btMenuPrincipal=new JButton("Menu Principal");
			btMenuPrincipal.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					listener.voltarAluno();
					
				}
			});
		}
		return btMenuPrincipal;
	}
	
	public JComboBox getComboLista() {
		if(comboLista == null){
			
			
			ArrayList<InstituicaoTO> vetor = listener.getListInstituicao();
			comboLista = new JComboBox();
			comboLista.addItem("Selecione");
			for(int i=0; i<vetor.size();i++){
				comboLista.addItem(vetor.get(i));				
			}
			
		}
		return comboLista;
	}

	
	private void tratarBtSalvar() {
		if(txCelular.getText().isEmpty()||txEndereco.getText().isEmpty()||txNome.getText().isEmpty()||txNumero.getText().isEmpty()){
			JOptionPane.showMessageDialog(this, "Existe campo vazio.","Salvar",JOptionPane.WARNING_MESSAGE);
		}else{
			
			aluno.setCelular(txCelular.getText());
			aluno.setEndereco(txEndereco.getText());
			aluno.setNome(txNome.getText());
			try {
				aluno.setNum_end(Integer.parseInt(txNumero.getText()));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Insira um Número no campo número","Salvar",JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
			InstituicaoTO toSelected = (InstituicaoTO)getComboLista().getSelectedItem();
			aluno.setId_instituicao(toSelected.getId());
			
			listener.salvar(aluno);
			
		}
	}

	public void setAluno(AlunoTO to) {
		this.aluno=to;
		txNome.setText(to.getNome());
		txNumero.setText("" +to.getNum_end());
		txEndereco.setText(to.getEndereco());
		txCelular.setText(to.getCelular());
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
	
    /*public MaskFormatter getMascara(){  
        
        MaskFormatter F_Mascara = new MaskFormatter();  
        try{  
            F_Mascara.setMask("(##)#####-####"); //Atribui a mascara  
            F_Mascara.setPlaceholderCharacter(' '); //Caracter para preencimento   
        }  
        catch (Exception excecao) {  
        excecao.printStackTrace();  
        }   
        return F_Mascara;  
 }*/   
	
	

}
