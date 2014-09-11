package br.edu.univas.si4.lab4.busProject2.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.edu.univas.si4.lab4.busProject2.model.Relatorio1TO;
import br.edu.univas.si4.lab4.busProject2.model.Relatorio2TO;
import br.edu.univas.si4.lab4.busProject2.view.listener.FrameRelatorio2Listener;

public class FrameRelatorio2 extends JFrame {

	
	
	private static final long serialVersionUID = 1L;

	private JTable table;
	private DefaultTableModel model;
	private List<Relatorio2TO> listaInstituicoesAlunos = new ArrayList<Relatorio2TO>();
	private String[] cabecalho = new String[] {"Instituição", "Qtde de alunos"};
	
	private JButton btMenuPrincipal;
	private JLabel lbCidadeData;
	private JPanel painelSul;
	private JScrollPane scroll;
	private JPanel painelDados;
	private JPanel painelCentral;
	
	private JLabel lbTitulo;
	private JLabel lbComprovante;
	private JLabel lbMotorista;
	private JLabel lbTrajeto;
	private JLabel lbObjetivo;
	private JLabel lbQtde;
	private JLabel lbCapacidade;
	private JLabel lbLugaresVazios;
	
	FrameRelatorio2Listener listener;
	Relatorio1TO to;
	
	public FrameRelatorio2(FrameRelatorio2Listener listener) {
		this.listener = listener;
		init();
	}

	private void init() {
		Container panel = getContentPane();
		
		setTitle("Relatório de Instituições");
		setSize(729,729);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		BorderLayout layout = new BorderLayout();
		panel.setLayout(layout);
		
		panel.add(getPainelDados(),BorderLayout.NORTH);
		panel.add(getPainelCentral(), BorderLayout.CENTER);
		panel.add(getPainelSul(), BorderLayout.SOUTH);
	}
	
	private JPanel getPainelSul() {
		if(painelSul == null){
			painelSul = new JPanel();
			painelSul.setLayout(new GridBagLayout());
			painelSul.add(getLbCidadeData(),new GBC(0, 0));
			painelSul.add(getBtMenuPrincipal(),new GBC(0, 1));
		}
		return painelSul;
	}
	public JPanel getPainelDados() {
		painelDados = new JPanel();
		to = listener.getDadosRelatorio();
		GridBagLayout layout = new GridBagLayout();
		painelDados.setLayout(layout);
		
		painelDados.add(getLbTitulo(),new GBC(1, 0).setSpan(3, 1));
		
		painelDados.add(getLbComprovante(),new GBC(1, 2).setSpan(3, 1));
		
		painelDados.add(getLbMotorista(),new GBC(0, 4).setSpan(2, 1));
		
		painelDados.add(getLbTrajeto(),new GBC(0, 5).setSpan(3, 1));
		
		painelDados.add(getLbObjetivo(),new GBC(0, 6).setSpan(4, 1));
		
		painelDados.add(getLbCapacidade(),new GBC(0, 7).setSpan(2, 1));
		
		painelDados.add(getLbQtde(),new GBC(0, 8).setSpan(2, 1));
		
		painelDados.add(getLbLugaresVazios(),new GBC(0, 9).setSpan(2, 1));
		
		
		
		return painelDados;
	}
	public JPanel getPainelCentral() {
		if(painelCentral == null){
			painelCentral = new JPanel();
			painelCentral.setLayout(new BorderLayout());
			painelCentral.add(getScroll(),BorderLayout.CENTER);
		}
		return painelCentral;
	}
	
	public JButton getBtMenuPrincipal() {
		if(btMenuPrincipal == null){
			btMenuPrincipal = new JButton("Voltar");
			
			btMenuPrincipal.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					listener.voltarRelatorio2();
				}
			});
		}
		return btMenuPrincipal;
	}
	
	public JLabel getLbCidadeData() {
	    String s = to.getData().toString();  
	    String[] t = s.split (Pattern.quote ("-"));  
	    String aux = t[2] + " / " + t[1] + " / " + t[0] ;
		lbCidadeData = new JLabel("" + to.getOrigem() + " , " + aux);
		return lbCidadeData;
	}
	
	public JScrollPane getScroll() {
		if(scroll == null){
			scroll = new JScrollPane(getTable());
		}
		return scroll;
	}
	public JTable getTable() {
		if(table == null){
			table = new JTable();
			table.setEnabled(false);
			table.setModel(getModel());
		}
		return table;
	}
	
	public DefaultTableModel getModel() {
		if(model == null){
			model = new DefaultTableModel(){
				
				private static final long serialVersionUID = 1L;

				@Override
				public int getColumnCount() {
					return cabecalho.length;
				}
				
				@Override
				public Class<String> getColumnClass(int columnIndex) {
					return String.class;
				}
				
				@Override
				public int getRowCount() {
					return listaInstituicoesAlunos.size();  
				}
				
				public Object getValueAt(int row, int column) {
					Relatorio2TO to = listaInstituicoesAlunos.get(row);
					if(column == 0){
						return to.getNome();
					}else if(column == 1){
						return to.getQtde();
					}else{
						return "ERRO";
					}
				};
				
				public String getColumnName(int column) {
					return cabecalho[column];
				};
				
				@Override
				public boolean isCellEditable(int arg0, int arg1) {
					return false;
				}
			};
			
		}
		return model;
	}
		public void setListaContatos(List<Relatorio2TO> listaInstituicoesAlunos) {
			this.listaInstituicoesAlunos = listaInstituicoesAlunos;
			
			getModel().fireTableDataChanged();
		}
		public JLabel getLbTitulo() {
			lbTitulo = new JLabel("Prefeitura Municipal de " + to.getOrigem());
			lbTitulo.setFont(new Font("Serif",Font.BOLD,20));
			return lbTitulo;
		}

		public JLabel getLbComprovante() {
			lbComprovante = new JLabel("                                        Relatório de Viagem");
			return lbComprovante;
		}
		
		public JLabel getLbMotorista() {
			lbMotorista = new JLabel("Motorista : " + to.getNome());
			return lbMotorista;
		}
		public JLabel getLbTrajeto() {
			lbTrajeto = new JLabel("Trajeto : " + to.getOrigem() + " / " + to.getDestino());
			return lbTrajeto;
		}
		public JLabel getLbObjetivo() {
			lbObjetivo = new JLabel("Objetivo da viagem : Transporte de Alunos Universitários");
			return lbObjetivo;
		}
		public JLabel getLbQtde() {
			if(lbQtde == null){
				lbQtde = new JLabel("Lugares ocupados : " + to.getQtde());
				lbQtde.setFont(new Font("Serif",Font.BOLD,14));
			}
			return lbQtde;
		}
		public JLabel getLbCapacidade() {
			if(lbCapacidade == null){
				lbCapacidade = new JLabel("Capacidade : 44");
			}
			return lbCapacidade;
		}	
		public JLabel getLbLugaresVazios() {
			if(lbLugaresVazios == null){
				lbLugaresVazios = new JLabel("Quantidade de lugares vazios : " + (44-to.getQtde()));
				lbLugaresVazios.setFont(new Font("Serif", Font.BOLD, 15));
			}
			return lbLugaresVazios;
		}
	
}
