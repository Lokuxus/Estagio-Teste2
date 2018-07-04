package view;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import controller.DBancoController;
import controller.ValidacaoController;
import model.Pessoa;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JCheckBox;


public class GerenciaView extends JFrame {

	/**
	 * 
	 */
	private JPanel contentPane;
	private JTextField nomeTextField;
	private JTextField cpfTextField;
	private JTextField telefoneTextField;
	private JTextField emailTextField;
	private JTextField localidadeTextField;
	private JTextField logradouroTextField;
	private JFormattedTextField cepFTextField;
	private JTextField ufTextField;
	private JTextField numeroTextField;
	private JTextField complementoTextField;
	private JTextField bairroTextField;
	private JTextArea txtrObserv;
	private JTable pessoasTable;
	private String cpfatual;
	private DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciaView frame = new GerenciaView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GerenciaView() {
		setTitle("Gerencia Sattra Teste 2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 1316, 714);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel cadastroPanel = new JPanel();
		cadastroPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		cadastroPanel.setBounds(0, 0, 1248, 677);
		contentPane.add(cadastroPanel);
		
		nomeTextField = new JTextField();
		nomeTextField.setBounds(151, 11, 610, 35);
		nomeTextField.setColumns(10);
		
		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setBounds(12, 51, 138, 31);
		
		telefoneTextField = new JTextField();
		telefoneTextField.setBounds(151, 84, 155, 35);
		telefoneTextField.setColumns(10);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(151, 121, 610, 35);
		emailTextField.setColumns(10);
		
		JLabel lblCEP = new JLabel("CEP");
		lblCEP.setBounds(12, 165, 138, 26);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(12, 241, 138, 28);
		
		JLabel lblLocalidade = new JLabel("Localidade");
		lblLocalidade.setBounds(12, 202, 138, 28);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(12, 311, 138, 26);
		
		complementoTextField = new JTextField();
		complementoTextField.setBounds(151, 344, 610, 35);
		complementoTextField.setColumns(10);
		
		ufTextField = new JTextField();
		ufTextField.setBounds(151, 381, 63, 34);
		ufTextField.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(12, 11, 138, 35);
		
		cpfTextField = new JTextField();
		cpfTextField.setBounds(151, 48, 155, 35);
		cpfTextField.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(12, 86, 138, 31);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(12, 123, 138, 31);
		
		bairroTextField = new JTextField();
		bairroTextField.setBounds(151, 233, 610, 35);
		bairroTextField.setColumns(10);
		
		localidadeTextField = new JTextField();
		localidadeTextField.setBounds(151, 195, 610, 35);
		localidadeTextField.setColumns(10);
		
		logradouroTextField = new JTextField();
		logradouroTextField.setBounds(151, 270, 610, 35);
		logradouroTextField.setColumns(10);
		
		JLabel lblLogradouro = new JLabel("Logradouro");
		lblLogradouro.setBounds(12, 274, 138, 26);
		
		numeroTextField = new JTextField();
		numeroTextField.setBounds(151, 307, 103, 34);
		numeroTextField.setColumns(10);
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setBounds(12, 348, 138, 26);
		
		txtrObserv = new JTextArea();
		txtrObserv.setBorder(nomeTextField.getBorder());
		txtrObserv.setBounds(813, 39, 425, 354);


		
		JLabel lblUf = new JLabel("UF");
		lblUf.setBounds(12, 385, 138, 26);
		cadastroPanel.setLayout(null);
		cadastroPanel.add(nomeTextField);
		cadastroPanel.add(lblCPF);
		cadastroPanel.add(telefoneTextField);
		cadastroPanel.add(emailTextField);
		cadastroPanel.add(lblCEP);
		cadastroPanel.add(lblBairro);
		cadastroPanel.add(lblLocalidade);
		cadastroPanel.add(lblNumero);
		cadastroPanel.add(complementoTextField);
		cadastroPanel.add(ufTextField);
		cadastroPanel.add(lblNome);
		cadastroPanel.add(cpfTextField);
		cadastroPanel.add(lblTelefone);
		cadastroPanel.add(lblEmail);
		cadastroPanel.add(bairroTextField);
		cadastroPanel.add(localidadeTextField);
		cadastroPanel.add(logradouroTextField);
		cadastroPanel.add(lblLogradouro);
		cadastroPanel.add(numeroTextField);
		cadastroPanel.add(lblComplemento);
		cadastroPanel.add(lblUf);
		cadastroPanel.add(txtrObserv);
		
		cepFTextField = new JFormattedTextField();
		cepFTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				try {
					ArrayList<String> dados = (ArrayList<String>) ValidacaoController.getDadosbyCEP(cepFTextField.getText());
					if(dados != null) {
					localidadeTextField.setText(dados.get(0));
					bairroTextField.setText(dados.get(1));
					logradouroTextField.setText(dados.get(2));
					
					if("".equals(complementoTextField.getText())) complementoTextField.setText(dados.get(3));
					
					ufTextField.setText(dados.get(4));
					}else {
						JOptionPane.showMessageDialog(null ,"CEP Invalido");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		cepFTextField.setBounds(151, 158, 75, 35);
		try {
			MaskFormatter formatter = new MaskFormatter("#####-###");
			formatter.setPlaceholderCharacter('_');
			cepFTextField.setFormatterFactory(new DefaultFormatterFactory(formatter));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cadastroPanel.add(cepFTextField);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!ValidacaoController.validarCPF(cpfTextField.getText())) {
					JOptionPane.showMessageDialog(null ,"CPF Invalido");
				}else if(!ValidacaoController.validaCEP(cepFTextField.getText())) {
					JOptionPane.showMessageDialog(null ,"CEP Invalido");
				}else {
					Pessoa pessoa = new Pessoa(nomeTextField.getText(),cpfTextField.getText(),
							telefoneTextField.getText(),emailTextField.getText(),cepFTextField.getText(),
							localidadeTextField.getText(),bairroTextField.getText(),logradouroTextField.getText(),
							numeroTextField.getText(),complementoTextField.getText(),ufTextField.getText(), txtrObserv.getText());
					
					try {
						DBancoController.cadastrarPessoa(pessoa);
						limparDados();
						atualizaTabela();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		});
		btnCadastrar.setBounds(12, 435, 147, 35);
		cadastroPanel.add(btnCadastrar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!ValidacaoController.validarCPF(cpfTextField.getText())) {
					JOptionPane.showMessageDialog(null ,"CPF Invalido");
				}else if(!ValidacaoController.validaCEP(cepFTextField.getText())) {
					JOptionPane.showMessageDialog(null ,"CEP Invalido");
				}else {
					Pessoa pessoa = new Pessoa(nomeTextField.getText(),cpfTextField.getText(),
							telefoneTextField.getText(),emailTextField.getText(),cepFTextField.getText(),
							localidadeTextField.getText(),bairroTextField.getText(),logradouroTextField.getText(),
							numeroTextField.getText(),complementoTextField.getText(),ufTextField.getText(), txtrObserv.getText());
					
					try {
						DBancoController.alterarPessoa(cpfatual, pessoa);
						
						btnSalvar.setVisible(false);
						btnCadastrar.setVisible(true);
						limparDados();
						atualizaTabela();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		btnSalvar.setBounds(12, 435, 147, 35);
		btnSalvar.setVisible(false);
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int linha = pessoasTable.getSelectedRow();
				ArrayList<String> dadosLinha = new ArrayList<String>();
				if(linha != -1) {
					for (int i = 0; i < 12; i++) {
						dadosLinha.add(pessoasTable.getValueAt(linha, i).toString());
					}
					cpfatual = dadosLinha.get(1);
					nomeTextField.setText(dadosLinha.get(0));
					cpfTextField.setText(dadosLinha.get(1));
					telefoneTextField.setText(dadosLinha.get(2));
					emailTextField.setText(dadosLinha.get(3));
					cepFTextField.setText(dadosLinha.get(4));
					localidadeTextField.setText(dadosLinha.get(5));
					bairroTextField.setText(dadosLinha.get(6));
					logradouroTextField.setText(dadosLinha.get(7));
					numeroTextField.setText(dadosLinha.get(8));
					complementoTextField.setText(dadosLinha.get(9));
					ufTextField.setText(dadosLinha.get(10));
					txtrObserv.setText(dadosLinha.get(11));
					
					btnCadastrar.setVisible(false);
					btnSalvar.setVisible(true);
					
				}
			}
		});
		btnEditar.setBounds(199, 435, 147, 35);
		cadastroPanel.add(btnEditar);
		
		JLabel lblObservaes = new JLabel("Observa\u00E7\u00F5es");
		lblObservaes.setBounds(813, 11, 186, 14);
		cadastroPanel.add(lblObservaes);		
		
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		pessoasTable = new JTable(DBancoController.getlistaPessoas());
		pessoasTable.setFont(new Font("Tahoma", Font.PLAIN, 11));
		for (int i = 0; i < pessoasTable.getColumnCount(); i++) {
		pessoasTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
		pessoasTable.setAutoCreateRowSorter(true);
		pessoasTable.setFillsViewportHeight(true);
		pessoasTable.setBounds(12, 508, 1199, 146);
		
		JScrollPane tabelaScrollPane = new JScrollPane(pessoasTable);
		tabelaScrollPane.setBounds(12, 492, 1226, 174);
		cadastroPanel.add(tabelaScrollPane);
		

		cadastroPanel.add(btnSalvar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int linha = pessoasTable.getSelectedRow();
				if(linha != -1) {
					if(JOptionPane.showConfirmDialog(null, "Deseja realmente excluir "+pessoasTable.getValueAt(linha, 0).toString()
							+"? ", "Cofirmar Exclusão", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
						DBancoController.excluirPessoa(pessoasTable.getValueAt(linha, 1).toString());
				}
				atualizaTabela();
			}
		});
		btnExcluir.setBounds(369, 435, 147, 35);
		cadastroPanel.add(btnExcluir);
		
		JScrollPane obsScrollPane = new JScrollPane(txtrObserv);
		obsScrollPane.setBounds(813, 39, 425, 354);
		cadastroPanel.add(obsScrollPane);
		
		JButton btnExportar = new JButton("Exportar");
		btnExportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DBancoController.exportarDados();
			}
		});
		btnExportar.setBounds(1039, 435, 147, 35);
		cadastroPanel.add(btnExportar);
		
		JCheckBox chckbxFiltrar = new JCheckBox("Filtrar");
		chckbxFiltrar.setBounds(538, 441, 63, 23);
		cadastroPanel.add(chckbxFiltrar);
		
		JButton btnAtualizarLista = new JButton("Atualizar Lista");
		btnAtualizarLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxFiltrar.isSelected()) {
					String valor;
					int escolha = JOptionPane.showInternalOptionDialog(contentPane, "Escolha qual opção de filtro deseja: ",
							"Filtrar Lista", JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE, null,
							new Object[] {"CPF","CEP","UF"}, null);
					
					switch (escolha) {
					case 0:
						valor = JOptionPane.showInputDialog(contentPane, "Insira o CPF que deseja buscar", "Digite o CPF", JOptionPane.QUESTION_MESSAGE);
						if(!ValidacaoController.validarCPF(valor)) {
							JOptionPane.showMessageDialog(null ,"CPF Invalido");
							}else {
								atualizaTabelaFiltro(escolha, valor);
							}
						break;
					case 1:
						valor = JOptionPane.showInputDialog(contentPane, "Insira o CEP que deseja buscar", "Digite o CEP", JOptionPane.QUESTION_MESSAGE);
						if(!ValidacaoController.validaCEP(valor)) {
							JOptionPane.showMessageDialog(null ,"CEP Invalido");
							}else {
								atualizaTabelaFiltro(escolha, valor);
							}
						break;
					case 2:
						valor = JOptionPane.showInputDialog(contentPane, "Insira o CEP que deseja buscar", "Digite o CEP", JOptionPane.QUESTION_MESSAGE);
						atualizaTabelaFiltro(escolha, valor);
						break;	
					default:
						break;
					}
					
				}else {
					atualizaTabela();
				}
			}
		});
		btnAtualizarLista.setBounds(607, 435, 147, 35);
		cadastroPanel.add(btnAtualizarLista);
		
		
		
//		cadastroPanel.add(pessoasTable);
		

		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
	}
	
	private void atualizaTabela() {
		pessoasTable.setModel(DBancoController.getlistaPessoas());
		for (int i = 0; i < pessoasTable.getColumnCount(); i++) {
		pessoasTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
	}
	
	private void atualizaTabelaFiltro(int opcao, String dado) {
		pessoasTable.setModel(DBancoController.filtraPessoas(opcao,dado));
		for (int i = 0; i < pessoasTable.getColumnCount(); i++) {
		pessoasTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
	}
	
	private void limparDados() {
		
		nomeTextField.setText("");
		cpfTextField.setText("");
		telefoneTextField.setText("");
		emailTextField.setText("");
		cepFTextField.setText("");
		localidadeTextField.setText("");
		bairroTextField.setText("");
		logradouroTextField.setText("");
		numeroTextField.setText("");
		complementoTextField.setText("");
		ufTextField.setText("");
		txtrObserv.setText("");
	}
}
