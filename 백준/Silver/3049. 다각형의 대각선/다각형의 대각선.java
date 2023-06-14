import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int result = 0;
		
		result = N*(N-1)*(N-2)*(N-3)/24;
		
		System.out.println(result);
		
		//대각선의 개수 nC2 : N개의 꼭짓점 중 2개 선택 -> 대각선
        //대각선의 교점의 개수 nC4 : N개의 꼭짓점 중 4개 선택 -> 대각선 2개 = 교점 1개
		
		
	}
}