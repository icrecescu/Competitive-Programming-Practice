import java.util.*;

class Main{

	public static void main(String[] agrs){
		Main main = new Main();
		main.start();
	}

	private void start(){
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextLine()){
			calcLine(scanner.next());
		}
	}
	
	private void calcLine(String set){
		String[] stringSignals = set.split(" ");
		int[] signals = new int[stringSignals.length];
		for(int i = 0; i < signals.length; i++){
			signals[i] = Integer.parseInt(stringSignals[i]);
		}

		int min = findMin(signals);
		
		for(int i = min*2; i <= 3600; i++){
			if(isAllGreen(signals, i)){
				System.out.println(i);
				return;
			}
		}
		System.out.println("  -- ");

	}
	
	private int findMin(int[] array){
		int min = array[0];
		for(int i = 1; i < array.length; i++){
			if(array[i] < min)
				min = array[i];
		}
		return min;
	}

	private boolean isAllGreen(int[] signals, int time){
		for(int signal : signals){
			int color = time / signal;
			int greenDuration = time % signal;
			if( !(color % 2 == 0 && greenDuration <= signal - 5)){
				return false;
			}
		}
		return true;
	}

}
