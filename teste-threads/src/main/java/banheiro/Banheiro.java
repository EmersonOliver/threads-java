package banheiro;

public class Banheiro {

	public void fazendoNumero1() {

		String nome = Thread.currentThread().getName();

		System.out.println("Thread executando: " + nome);
		
		synchronized (this) {
			try {
				System.out.println(nome+" entrou no banheiro");
				System.out.println("tarefa rapidinha");
				Thread.sleep(5000);
				System.out.println(nome+ " Saiu do banheiro");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	public void fazendoNumero2() {
		String nome = Thread.currentThread().getName();
		System.out.println("Thread executando: " + nome);
		synchronized (this) {
			try {
				System.out.println(nome+" entrou no banheiro");
				System.out.println("tarefa demorada");
				Thread.sleep(10000);
				System.out.println(nome+ " Saiu do banheiro");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

	}

}
