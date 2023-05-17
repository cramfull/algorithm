

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
		int N = Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());
		int [] coin = new int[N];
		for(int i = 0; i<N; i++) {
			coin[i]= Integer.parseInt(br.readLine());
		}
		
		int result = 0;
		while(K!=0) {		// K == 0 까지 반복 
			int tmp = search(coin,K);
			// coin[i] 중 제일 높은 단위의 동전 선택
			result += K/coin[tmp];
			// result에 나눈 몫 +=
			K%=coin[tmp];
			// K %= 해당 단위 
			continue;
		}
		System.out.println(result);
		
		
	}
	static int search(int [] coin, int K) {			// coin[i] 중 제일 높은 단위의 동전 선택
		int max_index=0;
		for(int i = 0 ; i<coin.length; i++) {
			if(coin[i]==K) {
				max_index=i;
			}
			if(coin[i]<K) {
				max_index=i;
				continue;
			}
			
		}
		if(coin[max_index]>K) {
			max_index-=1;
		}
		
		
		return max_index;
	}
}