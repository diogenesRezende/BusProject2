package br.edu.univas.si4.lab4.busProject2.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.edu.univas.si4.lab4.busProject2.model.InstituicaoTO;
import br.edu.univas.si4.lab4.busProject2.view.listener.FrameListarInstituicaoListener;

public class FrameListarInstituicao extends JFrame {


	private static final long serialVersionUID = 1L;

	private FrameListarInstituicaoListener listener;
	
	private JTable table;
	private DefaultTableModel model;
	private List<InstituicaoTO> listaInstituicoes = new ArrayList<InstituicaoTO>();
	private String[] cabecalho = new String[] {"Nome", "Telefone" , "Email"};
	
	private JButton btDeletar;
	private JButton btMenuPrincipal;
	
	private JPanel painelBotoes;
	private JScrollPane scroll;
	
	public FrameListarInstituicao(FrameListarInstituicaoListener listener) {
		this.listener = listener;
		init();
	}

	private void init() {
		setSize(600,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container panel = getContentPane();
		
		setTitle("Listar Instituição");
		
		BorderLayout layout = new BorderLayout();
		panel.setLayout(layout);
		
		panel.add(getScroll(), BorderLayout.CENTER);
		panel.add(getPainelBotoes(), BorderLayout.SOUTH);
	}
	private JPanel getPainelBotoes() {
		if(painelBotoes == null){
			painelBotoes = new JPanel();
			painelBotoes.add(getBtDeletar());
			painelBotoes.add(getBtMenuPrincipal());
		}
		return painelBotoes;
	}
	
	public JButton getBtDeletar() {
		if(btDeletar == null){
			btDeletar = new JButton("Deletar");
			
			btDeletar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int index = getTable().getSelectedRow();
					if(index != -1){
						InstituicaoTO instituicao = listaInstituicoes.get(index);
						if(instituicao != null){
							listener.remover(instituicao);
						}
					}
				}
			});
		}
		return btDeletar;
	}
	
	public JButton getBtMenuPrincipal() {
		if(btMenuPrincipal == null){
			btMenuPrincipal = new JButton("Menu Principal");
			
			btMenuPrincipal.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					listener.voltarListar();
				}
			});
		}
		return btMenuPrincipal;
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
			table.setEnabled(true);
			table.setModel(getModel());
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(e.getClickCount() == 2){
						int index = getTable().getSelectedRow();
						if(index != -1){
							InstituicaoTO instituicao = listaInstituicoes.get(index);
							if(instituicao != null){
								listener.mostrarEditarInstituicao(instituicao);
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
					return listaInstituicoes.size();  
				}
				
				public Object getValueAt(int row, int column) {
					InstituicaoTO to = listaInstituicoes.get(row);
					if(column == 0){
						return to.getNome();
					}else if(column == 1){
						return to.getTelefone();
					} else if(column == 2){
						return to.getEmail();
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
		public void setListaContatos(List<InstituicaoTO> listaInstituicoes) {
			this.listaInstituicoes = listaInstituicoes;
			
			getModel().fireTableDataChanged();
		}
}
