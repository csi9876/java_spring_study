import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int[][] arr1 = new int[a][b];
		int[][] arr2 = new int[a][b];
		
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				arr1[i][j] = in.nextInt();
				
			}
		}
		
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				arr2[i][j] = in.nextInt();
			}
		}
		
		in.close();
		
		for (int i = 0; i<a;i++) {
			for (int j=0; j<b; j++) {
				System.out.print(arr1[i][j]+arr2[i][j]+" ");
				if(j == b-1)
					System.out.println();
			}
		}
		
	}
}

// 자바 2차원 행렬 덧셈