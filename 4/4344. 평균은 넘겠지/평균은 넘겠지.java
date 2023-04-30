import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int test_case = in.nextInt();
		
		// 테케만큼 반복
		for (int i = 0; i < test_case; i++) {
			int n = in.nextInt(); // 학생
			int count = 0; // 평균을 넘는 학생
			double avg = 0; // 평균
			double res; // 결과
			
			
			int[] arr = new int[n]; // 점수 저장 배열
			for (int j = 0; j < n; j++) {
				int score = in.nextInt();  // 점수
				arr[j] = score;
				avg += score; // 총합
			}
			avg = avg / n; // 평균
			for (int k = 0; k < arr.length; k++) {
				if (arr[k] > avg) { // 평균 넘으면 카운트
					count++;
				}
			}
			res = (double) count / n * 100;  // 형변환
            								  
			System.out.printf("%.3f", res);  // 소수점 계산
			System.out.println("%");
			
		}
		in.close();
	}
}
 
// 배열에 점수 저장 > 총합 > 평균 > 평균을 넘는 지 카운트