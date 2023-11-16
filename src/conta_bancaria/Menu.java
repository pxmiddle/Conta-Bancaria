package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.util.Cores;
import conta_bancaria.util.Metodos;

public class Menu {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int opcao = 1;

		while (true) {

			System.out.println(Cores.RED_BOLD + Cores.BLACK_BACKGROUND);
			System.out.println();
			System.out.println("~-----------------------------------------------------------~");
			System.out.println("|                    Banco Novo(Antigo)                     |");
			System.out.println("~-----------------------------------------------------------~");
			System.out.println("|                                                           |");
			System.out.println("|                 1- Criar Conta                            |");
			System.out.println("|                 2- Listar todas as contas                 |");
			System.out.println("|                 3- Buscar Conta por Numero                |");
			System.out.println("|                 4- Atualizar Dados da conta               |");
			System.out.println("|                 5- Apagar Conta                           |");
			System.out.println("|                 6- Sacar                                  |");
			System.out.println("|                 7- Depositar                              |");
			System.out.println("|                 8- Transferir valores entre Contas        |");
			System.out.println("|                 9- Sair                                   |");
			System.out.println("|                                                           |");
			System.out.println("~-----------------------------------------------------------~");
			System.out.printf("   Entre com a opção desejada:                              ");
			opcao = sc.nextInt();

			if (opcao == 9) {
				Metodos.sair();
				sc.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1 -> Metodos.criarConta();
			case 2 -> Metodos.listarContas();
			case 3 -> Metodos.buscarConta();
			case 4 -> Metodos.atualizarConta();
			case 5 -> Metodos.apagarConta();
			case 6 -> Metodos.sacarValor();
			case 7 -> Metodos.depositarValor();
			case 8 -> Metodos.transferenciaContas();
			default -> System.out.println("Opção Inválida!");
			}

		}
	}

}
