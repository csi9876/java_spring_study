import java.util.Scanner;

public class testfile4 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = i+1;
        }

        for (int i = 0; i < M; i++) {
            int tmp;
            int F = in.nextInt();
            int E = in.nextInt();

            tmp = arr[F-1];
            arr[F-1] = arr[E-1];
            arr[E-1] = tmp;
        }
        in.close();

        for (int result : arr)
            System.out.print(result + " ");
    }
}
// 이중 포문으로 입력받기
// 포문 돌려서 배열 출력하기