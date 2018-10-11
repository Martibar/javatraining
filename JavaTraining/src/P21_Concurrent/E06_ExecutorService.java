package P21_Concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class E06_ExecutorService {

	public static void main(String[] args) {

		ExecutorService pool1 = Executors.newCachedThreadPool();
		ExecutorService pool2 = Executors.newCachedThreadPool();
		
		pool1.submit(new Task(1));
		pool1.submit(new Task(2));
		pool2.submit(new Task(3));
		pool2.submit(new Task(4));
		
		pool1.shutdown();
		pool2.shutdown();
		
	}
	
	private static class Task implements Runnable {

		private int id;
		
		public Task(int id) {
			this.id = id;
		}
		
		@Override
		public void run() {
			for(int i=0; i<10; i++) {
				String name = Thread.currentThread().getName();
				System.out.println(this.id + " - " + name + ": " + i);
			}
		}
		
	}
	
}
