package entidade;

public class Admin extends User {

	public Admin() {
		super();
	}

	public Admin(String nome, String email, String cpf) {
		super(nome, email, cpf);
	}

	public void bloquearPruu(Pruu pruuParaBloquear) {
		pruuParaBloquear.setBloqueado(true);
	}

	public void desbloquearPruu(Pruu pruuParaDesbloquear) {
		pruuParaDesbloquear.setBloqueado(false);
	}
}