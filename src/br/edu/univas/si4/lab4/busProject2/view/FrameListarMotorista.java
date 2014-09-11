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

import br.edu.univas.si4.lab4.busProject2.model.MotoristaTO;
import br.edu.univas.si4.lab4.busProject2.view.listener.FrameListarMotoristaListener;

public class FrameListarMotorista extends JFrame {

	private static final long serialVersionUID = 1L;

	private FrameListarMotoristaListener listener;
	
	private JTable table;
	private DefaultTableModel model;
	private List<MotoristaTO> listaMotoristas = new ArrayList<MotoristaTO>();
	private String[] cabecalho = new String[] {"Nome", "Celular"};
	
	private JButton btDeletar;
	private JButton btMenuPrincipal;
	
	private JPanel painelBotoes;
	private JScrollPane scroll;
	
	public FrameListarMotorista(FrameListarMotoristaListener listener) {
		this.listener = listener;
		init();
	}

	private void init() {
		setSize(600,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container panel = getContentPane();
		
		setTitle("Listar Motorista");
		
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
						MotoristaTO motorista = listaMotoristas.get(index);
						if(motorista != null){
							listener.remover(motorista);
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
							MotoristaTO motorista = listaMotoristas.get(index);
							if(motorista != null){
								listener.mostrarEditarMotorista(motorista);
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
					return listaMotoristas.size();  
				}
				
				public Object getValueAt(int row, int column) {
					MotoristaTO to = listaMotoristas.get(row);
					if(column == 0){
						return to.getNome();
					}else if(column == 1){
						return to.getCelular();
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
		public void setListaContatos(List<MotoristaTO> listaMotoristas) {
			this.listaMotoristas = listaMotoristas;
			
			getModel().fireTableDataChanged();
		}
		
}

