import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		 
		String str1 = in.nextLine();
		in.close();
 
		// 공백을 기준으로 저장
		StringTokenizer str2 = new StringTokenizer(str1," ");
		
		// 토큰 갯수 세기
		System.out.println(str2.countTokens());	
		
		
	}
}

// 문자열 나누기