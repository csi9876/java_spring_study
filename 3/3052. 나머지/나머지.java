import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// 나머지 넣을 배열
		int[] arr = new int[10];
		// 합계
		int count = 0;
		
		// 순회
		for (int i = 0; i < 10; i++) {
			arr[i]=in.nextInt()%42;
			int j = 0;
			
			// 배열 순회 0~10 같으면 정지
			for (j=0; j<i; j++) {
				if (arr[i]==arr[j])
					break;}
			
			// 같으면 카운트
			if (i==j) {
				count++;}
		}
		
		System.out.println(count);
		
		
    }
}
// for문 안 if, for문