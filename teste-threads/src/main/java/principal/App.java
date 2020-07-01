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

//			ExecutorService threadPool = Executors.newFixedThreadPool(5);
//			DaoLista listaDao = new DaoLista();
//			BlockingQueue<String> fila = null;
//			for (int i = 0; i < 5; i++) {
//				threadPool.execute(new TarefasLista(listaDao.getLista(),fila));
//			}
//			
//			threadPool.shutdown();

			DaoWordList dao = new DaoWordList();
			ExecutorService executorService = Executors.newCachedThreadPool();

			RecebimentoEmail rec = new RecebimentoEmail(100);
			for (WordList w : dao.getWordList()) {
				rec.addFila(w);
				
				if (rec.getFila().size() == 100) {
					executorService.execute(rec);
				}
			}
			executorService.shutdown();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
