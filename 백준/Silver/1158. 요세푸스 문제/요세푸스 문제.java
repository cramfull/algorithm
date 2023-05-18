

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
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());
		
		for(int i=1; i<=N; i++) {
			que.offer(i);
		}
		
		int i = 1;
		String result="<";
		while(que.size()!=0) {
			if(i%K==0) {
				result+= String.valueOf(que.poll());
				if(que.size()>0) {
					result+= ", ";
				}
			}else {
				int tmp = que.peek();
				que.poll();
				que.offer(tmp);
				}
			i++;
			
		}
		System.out.println(result+">");
		
		
	}
}