package threads;

import java.util.ArrayList;

public class Worker implements Runnable{
	private ArrayList<Integer> myRow;
	
	public Worker(ArrayList<Integer> myRow) {
		this.myRow = myRow;
	}
	public void run() {
		//System.out.println(myRow.size());
		for(int i = 0; i < myRow.size(); i++) {
			int temp = myRow.get(i);
			myRow.remove(i);
			myRow.add(i, temp+1);
			
		}
	}
	
}