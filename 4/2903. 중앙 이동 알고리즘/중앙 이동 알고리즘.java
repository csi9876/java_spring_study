import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int res = 2;
        for (int i = 1; i <= n; i++) {
            res = (res-1) + res;
        }
        System.out.println(res*res);
        in.close();
	}
	
}
 
// 진법 변환

//0 4 2*2
//1 9 ((2-1)+2)**2
//2 25 ((3-1)+3)**2
//3 81 ((5-1)+5)**2
//4 289 ((9-1)+9)**2
//5 1089 ((17-1)+17)**2