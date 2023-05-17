

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		// 1시간 당 
		int A = Integer.parseInt(str.nextToken());
		// 일 : 피로도 + 
		int B = Integer.parseInt(str.nextToken());
		// 처리하는 일의 양 
		int C = Integer.parseInt(str.nextToken());
		// 쉼 : 피로도 -
		
		int M = Integer.parseInt(str.nextToken());
		// 최대 피로도 
		
		
		int K = 0;
		//현재 피로도 
		int hour = 0;
		//일 한 시간 hour
		
		for(int i=1; i<=24; i++) {
			
			// K + A < M
			if(K+A<=M) {
				// 일
				K+=A;
				// hour++;
				hour++;
			}else {		// 아니면 쉼
				K-=C;
				// K - C
				if(K<0) {
					K=0;
				}
				// K가 음수 -> K = 0
			}
			
		}
		System.out.println(B*hour);
		// B * hour 출

		
		
		
		
	}
}