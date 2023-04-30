import java.util.Scanner;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr1 = new int[n];

        for(int i=0; i < n; i++){
            arr1[i] = in.nextInt();
        }
        Arrays.sort(arr1);
        for (int i : arr1) {
			System.out.println(i);
		}
        
        in.close();
	}
	
}