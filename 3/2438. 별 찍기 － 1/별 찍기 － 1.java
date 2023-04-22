import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		in.close();
		
		for (int i = 0; i < a; i++) {
			String str = "*";
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		
	}
}

// 자바 문자열 반복