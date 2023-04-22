import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		 
		// 배열 생성
		double arr[] = new double[in.nextInt()];
		
		// 배열에 전부 입력받기
		for(int i = 0; i < arr.length; i++) {
			arr[i] = in.nextDouble();
		}
		in.close();
		
		// 합
		double sum = 0;
		// 정렬하면 맨 마지막이 최대값
		Arrays.sort(arr);
		
		// 연산
		for(int i = 0; i < arr.length; i++) {
			sum += ((arr[i] / arr[arr.length-1]) * 100);
		}
		
		System.out.print(sum / arr.length);
    }
}

// double로 자동 형변환