

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> que = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			que.offer(i);
		}
		
		while(que.size()>1) {
			que.poll();
			int tmp = que.peek();
			que.poll();
			que.offer(tmp);
		}
		System.out.println(que.peek());
		
		
		
		
		
	}
}