package model;

public class Pessoa {
	
	private int ID = 0;

	private String nome = null;
	private String cpf = null;
	private String telefone = null;
	private String email = null;
	private String cep;
	private String localidade = null;
	private String bairro = null;
	private String logradouro = null;
	private String numero = null;
	private String complemento = null;
	private String uf = null;
	private String observacao = null;
	
	public Pessoa() {
		
	}
	
	public Pessoa(String nome, String cpf, String telefone, String email, String cep, String localidade,
			String bairro, String logradouro, String numero, String complemento, String uf, String observacao) {

		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.cep = cep;
		this.localidade = localidade;
		this.bairro = bairro;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.uf = uf;
		this.observacao = observacao;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLocalidade() {
		return localidade;
	}
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	

}
