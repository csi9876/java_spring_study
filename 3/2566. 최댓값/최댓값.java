import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[][] arr = new int[9][9];
		
		int a = 0;
		int x = 1;
		int y = 1;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				arr[i][j] = in.nextInt();
				if (a<arr[i][j]) {
					a =arr[i][j];
					x = i+1;
					y = j+1;
				}
			}
		}
		in.close();
		System.out.println(a);
		System.out.println(x+" "+y);

		
	}
}

// 자바 2차원 행렬 덧셈