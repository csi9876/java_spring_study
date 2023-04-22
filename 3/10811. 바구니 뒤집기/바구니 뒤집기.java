import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();

        int[] arr = new int[a];
        
        // 12345
        for (int i = 0; i < a; i++) {
            arr[i] = i+1;
        }
        
        
        for (int i = 0; i < b; i++) {
            int c =in.nextInt();
            int d = in.nextInt();
            
            // 길이가 가변하는 리스트
            ArrayList<Integer> list = new ArrayList<>();

            for (int j = c-1; j < d; j++) {
//            	// list에 값 추가
                list.add(arr[j]);
            }

            int e = 0;
            
            // 원래 위치에 값 주기
            for (int j = d-1; j >= c-1; j--) {
                arr[j] = list.get(e);
                e++;
            }
        }


        for (int i = 0; i < a; i++) {
            System.out.print(arr[i] + " ");
        }
	}
}

// 바구니 뒤집기