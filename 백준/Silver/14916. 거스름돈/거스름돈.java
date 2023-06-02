
//https://www.acmicpc.net/problem/14916

import java.io.*;
import java.util.*;



public class Main {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int i = N/5;
		int j = (N-5*i)/2;
		
		if(i*5 +j*2 == N) {
			//출
		}else {
			while(i>0) {
				i--;
				j = (N-5*i)/2;
				if(i*5 +j*2 == N) {
					break;
				}else {
					i--;
				}
			}
		}
		if(i*5 +j*2 != N) {
			System.out.println(-1);
		}else {
			System.out.println(i+j);
		}

				
		
	}

}
