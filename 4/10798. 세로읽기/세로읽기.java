import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char arr1[][] = new char[5][15];  // 2차원 배열 받기
        
        for (int i = 0; i < 5; i++) {	// 5번 반복해서 받기
			String str1 = br.readLine();  // 문자열 받기
			for (int j = 0; j < str1.length(); j++) {
                arr1[i][j] = str1.charAt(j);  // str을 한 글자씩 char로 뽑음
			}       
        }
        for (int i = 0; i < 15; i++) {	// 15번 반복해서 출력
            for (int j = 0; j < 5; j++) {
                if (arr1[j][i] == 0 || arr1[j][i] ==' ') {  // 공백이나 0이면 넘기기
                    continue;
                }
                bw.write(String.valueOf(arr1[j][i]));	// 출력
		}
        }
        br.close();	 // 닫음

        bw.close(); // 닫음
        
        
	}     
}
 
// 배열에 점수 저장 > 총합 > 평균 > 평균을 넘는 지 카운트