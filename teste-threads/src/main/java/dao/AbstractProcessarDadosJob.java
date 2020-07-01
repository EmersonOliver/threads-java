package dao;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public abstract class AbstractProcessarDadosJob<E> implements Runnable {

	protected BlockingQueue<E> fila;
	private int capacity;

	public AbstractProcessarDadosJob(int capacity) {
		fila = new ArrayBlockingQueue<E>(capacity);
		this.capacity = capacity;
	}

	public void addFila(E vo) throws InterruptedException {
		this.fila.put(vo);
	}
	
	private synchronized void executarFila() {
		E value = null;
		int i = 1;
		try {
			value = fila.take();
				System.out.println(value +" thread: " + Thread.currentThread().getName() +" dado:" + i++);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		executarFila();
	}

	public BlockingQueue<E> getFila() {
		return fila;
	}

	public void setFila(BlockingQueue<E> fila) {
		this.fila = fila;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
}
