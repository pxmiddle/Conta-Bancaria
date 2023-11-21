package conta_bancaria.model;

public class ContaCorrente extends Conta{

	private float limite;
	
	public ContaCorrente(int numeroConta, int agencia, int tipoConta, String titular, float saldo, float limite) {
		super(numeroConta, agencia, tipoConta, titular, saldo);
		this.limite = limite;
	}

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Limite da conta: " + this.limite);
	}
	
	@Override
	public boolean sacarValor(float valor) {
		if(this.getSaldo() + this.getLimite() < valor) {
			System.out.println("\nSaldo insuficiente");
			return false;
		}
		this.setSaldo(this.getSaldo() - valor);
		return true;
	}
}