
// https://www.acmicpc.net/problem/2847

// 완성 여부 : X
// 제출 여부 : O

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(str.nextToken());
		
		int score [] = new int [N];
		
		for(int i=0; i<N; i++) {
			score[i]=Integer.parseInt(br.readLine());
		}
		
		int result = 0;
		
		for(int i= N-1; i>0; i--) {
			int tmp = score[i];
			if(score[i-1]>=tmp) {
				result += score[i-1] -(tmp-1);
				score[i-1] = tmp -1;
			}
		}
		System.out.println(result);
		
	}
}
