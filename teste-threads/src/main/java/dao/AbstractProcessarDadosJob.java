package dao;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public abstract class AbstractProcessarDadosJob<E> implements Runnable {

	private BlockingQueue<E> fila;
	private int capacity;

	public AbstractProcessarDadosJob(int capacity) {
		fila = new ArrayBlockingQueue<E>(capacity);
		this.capacity = capacity;
	}

	public void addFila(E vo) throws InterruptedException {
		this.fila.put(vo);
	}

	@Override
	public void run() {
		
		E value = null;
		try {
			while ((value = fila.take()) != null) {
				System.out.println(value +" thread: " + Thread.currentThread().getName());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
