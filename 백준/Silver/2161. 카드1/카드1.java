

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;



public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<Integer> que = new LinkedList<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=N; i++) {
			que.offer(i);
		}
		String result="";
		while(que.size()!=0) {
			int tmp1 = que.peek();
			que.poll();
			if(que.size()==0) {
				result += tmp1;
				break;
			}
			que.offer(que.poll());
			
			result += tmp1;
			if(que.size()>0) {
				result+=" ";
			}
		}
		System.out.println(result);
		
		
	}
	
}