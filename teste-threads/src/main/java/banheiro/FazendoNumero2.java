package banheiro;

public class FazendoNumero2 implements Runnable {

	private Banheiro banheiro;

	public FazendoNumero2(Banheiro banheiro) {
		this.banheiro = banheiro;
	}

	@Override
	public void run() {

		banheiro.fazendoNumero2();

	}

}
