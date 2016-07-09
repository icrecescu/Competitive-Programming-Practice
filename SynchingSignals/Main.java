import java.util.*;

class Main{

	private int k = 1;

	public static void main(String[] agrs){
		Main main = new Main();
		main.start();
	}

	private void start(){
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextLine()){
			calcLine(scanner.nextLine());
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
				String output = "Set " + k++ + " synchs again at " + getTime(i) + " after all turning green.";
				System.out.println(output);
				return;
			}
		}
		System.out.println("Set " + k++ + " is unable to synch after one hour.");

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
			if( !(color % 2 == 0 && greenDuration < signal - 5)){
				return false;
			}
		}
		return true;
	}

	private String getTime(int time){
		int minutes = time / 60;
		int seconds = time % 60;
		return minutes + " minute(s) and " + seconds + " second(s)";
	}


}
