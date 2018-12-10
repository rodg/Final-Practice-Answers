package threads;

import java.util.ArrayList;

public class DeadLock {
	public static void main(String[] args) {
		
		ArrayList<String> data = new ArrayList<String>();
		data.add("banana");
		
		Runnable A = ()->{
			synchronized(data) {
				while(true) {
					//
				}
			}
		};
		
		Runnable B = ()->{
			synchronized(data) {
				System.out.println(data.get(0));
			}
		};
		
		Thread blocker = new Thread(A);
		Thread cantRun = new Thread(B);
		blocker.start();
		cantRun.start();
		//never prints banana or stops executing.
		

	}
}
