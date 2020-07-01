package dao;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TarefasLista implements Runnable {

	private BlockingQueue<String> fila;
	private List<String> dados;

	public TarefasLista(List<String> dados, BlockingQueue<String> fila) {
		try {
			fila = new ArrayBlockingQueue<String>(dados.size());
			this.dados = dados;
			for (String dado : dados) {
				fila.put(dado);
			}
			this.fila = fila;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

		try {
			synchronized (this) {
				String dado = null;
				while ((dado = fila.take()) != null) {
					System.out.println(dado + " - Thread execution: " + Thread.currentThread().getName());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
