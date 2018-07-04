package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZonedDateTime;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import model.Pessoa;

public class DBancoController {
	private static String endereco = "jdbc:mariadb://localhost:3306/sattra2"; 
	private static String[] colunasTabela = {"Nome","CPF","Telefone", "Email", "CEP", "Localidade", "Bairro", 
			"Logradouro", "Numero", "Complemento", "UF", "Observacoes"};
	
	private static Connection getConexao() {
		
		Connection conexao;
		try {
			conexao = DriverManager.getConnection(endereco, "root", "123456");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null ,"Não foi possivel se conectar ao banco");
			return null;
		}
		
		return conexao;
		
	}

	public static boolean cadastrarPessoa(Pessoa pessoa) throws SQLException {
		Connection conexao = getConexao();
		
		if(conexao == null) return false;
		
		PreparedStatement statement = conexao.prepareStatement("INSERT INTO pessoa (nome, cpf, telefone, email, cep, localidade,"
				+ "bairro, logradouro, numero, complemento, uf, observacoes) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		
		statement.setString(1,pessoa.getNome());
		statement.setString(2,pessoa.getCpf());
		statement.setString(3,pessoa.getTelefone());
		statement.setString(4,pessoa.getEmail());
		statement.setString(5,pessoa.getCep());
		statement.setString(6,pessoa.getLocalidade());
		statement.setString(7,pessoa.getBairro());
		statement.setString(8,pessoa.getLogradouro());
		statement.setString(9,pessoa.getNumero());
		statement.setString(10,pessoa.getComplemento());
		statement.setString(11,pessoa.getUf());
		statement.setString(12,pessoa.getObservacao());
		statement.execute();
		statement.close();
		conexao.close();
		
		return true;
	}
	
	public static DefaultTableModel getlistaPessoas() {
		DefaultTableModel modeloTabela = new DefaultTableModel(colunasTabela, 0);
		try {
			Connection conexao = getConexao();
			
			if(conexao == null) return null;
			
			PreparedStatement statement = conexao.prepareStatement("select * from pessoa;");
			ResultSet resultset = statement.executeQuery();

			while(resultset.next()) {
				modeloTabela.addRow(new Object[] {resultset.getString("nome"),resultset.getString("cpf"),resultset.getString("telefone"),
						resultset.getString("email"),resultset.getString("cep"),resultset.getString("localidade"),resultset.getString("bairro"),
						resultset.getString("logradouro"),resultset.getString("numero"),resultset.getString("complemento"),resultset.getString("uf"),
						resultset.getString("observacoes")});
				
			}
			
			return modeloTabela;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	public static boolean exportarDados() {
		
		try {
			Connection conexao = getConexao();
			
			if(conexao == null) return false;
			
			String nomeArquivo = ZonedDateTime.now().toString();
			nomeArquivo = nomeArquivo.replaceAll("/", "-");
			nomeArquivo = nomeArquivo.replaceAll(":", "-");
			System.out.println(nomeArquivo);
			File arquivo = new File("Arquivos Exportados/"+ nomeArquivo + ".txt");
			if(!arquivo.exists()) arquivo.createNewFile();
			FileWriter fileWriter = new FileWriter(arquivo, true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			PrintWriter printWriter = new PrintWriter(bufferedWriter, true);
			
			PreparedStatement statement = conexao.prepareStatement("select * from pessoa;");
			ResultSet resultset = statement.executeQuery();
			StringBuilder stringLinha = new StringBuilder();
			while(resultset.next()) {
				stringLinha.append(resultset.getString("nome"));
				stringLinha.append('#');
				stringLinha.append(resultset.getString("cpf"));
				stringLinha.append('#');
				stringLinha.append(resultset.getString("telefone"));
				stringLinha.append('#');
				stringLinha.append(	resultset.getString("email"));
				stringLinha.append('#');
				stringLinha.append(	resultset.getString("cep"));
				stringLinha.append('#');
				stringLinha.append(		resultset.getString("localidade"));
				stringLinha.append('#');
				stringLinha.append(resultset.getString("bairro"));
				stringLinha.append('#');
				stringLinha.append(resultset.getString("logradouro"));
				stringLinha.append('#');
				stringLinha.append(resultset.getString("numero"));
				stringLinha.append('#');
				stringLinha.append(	resultset.getString("complemento"));
				stringLinha.append('#');
				stringLinha.append(	resultset.getString("uf"));
				stringLinha.append('#');
				stringLinha.append(resultset.getString("observacoes"));
				printWriter.println(stringLinha);
				stringLinha.delete(0, stringLinha.length());
			}
			printWriter.close();
			bufferedWriter.close();
			fileWriter.close();
			}catch(Exception exception) {
				exception.printStackTrace();
				return false;
			}
		
		return true;
	}

	public static void alterarPessoa(String cpfatual, Pessoa pessoa) throws SQLException {
		Connection conexao = getConexao();
		
		PreparedStatement statement = conexao.prepareStatement("update pessoa set nome = ? , cpf = ? , telefone= ? , email = ?,"
				+ " cep = ?, localidade = ?, bairro = ?, logradouro = ?, numero = ?, complemento = ?, uf = ?, observacoes = ? "
				+ "where cpf = ?");
		
		statement.setString(1,pessoa.getNome());
		statement.setString(2,pessoa.getCpf());
		statement.setString(3,pessoa.getTelefone());
		statement.setString(4,pessoa.getEmail());
		statement.setString(5,pessoa.getCep());
		statement.setString(6,pessoa.getLocalidade());
		statement.setString(7,pessoa.getBairro());
		statement.setString(8,pessoa.getLogradouro());
		statement.setString(9,pessoa.getNumero());
		statement.setString(10,pessoa.getComplemento());
		statement.setString(11,pessoa.getUf());
		statement.setString(12,pessoa.getObservacao());
		statement.setString(13,cpfatual);
		statement.execute();
		statement.close();
		conexao.close();
		
	}

	public static void excluirPessoa(String cpf) {
		Connection conexao = getConexao();
		if(conexao != null) {
			try {
				PreparedStatement statement = conexao.prepareStatement("delete from pessoa where cpf = ?;");
				statement.setString(1, cpf);
				statement.execute();
				statement.close();
				conexao.close();
			} catch (SQLException e) {

				e.printStackTrace();
		}
		}
	}

	public static TableModel filtraPessoas(int opcao, String dado) {
		DefaultTableModel modeloTabela = new DefaultTableModel(colunasTabela, 0);
		try {
			PreparedStatement statement;
			Connection conexao = getConexao();
			
			if(conexao == null) return modeloTabela;
			
			switch (opcao) {
			case 0:
				statement = conexao.prepareStatement("select * from pessoa where cpf = ?;");
				statement.setString(1, dado);
				break;
			case 1:
				statement = conexao.prepareStatement("select * from pessoa where cep = ?;");
				if(dado.length() == 8) {
					StringBuilder stringbuilder = new StringBuilder();
					stringbuilder.append(dado.substring(0, 5));
					stringbuilder.append('-');
					stringbuilder.append(dado.substring(5));
					dado = stringbuilder.toString();
				}
				statement.setString(1, dado);
				break;
			case 2:
				statement = conexao.prepareStatement("select * from pessoa where uf = ?;");
				statement.setString(1, dado);
				break;
			default:
				statement = conexao.prepareStatement("select * from pessoa;");
				break;
			}

			ResultSet resultset = statement.executeQuery();

			while(resultset.next()) {
				modeloTabela.addRow(new Object[] {resultset.getString("nome"),resultset.getString("cpf"),resultset.getString("telefone"),
						resultset.getString("email"),resultset.getString("cep"),resultset.getString("localidade"),resultset.getString("bairro"),
						resultset.getString("logradouro"),resultset.getString("numero"),resultset.getString("complemento"),resultset.getString("uf"),
						resultset.getString("observacoes")});
				
			}
			
			return modeloTabela;
		} catch (SQLException e) {
			e.printStackTrace();
			return modeloTabela;
		}
		
	
	}
	
}
