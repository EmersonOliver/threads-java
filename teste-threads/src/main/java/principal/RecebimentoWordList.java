package principal;

import dao.AbstractProcessarDadosJob;
import model.WordList;

public class RecebimentoWordList extends AbstractProcessarDadosJob<WordList> {

	public RecebimentoWordList(int capacity) {
		super(capacity);
	}

	@Override
	public void run() {
		try {
			synchronized (this) {
				WordList value = null;
				for(int i = 0; i< fila.size();i++) {
					value = fila.take();
					System.out.println(value.getWord() +" thread: " + Thread.currentThread().getName() +" dado:" + value.getId());
					System.out.println("Qtd Items fila: "+fila.size());
				}
				
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
