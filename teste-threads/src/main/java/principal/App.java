package principal;

import banheiro.Banheiro;
import banheiro.FazendoNumero1;
import banheiro.FazendoNumero2;

public class App {

	public static void main(String[] args) throws InterruptedException {
		Banheiro banheiro = new Banheiro();
		
		Thread t1 = new Thread(new FazendoNumero1(banheiro), "Emerson");
		Thread t2 = new Thread(new FazendoNumero2(banheiro), "RedeW");
		Thread t3 = new Thread(new FazendoNumero2(banheiro), "Thiago");
		t1.start();
		t2.start();
		t3.start();
		
	}
}
