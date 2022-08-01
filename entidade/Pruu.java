package entidade;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Pruu {

	private static int id;
	private int idPruu;
	private User usuario;
	private String texto;
	private Date dataCriacao;
	private String dataFormatada;
	private int qtdLikes;
	private boolean bloqueado;
	private boolean textoValido = true;

	public Pruu() {
		super();
	}

	public Pruu(String texto, User usuario) {
		super();
		validarTexto(texto);
		if (textoValido == true) {
			this.texto = texto;
			this.usuario = usuario;
			this.dataCriacao = new Date();
			SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy");
			String dataFormatada = formatador.format(dataCriacao);
			this.dataFormatada = dataFormatada;
			Pruu.id++;
			idPruu = Pruu.id;
		} else if (textoValido == false) {
			this.texto = "MSG fora dos parametros (quantidade de caracteres). Entre nova mensagem";
			this.usuario = usuario;
			this.dataCriacao = new Date();
			SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy");
			String dataFormatada = formatador.format(dataCriacao);
			this.dataFormatada = dataFormatada;
			// nao vai incrementar os IDs tanto geral quanto do usuário
		}

	}
	
	// metodos

	public boolean validarTexto(String texto) {
		if ((texto.length() > 300) || (texto.trim().length() < 1)) {
			textoValido = false;
		}
		return textoValido;
	}

	public void adicionarLike() {
		this.qtdLikes++;
	}

	public int getId() {
		return id;
	}

	public String getTexto() {
		return texto;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public int getQtdLikes() {
		return qtdLikes;
	}

	public void setQtdLikes(int qtdLikes) {
		this.qtdLikes = qtdLikes;
	}

	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	public boolean isTextoValido() {
		return textoValido;
	}

	public void setTextoValido(boolean textoValido) {
		this.textoValido = textoValido;
	}

	@Override
	public String toString() {
		if (bloqueado) {
			return "\nID: " + idPruu + "\nPublicado por: " + usuario + " em " + dataFormatada
					+ "\n<< Essa msg foi bloqueado por descumprir as regras eticas do site >>" + "\n";
		} else {

			return "\nID: " + idPruu + "\nPublicado por: " + usuario + " em " + dataFormatada + "\nPruu: " + texto
					+ "\nCurtidas: " + qtdLikes + "\n";
		}
	}

}