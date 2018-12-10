package designpatterns;

public class StateDesign {
	static int state = 1; // valid states will be 0,1,2,3
	
	public static void prompt() {
		System.out.println("State " + state);
	}

	public static void main(String[] args) {
		
		System.out.println("Starting state = " + state);
		
		while (true)
			switch (state) {
			case 1:
				prompt();
				state = 2;
				break;
			case 2:
				prompt();
				state = 3;
				break;
			case 3:
				prompt();
				state = 0;
				break;
			case 0:
				System.out.println("Last state!");
				state = -1;
				break;
			default:
				System.out.println("Done running");
				System.exit(state);

			}

	}

}
