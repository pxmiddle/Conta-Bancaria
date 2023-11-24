package conta_bancaria;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;
import conta_bancaria.util.Metodos;

public class Menu {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ContaController contas = new ContaController();

		int opcao = 1, numero, agencia, tipo, aniversario;
		String titular;
		float saldo;

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
			System.out.printf("   Entre com a opção desejada:                               ");
			System.out.println(Cores.RESET);
			try {
				opcao = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Digite valores inteiros.");
				sc.nextLine();
				opcao = 0;
			}
			if (opcao == 9) {
				Metodos.sair();
				sc.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1 -> {
				System.out.println("Numero da agência: ");
				agencia = sc.nextInt();
				System.out.println("Digite o nome do Titular: ");
				sc.skip("\\R");
				titular = sc.nextLine();
				System.out.println("Digite o Tipo da conta(1 - CC ou 2 - CP): ");
				tipo = sc.nextInt();

				System.out.println("Digite o saldo da conta: ");
				saldo = sc.nextFloat();

				switch (tipo) {
				case 1 -> contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo,
						contas.calcularLimite(saldo)));

				case 2 -> {
					System.out.println("Digite o Aniversário da conta: ");
					aniversario = sc.nextInt();
					contas.cadastrar(
							new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				}
				}
				contas.keyPress();
			}
			case 2 -> {
				contas.listarTodas();
				contas.keyPress();
			}
			case 3 -> {
				System.out.println("Digite o numero da conta: ");
				numero = sc.nextInt();
				contas.procurarPorNumero(numero);
				contas.keyPress();
			}
			case 4 -> {
				System.out.println("Digite o numero da conta: ");
				numero = sc.nextInt();

				Optional<Conta> conta = contas.buscarNaCollection(numero);

				if (conta.isPresent()) {

					System.out.println("Numero da agência: ");
					agencia = sc.nextInt();
					System.out.println("Digite o nome do Titular: ");
					sc.skip("\\R");
					titular = sc.nextLine();

					tipo = conta.get().getTipoConta();

					System.out.println("Digite o saldo da conta: ");
					saldo = sc.nextFloat();

					switch (tipo) {
					case 1 -> contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo,
							contas.calcularLimite(saldo)));

					case 2 -> {
						System.out.println("Digite o Aniversário da conta: ");
						aniversario = sc.nextInt();
						contas.atualizar(
								new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
					}
					}
				} else {
					System.out.println("A conta número: " + numero + " não foi encontrada");
				}

				contas.keyPress();
			}
			case 5 -> {
				System.out.println("Digite o numero da conta: ");
				numero = sc.nextInt();
				contas.deletar(numero);
				contas.keyPress();
			}
			case 6 -> {
				Metodos.sacarValor();
				contas.keyPress();
			}
			case 7 -> {
				Metodos.depositarValor();
				contas.keyPress();
			}
			case 8 -> {
				Metodos.transferenciaContas();
				contas.keyPress();
			}
			default -> {
				System.out.println("Opção Inválida!");
				contas.keyPress();
			}
			}

		}
	}

}
