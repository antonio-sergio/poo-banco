
public class Main {

	public static void main(String[] args) {
		Cliente cliente1 = new Cliente();
		Cliente cliente2 = new Cliente();
		
		cliente1.setNome("Antônio");
		cliente2.setNome("Luana");
		
		Conta cc = new ContaCorrente(cliente1);
		cc.depositar(100);
		Conta cp = new ContaPoupanca(cliente2);
		
		
		cc.imprimirExtrato();
		cp.imprimirExtrato();
	
		cp.sacar(50);
		
		cc.transferir(25, cp);
	}

}
