package conta_bancaria.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;
import conta_bancaria.util.Cores;

public class ContaController implements ContaRepository {

	// Criar Collection
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();

	// Variável para receber o número da conta
	int numero = 0;

	@Override
	public void procurarPorNumero(int numero) {

		Optional<Conta> conta = buscarNaCollection(numero);

		if (conta.isPresent()) {
			conta.get().visualizar();
		} else {
			System.out.println("A conta número: " + numero + " não foi encontrada!");
		}
	}
	
	public void procurarPorNome(String nome) {
		List<Conta> listaNomes = listaContas.stream()
				.filter(c -> c.getTitular().equalsIgnoreCase(nome))
				.collect(Collectors.toList());
		
		for(var conta : listaNomes)
			conta.visualizar();
	}

	@Override
	public void listarTodas() {
		if (listaContas.isEmpty()) {
			System.out.println("Não existem contas cadastradas.");
		}
		for (var conta : listaContas) {
			conta.visualizar();
		}
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("A conta: " + conta.getNumeroConta() + " foi cadastrada com Sucesso");
	}

	@Override
	public void atualizar(Conta conta) {

		Optional<Conta> buscaConta = buscarNaCollection(conta.getNumeroConta());

		if (buscaConta.isPresent()) {
			listaContas.set(listaContas.indexOf(buscaConta.get()), conta);
			System.out.println("A conta número: " + conta.getNumeroConta() + " foi Alterada com sucesso.");
		} else {
			System.out.println("A conta número: " + conta.getNumeroConta() + " não foi encontrada.");
		}

	}

	@Override
	public void deletar(int numero) {
		Optional<Conta> conta = buscarNaCollection(numero);

		if (conta.isPresent()) {
			if (listaContas.remove(conta.get()) == true) {
				System.out.println("A conta número: " + numero + " foi excluida com sucesso.");
			}

		} else {
			System.out.println("A conta número: " + numero + " não foi encontrada.");
		}

	}

	@Override
	public void sacar(int numero, float valor) {

		Optional<Conta> conta = buscarNaCollection(numero);

		if (conta.isPresent()) {
			if (conta.get().sacarValor(valor) == true) {
				System.out.println("O saque na conta número: " + numero + " foi efetuado com sucesso.");
			}

		} else {
			System.out.println("A conta número: " + numero + " não foi encontrada.");
		}

	}

	@Override
	public void depositar(int numero, float valor) {

		Optional<Conta> conta = buscarNaCollection(numero);

		if (conta.isPresent()) {
			conta.get().depositarValor(valor);
			System.out.println("O depósito na conta número: " + numero + " foi efetuado com sucesso.");
		} else {
			System.out.println("A conta número: " + numero + " não foi encontrada.");
		}
	}

	@Override
	public void tranferir(int numeroOrigem, int numeroDestino, float valor) {
		Optional<Conta> contaOrigem = buscarNaCollection(numeroOrigem);
		Optional<Conta> contaDestino = buscarNaCollection(numeroDestino);

		if (contaOrigem.isPresent() && contaDestino.isPresent()) {
			if (contaOrigem.get().sacarValor(valor) == true) {
				contaDestino.get().depositarValor(valor);
				System.out.println("Transação Realizada com sucesso!");
			}

		} else {
			System.out.println("A Conta de Origem e/ou Destino não foram encontradas!");
		}
	}

	// Métodos Auxiliares
	public int gerarNumero() {
		return ++numero;
	}

	public float calcularLimite(float saldo) {
		return saldo = saldo * 0.10f;
	}

	public Optional<Conta> buscarNaCollection(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumeroConta() == numero)
				return Optional.of(conta);
		}
		return Optional.empty();
	}

	public void keyPress() {
		try {
			System.out.println("\n\nPressione a tecla Enter para continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla inválida.");

		}
	}
	public void sair() {
		System.out.println(Cores.RED_BOLD + Cores.BLACK_BACKGROUND);
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
		System.out.println(Cores.RESET);
	}

}
