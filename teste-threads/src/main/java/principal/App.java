package principal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import dao.DaoWordList;
import model.WordList;

public class App {

	public static void main(String[] args) throws InterruptedException {
		// Exemplo Banheiro
		/*
		 * Banheiro banheiro = new Banheiro();
		 * 
		 * Thread t1 = new Thread(new FazendoNumero1(banheiro), "Emerson"); Thread t2 =
		 * new Thread(new FazendoNumero2(banheiro), "RedeW"); Thread t3 = new Thread(new
		 * FazendoNumero2(banheiro), "Thiago"); t1.start(); t2.start(); t3.start();
		 */
		try {

			DaoWordList dao = new DaoWordList();
			int size = dao.getWordList().size();
			ExecutorService executorService = Executors.newFixedThreadPool(5);
			float calc = (size / 5);
			Integer capacity = Math.round(calc);

			RecebimentoEmail rec = new RecebimentoEmail(capacity);
			for (WordList w : dao.getWordList()) {
				rec.addFila(w);

				if (rec.getFila().size() == capacity) {
					executorService.execute(rec);
				} else {
					continue;
				}

			}
			executorService.shutdown();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
