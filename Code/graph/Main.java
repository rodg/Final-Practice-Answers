package graph;

public class Main {

	public static void main(String[] args) {
		MyGraph<Integer> graph = new MyGraph<Integer>();
		for(int i = 0; i <= 6; i++)
			graph.addNode(i);
		graph.test();
		
		Runnable r = ()->{
			for(int i = 0; i <=100; i+=2){
					System.out.println(i);}
			};
		
			
			
		
					

	}


}
