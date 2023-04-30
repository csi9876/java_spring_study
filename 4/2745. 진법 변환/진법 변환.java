import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String str = in.next();  // 숫자
		int n = in.nextInt();	// n 진법
		int temp = 1;		
		int res = 0;		// 결과
		
		for (int i = str.length()-1; i >= 0; i--) {
			char c = str.charAt(i);	// 한 글자씩 떼기

			if('A'<= c && c <= 'Z') {	// 문자면  + 10 - 알파벳 A(65)만큼 빼고 10 더해주기
				res += (c-'A'+10)*temp;  //자릿수 곱해주기

			}else {						// 아니면 그대로
				res += (c-'0')*temp;	// 자릿수 곱해주기
			}
			temp *= n;		// 자릿수 곱하기
		}
		
		System.out.println(res);
	}     
}
 
// 진법 변환