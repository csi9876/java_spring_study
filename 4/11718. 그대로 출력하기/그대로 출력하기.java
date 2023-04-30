import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		 
		// 다음 입력값이 있으면 트루
		while (in.hasNextLine()) {
			 String str1 = in.nextLine();
			System.out.println(str1);
		}
		in.close();

		
	}
}
 
// 그대로 출력하기 다음 입력값 있는 지 확인