package threads;

import java.util.ArrayList;

public class DataRace {

	public static void main(String[] args) {
		System.out.println("Im run");
		
		ArrayList<String> bananas = new ArrayList<String>();
		for(int i = 0; i <= 20; i++)
			bananas.add("banana");
		
		Runnable A = ()->{
			for(String b: bananas) {
				System.out.println(b);
			}
		};
		
		Runnable B = ()->{
			for(int i = 0; i <=20; i+=2)
				bananas.add(i, "orange");
		};
				
		Thread reader = new Thread(A);
		Thread writer = new Thread(B);
		reader.start();
		writer.start();
		

	}

}
