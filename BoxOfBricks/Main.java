import java.util.*;

class Main{
	public static void main(String[] args){
		Main main = new Main();
		main.start();
	}
	
	private void start(){
		Scanner scanner = new Scanner(System.in);
		int bricks = scanner.nextInt();
		int k = 1;
		while(bricks != 0){
			List<Integer> bricksArray = new ArrayList<>();
			int total = 0;
			for(int i = 0; i < bricks; i++){
				int brick = scanner.nextInt();
				total += brick;
				bricksArray.add(brick);
			}
			int median = total / bricksArray.size();
			
			int result = 0;
			for(int b : bricksArray){
				if(b - median > 0){
					result += b-median;
				}
			}
			System.out.println("Set #" + k++);
			System.out.println("The minimum number of moves is " + result + ".");
			bricks = scanner.nextInt();
		}
	}
}
