import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		
		String[] arr = new String[t];
		
		
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			String str = in.next();
			String str1 = "";
			
			for (int j = 0; j<str.length(); j++) {
				for ( int k = 0 ; k <n; k++) {
					str1 += str.charAt(j);
				}
			}
			arr[i] = str1;
		}
		
		for (String res:arr) {
			System.out.println(res);
			
		in.close();
		}
	}
}

// 자바 문자열 반복