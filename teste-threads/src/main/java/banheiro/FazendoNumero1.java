package banheiro;

public class FazendoNumero1 implements Runnable {

	private Banheiro banheiro;

	public FazendoNumero1(Banheiro banheiro) {
		this.banheiro = banheiro;
	}

	@Override
	public void run() {

		banheiro.fazendoNumero1();

	}

}
