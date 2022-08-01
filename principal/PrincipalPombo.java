package principal;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Iterator;

import entidade.Admin;
import entidade.Pruu;
import entidade.User;

public class PrincipalPombo {

	public static void main(String[] args) {

		ArrayList<Pruu> pruusFeed = new ArrayList();

		// primeiro usuário e suas publicações
		User carlos = new User("carlos", "carlos@internet", "1111111-11");
		Pruu carlosMsg01 = new Pruu("Minha primeira postagem", carlos);
		Pruu carlosMsg02 = new Pruu("Chupa Twitter", carlos); // mensagem que será bloqueada
		Pruu carlosMsg03 = new Pruu("Elon Musk é um fanfarrão", carlos);
		pruusFeed.add(carlosMsg01);
		pruusFeed.add(carlosMsg02);
		pruusFeed.add(carlosMsg03);

		ArrayList<Pruu> msgsCarlos = new ArrayList();
		carlos.setmensagens(msgsCarlos);
		msgsCarlos.add(carlosMsg01);
		msgsCarlos.add(carlosMsg02);
		msgsCarlos.add(carlosMsg03);

		//segundo usuário e suas publicações
		User antonio = new User("antonio", "antonio@internet", "2222222-22");
		Pruu antonioMsg01 = new Pruu("Minha primera mensagem ", antonio);
		Pruu antonioMsg02 = new Pruu(" ", antonio); // mensagem fora do padrão
		Pruu antonioMsg03 = new Pruu(" ", antonio); // mensagem fora do padrão

		// devido a falta de um metodo iterativo de entrada (digita e valida)
		// nessa simulação as mensagens fora de padrao de entrada serão incluidas no feed para
		// efeito de teste - num aplicativo real não deveriam ser incluídas

		pruusFeed.add(antonioMsg01);
		pruusFeed.add(antonioMsg02);
		pruusFeed.add(antonioMsg03);

		ArrayList<Pruu> msgsAntonio = new ArrayList();
		antonio.setmensagens(msgsAntonio);
		msgsAntonio.add(antonioMsg01);
		msgsAntonio.add(antonioMsg02);
		msgsAntonio.add(antonioMsg03);

		// likes
		carlos.darLike(antonioMsg01);
		carlos.darLike(antonioMsg02);
		for (int i = 0; i < 100; i++) {
			antonio.darLike(carlosMsg03);
		}

		// usuário pika das galaxias
		User darthVader = new Admin("vader", "vader@estrelaDaMorte", "666");

		// admin bloqueia mensagem
		((Admin) darthVader).bloquearPruu(carlosMsg02);

		// laço para consultar todas as mensagens
		System.out.println("-----------------------");
		System.out.println("CONSULTA TODOS OS PRUUS");
		System.out.println("-----------------------");
		for (int i = 0; i < pruusFeed.size(); i++) {
			System.out.println(pruusFeed.get(i));
			System.out.println("-----------------------");
		}
		System.out.println(">> FIM DA LISTAGEM DE TODOS OS PRUUs <<");
		System.out.println("");

		// laço para consultar as mensagens do Carlos
		System.out.println("---------------------");
		System.out.println("EXIBINDO PRUUS CARLOS");
		System.out.println("---------------------");
		for (int i = 0; i < msgsCarlos.size(); i++) {
			System.out.println(msgsCarlos.get(i));
		}
		System.out.println(">> FIM DAS MSGS DO CARLOS");
		System.out.println("");

		// laço para consultar as mensagens do Antonio
		System.out.println("----------------------");
		System.out.println("EXIBINDO PRUUS ANTONIO");
		System.out.println("----------------------");
		for (int i = 0; i < msgsAntonio.size(); i++) {
			System.out.println(msgsAntonio.get(i));
		}
		System.out.println(">> FIM DAS MSGS DO ANTONIO");
		System.out.println("");
	}
}