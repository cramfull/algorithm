

import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ArrayDeque<Integer> deq = new ArrayDeque<>();
		
		for(int i=1; i<=N;i++) {
			deq.push(i);
		}
		
		int [] arr = new int [N];
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		StringBuilder sb = new StringBuilder();
		int target = 0;
		int moving = 0;
		while(deq.size()>1) {
			target = deq.pollLast();
			sb.append(target+" ");
			moving = arr[target-1];
			if(moving<0) {
				while(moving<0) {
					moving++;
					deq.addLast(deq.pollFirst());
				}
			}else {
				moving--;
				while(moving>0) {
					moving--;
					deq.addFirst(deq.pollLast());
				}
			}
		}
		sb.append(deq.peek());
		
		System.out.println(sb.toString());
		
		
		
		
		
	}
}