import java.util.Arrays;
import java.util.Scanner;


public class testfile {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        
        int num = in.nextInt();
        int[] arr = new int[num];
        
        for (int i=0; i<arr.length; i++) {
        	arr[i] = in.nextInt();
        }
        
        Arrays.sort(arr);

        System.out.println(arr[0] + " " + arr[num - 1]);
	}
}

// 배열을 정렬하는 방법 사용해보기 > import 이후 정렬 해야한다