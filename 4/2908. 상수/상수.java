import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		 
		int a = in.nextInt();
		int b = in.nextInt();
		
		int aa = (a%10)*100 + ((a/10)%10)*10 + (a/100);
		int bb = (b%10)*100 + ((b/10)%10)*10 + (b/100);
		
		if (aa > bb) {
			System.out.println(aa);
		} else {
			System.out.println(bb);
		}


		
	}
}