

// https://www.acmicpc.net/problem/17952

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		// 시간 스택 
		Stack<Integer> stack = new Stack<>();
		// 스코어 스택 
		Stack<Integer> stack2 = new Stack<>();
		
		
		int tc = 0;
		int score = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			tc = Integer.parseInt(st.nextToken());
			
			if(tc==0) {
				if(!stack.isEmpty()) {
					stack.set(stack.size()-1, stack.peek()-1);
				}
			}else {
				stack2.push(Integer.parseInt(st.nextToken()));
				stack.push(Integer.parseInt(st.nextToken())-1);
			}
	
			if(stack.isEmpty()) {
				continue;
			}		
			if(stack.peek()==0) {
				score += stack2.pop();
				stack.pop();
			}

		}
		System.out.println(score);
	}
}