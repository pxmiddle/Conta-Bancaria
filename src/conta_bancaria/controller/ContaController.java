package conta_bancaria.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

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
		// TODO Auto-generated method stub

	}

	@Override
	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void tranferir(int numeroOrigem, int numeroDestino, float valor) {
		// TODO Auto-generated method stub

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

}
