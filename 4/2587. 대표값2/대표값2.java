import java.util.Scanner;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int[] arr1 = new int[5];
        
        int avg = 0;
        for(int i=0; i < 5; i++){
        	int a = in.nextInt();
            arr1[i] = a;
            avg += a;
        }
        Arrays.sort(arr1);
        System.out.println(avg/5);
		System.out.println(arr1[2]);
        in.close();
	}
	
}
// 평균, 중앙값