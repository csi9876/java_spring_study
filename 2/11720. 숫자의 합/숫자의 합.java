import java.util.Scanner;
public class Main {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String inputs = in.next();
		in.close();
		
		int result = 0;
		for (int i = 0; i < n; ++i) {
			result += inputs.charAt(i) - '0';
		}
		System.out.println(result);
	}
}