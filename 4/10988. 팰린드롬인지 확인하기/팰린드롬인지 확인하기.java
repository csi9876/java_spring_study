import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();			// 문자열 입력
		int res = 1;					// 결과 출력
		
		int i;
		for(i=0; i<str.length(); i++) {
			char A = str.charAt(i);			// 정순으로 저장
			char B = str.charAt(str.length()-1-i);	// 역순으로 저장
			
			if( A != B ) {				// 서로 다르면
				res = 0;			// 0 
			}
		}
		System.out.println(res);			// 1
		
		
	}
}
 
// 문자열 돌리기