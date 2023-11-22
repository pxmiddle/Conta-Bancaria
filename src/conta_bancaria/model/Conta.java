package conta_bancaria.model;

public abstract class Conta {

	private int numeroConta;
	private int agencia;
	private int tipoConta;
	private String titular;
	private float saldo;

	public Conta(int numeroConta, int agencia, int tipoConta, String titular, float saldo) {
		this.numeroConta = numeroConta;
		this.agencia = agencia;
		this.tipoConta = tipoConta;
		this.titular = titular;
		this.saldo = saldo;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(int tipoConta) {
		this.tipoConta = tipoConta;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	
	public boolean sacarValor(float valor) {
		if(this.getSaldo() < valor) {
			System.out.println("\nSaldo insuficiente");
			return false;
		}
		this.setSaldo(this.getSaldo() - valor);
		return true;
	}
	
	public void depositarValor(float valor) {
		this.setSaldo(this.getSaldo() + valor);
	}
	
	
	
	public void visualizar() {

		String tipo = "";

		switch (this.tipoConta) {
		case 1 -> tipo = "Conta Corrente";
		case 2 -> tipo = "Conta Poupança";

		}

		System.out.println("\n\n****************************************");
		System.out.println("Dados da Conta");
		System.out.println("****************************************");
		System.out.println("Numero da conta: " + this.numeroConta);
		System.out.println("Agência: " + this.agencia);
		System.out.println("Tipo da conta: " + tipo);
		System.out.println("Titular da conta: " + this.titular);
		System.out.println("Saldo da conta: " + this.saldo);
	}
}
