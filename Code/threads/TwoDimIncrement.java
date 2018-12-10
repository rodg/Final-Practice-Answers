package threads;

import java.util.ArrayList;

public class TwoDimIncrement {
	
	public static void main(String[] args) {
		int size = 10;
		ArrayList<ArrayList<Integer>> myTable = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < size; i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for(int j = 0; j < size; j++) {
				temp.add(i+j);
			}
			myTable.add(temp);
		}
		Worker temp;
		
		ArrayList<Thread> threads = new ArrayList<Thread>();
		for(ArrayList<Integer> row: myTable) {
			temp = new Worker(row);
			threads.add(new Thread(temp));
		}
		
		for(Thread t: threads) {
			System.out.println(t.toString());
		}
		
		for(ArrayList<Integer> row: myTable) {
			for(Integer val: row) {
				System.out.print(val + " ");
			}
			System.out.print("\n");
		}
		
		int id = 0;
		
		for(Thread t: threads) {
			t.start();
			System.out.println(id++);
		}
		for(Thread t: threads) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for(ArrayList<Integer> row: myTable) {
			for(Integer val: row) {
				System.out.print(val + " ");
			}
			System.out.print("\n");
		}
		
	}
	

}
