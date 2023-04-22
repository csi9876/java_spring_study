import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] num = new int[9];
		int maxn = 0;
		int idx = 0;
		
		for(int i=0; i<9; i++) {
			int input = in.nextInt();
			num[i] = input;
		}
		
		for(int i=0; i<9; i++) {
			if(num[i]>maxn) {
				maxn = num[i];
				idx = i+1;
			}
		}
		
		System.out.println(maxn);
		System.out.println(idx);
	}
}