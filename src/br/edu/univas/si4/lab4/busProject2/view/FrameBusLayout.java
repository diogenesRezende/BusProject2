package br.edu.univas.si4.lab4.busProject2.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.edu.univas.si4.lab4.busProject2.model.MotoristaTO;
import br.edu.univas.si4.lab4.busProject2.model.ViagemTO;
import br.edu.univas.si4.lab4.busProject2.view.listener.FrameBusLayoutListener;

public class FrameBusLayout extends JFrame {
	
	
	private static final long serialVersionUID = 1L;
	
	FrameBusLayoutListener listener ;
	
	String[] cidade ={"Selecione","Congonhal","Bom Repouso","Pouso Alegre"};
	
	private JPanel painelBtDir;
	private JPanel painelBtEsq;
	private JPanel painelBtInferior;
	private JPanel painelLbCB;
	
	private JButton btPassageiros;
	private JButton btMenuPrincipal;
	private JButton btSalvar;
	
	private JLabel motorista = new JLabel("Motorista:");
	private JComboBox cbMotorista;
	
	private JLabel lbOrigem = new JLabel("Cidade Origem:");
	private JComboBox<String> cbOrigem;
	
	private JLabel lbDestino = new JLabel("Cidade Destino:");
	private JComboBox<String> cbDestino;
	
	private JButton bt1;
	private JButton bt2;
	private JButton bt3;
	private JButton bt4;
	private JButton bt5;
	private JButton bt6;
	private JButton bt7;
	private JButton bt8;
	private JButton bt9;
	private JButton bt10;
	private JButton bt11;
	private JButton bt12;
	private JButton bt13;
	private JButton bt14;
	private JButton bt15;
	private JButton bt16;
	private JButton bt17;
	private JButton bt18;
	private JButton bt19;
	private JButton bt20;
	private JButton bt21;
	private JButton bt22;
	private JButton bt23;
	private JButton bt24;
	private JButton bt25;
	private JButton bt26;
	private JButton bt27;
	private JButton bt28;
	private JButton bt29;
	private JButton bt30;
	private JButton bt31;
	private JButton bt32;
	private JButton bt33;
	private JButton bt34;
	private JButton bt35;
	private JButton bt36;
	private JButton bt37;
	private JButton bt38;
	private JButton bt39;
	private JButton bt40;
	private JButton bt41;
	private JButton bt42;
	private JButton bt43;
	private JButton bt44;

	
	
	
	public FrameBusLayout(FrameBusLayoutListener listener) {
		this.listener= listener;
		init();
	}
	
	private void init() {
		
		Container panel = getContentPane();
		
		setSize (500, 700);
		setTitle("Onibus");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		panel.setLayout(new BorderLayout());
		
		panel.add(getPainelBtInferior(),BorderLayout.SOUTH);
		panel.add(getPainelLbCB(),BorderLayout.NORTH);
		panel.add(getPaineBtDir(), BorderLayout.EAST);
		panel.add(getPaineBtEsq(), BorderLayout.WEST);
		

	}
	
	public JPanel getPaineBtDir() {
		if(painelBtDir==null){
			painelBtDir = new JPanel();
			
			painelBtDir.setLayout(new GridLayout(11,2,5,5));
			
			
			painelBtDir.add(getBt23());
			painelBtDir.add(getBt24());
			painelBtDir.add(getBt25());
			painelBtDir.add(getBt26());
			painelBtDir.add(getBt27());
			painelBtDir.add(getBt28());
			painelBtDir.add(getBt29());
			painelBtDir.add(getBt30());
			painelBtDir.add(getBt31());
			painelBtDir.add(getBt32());
			painelBtDir.add(getBt33());
			painelBtDir.add(getBt34());
			painelBtDir.add(getBt35());
			painelBtDir.add(getBt36());
			painelBtDir.add(getBt37());
			painelBtDir.add(getBt38());
			painelBtDir.add(getBt39());
			painelBtDir.add(getBt40());
			painelBtDir.add(getBt41());
			painelBtDir.add(getBt42());
			painelBtDir.add(getBt43());
			painelBtDir.add(getBt44());
		}
		
		return painelBtDir;
	}
	
	public JPanel getPaineBtEsq() {
		if(painelBtEsq==null){
			painelBtEsq = new JPanel();
			
			painelBtEsq.setLayout( new GridLayout(11,2,5,5));			
			
			painelBtEsq.add(getBt1());
			painelBtEsq.add(getBt2());
			painelBtEsq.add(getBt3());
			painelBtEsq.add(getBt4());
			painelBtEsq.add(getBt5());
			painelBtEsq.add(getBt6());
			painelBtEsq.add(getBt7());
			painelBtEsq.add(getBt8());
			painelBtEsq.add(getBt9());
			painelBtEsq.add(getBt10());
			painelBtEsq.add(getBt11());
			painelBtEsq.add(getBt12());
			painelBtEsq.add(getBt13());
			painelBtEsq.add(getBt14());
			painelBtEsq.add(getBt15());
			painelBtEsq.add(getBt16());
			painelBtEsq.add(getBt17());
			painelBtEsq.add(getBt18());
			painelBtEsq.add(getBt19());
			painelBtEsq.add(getBt20());
			painelBtEsq.add(getBt21());
			painelBtEsq.add(getBt22());
		}	
		return painelBtEsq;
	}
	
	public JPanel getPainelBtInferior() {
		if(painelBtInferior==null){
			painelBtInferior=new JPanel();
			painelBtInferior.setLayout(new GridBagLayout());
			painelBtInferior.add(getBtMenuPrincipal(),new GBC(3, 0));
			painelBtInferior.add(getBtSalvar(),new GBC(1, 0));
			
		}
		return painelBtInferior;
	}
	
	public JPanel getPainelLbCB() {
		if(painelLbCB==null){
			painelLbCB = new JPanel();
			
			painelLbCB.setLayout(new GridBagLayout());
			painelLbCB.add(motorista, new GBC(0, 0));
			painelLbCB.add(getCbMotorista(),new GBC(0, 1));
			painelLbCB.add(lbOrigem,new GBC(2, 0));
			painelLbCB.add(getCbOrigem(),new GBC(2, 1));
			painelLbCB.add(lbDestino,new GBC(4, 0));
			painelLbCB.add(getCbDestino(),new GBC(4, 1));
			
			
			
		}
		return painelLbCB;
	}
	
	public JButton getBotoes(int i) {
		String name = Integer.toString(i);
		btPassageiros = new JButton(name);
		btPassageiros.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btPassageiros.setBackground(Color.RED);
				listener.tratarBtPassageiro();
				
			}
		});
		return btPassageiros;
	}
	
	public JButton getBtMenuPrincipal() {
		if(btMenuPrincipal==null){
			btMenuPrincipal=new JButton("Menu Principal");
			
			btMenuPrincipal.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					listener.voltarListar();
					
				}
			});
		}
		return btMenuPrincipal;
	}
	public JButton getBtSalvar() {
		if(btSalvar==null){
			btSalvar=new JButton("Salvar");
			btSalvar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					tratarBlBtSalvar();			
					
				}
			});
		}
		return btSalvar;
	}
	
	public JComboBox getCbMotorista() {
			ArrayList<MotoristaTO> vetor = new ArrayList<MotoristaTO>();
			vetor = listener.getListMotorista();
			cbMotorista= new JComboBox();
			cbMotorista.addItem("Selecione");
			for(int i=0;i<vetor.size();i++){
				cbMotorista.addItem(vetor.get(i));
				
			}
		
		return cbMotorista;
	}
	
	public JComboBox<String> getCbDestino() {
		if(cbDestino==null){
			cbDestino = new JComboBox<String>(cidade);
		}		
		return cbDestino;
	}
	
	public JComboBox<String> getCbOrigem() {
		if(cbOrigem==null){
			cbOrigem = new JComboBox<String>(cidade);
		}
		return cbOrigem;
	}
	
	private void tratarBlBtSalvar(){
		ViagemTO to = new ViagemTO();
		MotoristaTO motorista = new MotoristaTO();
		
		motorista=(MotoristaTO)cbMotorista.getSelectedItem();
		to.setId_motorista(motorista.getId());	
		to.setDestino(cidade[cbDestino.getSelectedIndex()]);
		to.setOrigem(cidade[cbOrigem.getSelectedIndex()]);
		
		listener.tratarBlBtSalvar(to);
		
	}
	
	public JButton getBt1() {
		if(bt1 == null){
			bt1 = new JButton("1");
			bt1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt1.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt1.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt1;
	}

	public JButton getBt2() {
		if(bt2 == null){
			bt2 = new JButton("2");
			bt2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt2.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt2.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt2;
	}
	public JButton getBt3() {
		if(bt3 == null){
			bt3 = new JButton("3");
			bt3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt3.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt3.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt3;
	}
	public JButton getBt4() {
		if(bt4 == null){
			bt4 = new JButton("4");
			bt4.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt4.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt4.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt4;
	}
	public JButton getBt5() {
		if(bt5 == null){
			bt5 = new JButton("5");
			bt5.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt5.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt5.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt5;
	}
	public JButton getBt6() {
		if(bt6 == null){
			bt6 = new JButton("6");
			bt6.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt6.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt6.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt6;
	}
	public JButton getBt7() {
		if(bt7 == null){
			bt7 = new JButton("7");
			bt7.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt7.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt7.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt7;
	}
	public JButton getBt8() {
		if(bt8 == null){
			bt8 = new JButton("8");
			bt8.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt8.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt8.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt8;
	}
	public JButton getBt9() {
		if(bt9 == null){
			bt9 = new JButton("9");
			bt9.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt9.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt9.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt9;
	}
	public JButton getBt10() {
		if(bt10 == null){
			bt10 = new JButton("10");
			bt10.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt10.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt10.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt10;
	}
	public JButton getBt11() {
		if(bt11 == null){
			bt11 = new JButton("11");
			bt11.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt11.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt11.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt11;
	}
	public JButton getBt12() {
		if(bt12 == null){
			bt12 = new JButton("12");
			bt12.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt12.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt12.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt12;
	}
	public JButton getBt13() {
		if(bt13 == null){
			bt13 = new JButton("13");
			bt13.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt13.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt13.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt13;
	}
	public JButton getBt14() {
		if(bt14 == null){
			bt14 = new JButton("14");
			bt14.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt14.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt14.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt14;
	}
	public JButton getBt15() {
		if(bt15 == null){
			bt15 = new JButton("15");
			bt15.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt15.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt15.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt15;
	}
	public JButton getBt16() {
		if(bt16 == null){
			bt16 = new JButton("16");
			bt16.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt16.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt16.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt16;
	}
	public JButton getBt17() {
		if(bt17 == null){
			bt17 = new JButton("17");
			bt17.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt17.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt17.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt17;
	}
	public JButton getBt18() {
		if(bt18 == null){
			bt18 = new JButton("18");
			bt18.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt18.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt18.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt18;
	}
	public JButton getBt19() {
		if(bt19 == null){
			bt19 = new JButton("19");
			bt19.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt19.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt19.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt19;
	}
	public JButton getBt20() {
		if(bt20 == null){
			bt20 = new JButton("20");
			bt20.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt20.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt20.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt20;
	}
	public JButton getBt21() {
		if(bt21 == null){
			bt21 = new JButton("21");
			bt21.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt21.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt21.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt21;
	}
	public JButton getBt22() {
		if(bt22 == null){
			bt22 = new JButton("22");
			bt22.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt22.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt22.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt22;
	}
	public JButton getBt23() {
		if(bt23 == null){
			bt23 = new JButton("23");
			bt23.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt23.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt23.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt23;
	}
	public JButton getBt24() {
		if(bt24 == null){
			bt24 = new JButton("24");
			bt24.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt24.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt24.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt24;
	}
	public JButton getBt25() {
		if(bt25 == null){
			bt25 = new JButton("25");
			bt25.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt25.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt25.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt25;
	}
	public JButton getBt26() {
		if(bt26 == null){
			bt26 = new JButton("26");
			bt26.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt26.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt26.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt26;
	}
	public JButton getBt27() {
		if(bt27 == null){
			bt27 = new JButton("27");
			bt27.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt27.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt27.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt27;
	}
	public JButton getBt28() {
		if(bt28 == null){
			bt28 = new JButton("28");
			bt28.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt28.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt28.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt28;
	}
	public JButton getBt29() {
		if(bt29 == null){
			bt29 = new JButton("29");
			bt29.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt29.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt29.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt29;
	}
	public JButton getBt30() {
		if(bt30 == null){
			bt30 = new JButton("30");
			bt30.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt30.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt30.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt30;
	}
	public JButton getBt31() {
		if(bt31 == null){
			bt31 = new JButton("31");
			bt31.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt31.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt31.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt31;
	}
	public JButton getBt32() {
		if(bt32 == null){
			bt32 = new JButton("32");
			bt32.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt32.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt32.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt32;
	}
	public JButton getBt33() {
		if(bt33 == null){
			bt33 = new JButton("33");
			bt33.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt33.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt33.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt33;
	}
	public JButton getBt34() {
		if(bt34 == null){
			bt34 = new JButton("34");
			bt34.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt34.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt34.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt34;
	}
	public JButton getBt35() {
		if(bt35 == null){
			bt35 = new JButton("35");
			bt35.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt35.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt35.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt35;
	}
	public JButton getBt36() {
		if(bt36 == null){
			bt36 = new JButton("36");
			bt36.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt36.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt36.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt36;
	}
	public JButton getBt37() {
		if(bt37 == null){
			bt37 = new JButton("37");
			bt37.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt37.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt37.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt37;
	}
	public JButton getBt38() {
		if(bt38 == null){
			bt38 = new JButton("38");
			bt38.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt38.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt38.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt38;
	}
	public JButton getBt39() {
		if(bt39 == null){
			bt39 = new JButton("39");
			bt39.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt39.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt39.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt39;
	}
	public JButton getBt40() {
		if(bt40 == null){
			bt40 = new JButton("40");
			bt40.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt40.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt40.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt40;
	}
	public JButton getBt41() {
		if(bt41 == null){
			bt41 = new JButton("41");
			bt41.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt41.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt41.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt41;
	}
	public JButton getBt42() {
		if(bt42 == null){
			bt42 = new JButton("42");
			bt42.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt42.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt42.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt42;
	}
	public JButton getBt43() {
		if(bt43 == null){
			bt43 = new JButton("43");
			bt43.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt43.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt43.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt43;
	}
	public JButton getBt44() {
		if(bt44 == null){
			bt44 = new JButton("44");
			bt44.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt44.getBackground() == Color.red){
						JOptionPane.showMessageDialog(null, "Lugar já ocupado !", "Erro!", 0);
					} else {
						listener.tratarBtPassageiro();
						bt44.setBackground(Color.red);
						
					}
					
				}
			});
		}
		return bt44;
	}
	
}
