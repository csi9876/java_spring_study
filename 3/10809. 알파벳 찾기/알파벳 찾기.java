import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		 
		 
		int[] arr1 = new int[26];
		
		for(int i = 0; i < arr1.length; i++) {
			arr1[i] = -1;
		}
 
		String str1 = in.nextLine();
 
		for(int i = 0; i < str1.length(); i++) {
			char char1 = str1.charAt(i);
    
			if(arr1[char1 - 'a'] == -1) {
				arr1[char1 - 'a'] = i;
			}
		}
 
		for(int res : arr1) {
			System.out.print(res + " ");
		}
	}
}
 
// 문자열 인덱싱