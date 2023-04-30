import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		 
		
		int[] arr1 = {1, 1, 2, 2, 2, 8};
		for (int i = 0; i < arr1.length; i++) {
			int a = in.nextInt();
			arr1[i] = arr1[i]- a;
		}
		for (int i : arr1) {
			System.out.print(i+" ");
		}
		in.close();

		
	}
}
 
// 체스