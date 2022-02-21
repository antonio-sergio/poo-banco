
public abstract class Conta implements iConta{
	private static final int AGENCIA_PADRAO = 1;
	private static int 	SEQUENCIAL = 1;
	
	protected int agencia;
	protected int numero;
	protected double saldo;
	
	private Cliente cliente;
	
	
	public Conta(Cliente cliente) {
		this.agencia = 	Conta.AGENCIA_PADRAO;
		this.numero = Conta.SEQUENCIAL++;
		this.cliente = cliente;
	}
	
	

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	@Override
	public void sacar(double valor) {
		if(saldo >= valor) {
			saldo -= valor;
		}
		else {
			System.out.println("Saldo insuficiente");
			System.out.println(String.format("Saldo atual: %.2f ", this.saldo));
		}
			
		
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
		
	}

	@Override
	public void transferir(double valor, Conta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
		imprimirComprovante(contaDestino, valor);
		
	}
	
	protected void imprimirInfosComuns() {
		System.out.println(String.format("Nome: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
		System.out.println();
	}
	
	protected void imprimirComprovante(Conta contaDestino, double valor) {
		System.out.println(String.format("Valor %.2f", valor));
		System.out.println("Transerido para: " + contaDestino.cliente.getNome() );
	}
	
}
