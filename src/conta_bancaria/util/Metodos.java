package conta_bancaria.util;

import java.util.Scanner;

public class Metodos {
	static Scanner sc = new Scanner(System.in);

	public static void criarConta() {
		System.out.printf("Agência: ");
		String agencia = sc.nextLine();

		System.out.printf("\nNumero da Conta: ");
		int numConta = sc.nextInt();
		sc.skip("\\R");
		System.out.printf("\nNome: ");
		String nome = sc.nextLine();

		System.out.printf("\nNome: " + nome + " Agência: " + agencia + " Numero da Conta: " + numConta);
	}

	public static void listarContas() {
		System.out.println("Contas listadas :");
	}

	public static void buscarConta() {
		System.out.println("Contas listadas :");
	}

	public static void atualizarConta() {
		System.out.println("Contas listadas :");
	}

	public static void apagarConta() {
		System.out.println("Contas listadas :");
	}

	public static void sacarValor() {
		System.out.println("Contas listadas :");
	}

	public static void depositarValor() {
		System.out.println("Contas listadas :");
	}

	public static void transferenciaContas() {
		System.out.println("Contas listadas :");
	}
	public static void sair() {
		System.out.println("~-----------------------------------------------------------~");
		System.out.println("|                                                           |");
		System.out.println("|                    Banco Novo(Antigo)                     |");
		System.out.println("|                                                           |");
		System.out.println("~-----------------------------------------------------------~");
		System.out.println("|                                                           |");
		System.out.println("|Banco Novo(Antigo) o banco mais velho e inovador do planeta|");
		System.out.println("|                                                           |");
		System.out.println("|Desenvolvido por: Pablo                                    |");
		System.out.println("|github.com/pxmiddle                                        |");
		System.out.println("|                                                           |");
		System.out.println("~-----------------------------------------------------------~");
	}

}
