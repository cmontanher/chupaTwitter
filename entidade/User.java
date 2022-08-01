package entidade;

import java.util.ArrayList;

public class User {

	private String nome;
	private String email;
	private String cpf;
	private String conta;
	private ArrayList<Pruu> mensagens;
		
	
	public User() {
		super();
	}

	public User(String nome, String email, String cpf) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.conta = "@" + this.nome;
	}
	
	public void darLike(Pruu curtirMsg) {
		curtirMsg.adicionarLike();
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}
	
	public String getConta() {
		return conta;
	}

	public ArrayList<Pruu> getmensagens() {
		return mensagens;
	}

	public void setmensagens(ArrayList<Pruu> mensagens) {
		this.mensagens = mensagens;
	}

	@Override
	public String toString() {
		return conta;
	}
	
}