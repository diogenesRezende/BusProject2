package br.edu.univas.si4.lab4.busProject2.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

import br.edu.univas.si4.lab4.busProject2.model.AlunoTO;
import br.edu.univas.si4.lab4.busProject2.model.Relatorio1TO;
import br.edu.univas.si4.lab4.busProject2.view.listener.FrameRelatorio1Listener;

public class FrameRelatorio1 extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JLabel lbTitulo;
	private JLabel lbComprovante;
	private JLabel lbMotorista;
	private JLabel lbTrajeto;
	private JLabel lbObjetivo;
	private JLabel lbCidadeData;
	
	private Relatorio1TO to;
	private JPanel pnSuperior;	
	private JPanel pnCentral;
	private JPanel pnInferior;
	
	private JButton btVoltar;
	
	private JTable table;
	private DefaultTableModel model;
	private List<AlunoTO> listaAlunos = new ArrayList<AlunoTO>();
	private String[] cabecalho = new String[] {"Nome"};
	private JScrollPane scroll;
	
	private FrameRelatorio1Listener listener;
	
	
	public FrameRelatorio1(FrameRelatorio1Listener listener) {
		this.listener = listener;
		init();
	}
	
	private void init() {
		 Container panel = getContentPane();
		 
		 setTitle("Comprovante de Viagem");
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setSize(729, 729);
		 setLocationRelativeTo(null);
		 
		 GridBagLayout layout = new GridBagLayout();
		 panel.setLayout(layout);
		 panel.add(getPnSuperior(),new GBC(0, 0).setSpan(1, 2));
		 panel.add(getPnCentral(),new GBC(0, 2).setSpan(1, 4));		
		 panel.add(getPnInferior(),new GBC(0, 6));
	}
	
	public JPanel getPnSuperior() {
		if(pnSuperior == null){
				pnSuperior = new JPanel();
				to = listener.getDadosRelatorio();
				GridBagLayout layout = new GridBagLayout();
				pnSuperior.setLayout(layout);
				
				pnSuperior.add(getLbTitulo(),new GBC(2, 0).setSpan(3, 1));
				
				pnSuperior.add(getLbComprovante(),new GBC(3, 2).setSpan(2, 1));
				
				pnSuperior.add(getLbMotorista(),new GBC(0, 4).setSpan(2, 1));
				
				pnSuperior.add(getLbTrajeto(),new GBC(0, 5).setSpan(3, 1));
				
				pnSuperior.add(getLbObjetivo(),new GBC(0, 6).setSpan(4, 1));
		}
		return pnSuperior;
	}
	
	public JPanel getPnCentral() {
		if(pnCentral==null){
			pnCentral = new JPanel();
			pnCentral.setLayout(new BorderLayout());
			pnCentral.add(getScroll());
		}		
		return pnCentral;
	}
	
	public JPanel getPnInferior() {
		if(pnInferior == null){
			pnInferior = new JPanel();
			pnInferior.setLayout(new GridBagLayout());
			pnInferior.add(getLbCidadeData(),new GBC(0, 0));
			pnInferior.add(getBtVoltar(),new GBC(0, 1));
		}
		return pnInferior;
	}
	
	public JButton getBtVoltar() {
		if(btVoltar==null){
			btVoltar = new JButton("Voltar");
			btVoltar.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					listener.voltarRelatorio1();
				}
			});
		}
		return btVoltar;
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
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(e.getClickCount() == 2){
						int index = getTable().getSelectedRow();
						if(index != -1){
							AlunoTO aluno = listaAlunos.get(index);
							if(aluno != null){
							}
						}
					}
				}
			});
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
					return listaAlunos.size();  
				}
				
				public Object getValueAt(int row, int column) {
					AlunoTO to = listaAlunos.get(row);
					if(column == 0){
						return to.getNome();
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
		public void setListaAlunos(List<AlunoTO> listaAlunos) {
			this.listaAlunos = listaAlunos;
			
			getModel().fireTableDataChanged();
		}

		public JLabel getLbTitulo() {
			if(lbTitulo == null){
				
				lbTitulo = new JLabel("Prefeitura Municipal de " + to.getOrigem());
				lbTitulo.setFont(new Font("Serif",Font.BOLD,20));
			}
			return lbTitulo;
		}

		public JLabel getLbComprovante() {
			lbComprovante = new JLabel("Relatório de Viagem");
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
		public JLabel getLbCidadeData() {
			String s = to.getData().toString();
			String[] t = s.split(Pattern.quote("-"));
			String aux = t[2] + " / " + t[1] + " / " + t[0];
			lbCidadeData = new JLabel("" + to.getOrigem() + " , " + aux);
			return lbCidadeData;
		}
	
	
}
