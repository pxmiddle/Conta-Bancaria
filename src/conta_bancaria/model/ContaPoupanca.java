package conta_bancaria.model;

public class ContaPoupanca extends Conta{
	
	private int aniversario;
	
	public ContaPoupanca(int numeroConta, int agencia, int tipoConta, String titular, float saldo, int aniversario) {
		super(numeroConta, agencia, tipoConta, titular, saldo);
		this.aniversario = aniversario;
	}

	public int getAniversario() {
		return aniversario;
	}

	public void setAniversario(int aniversario) {
		this.aniversario = aniversario;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Dia de aniversário: " + this.aniversario);
	}

}
