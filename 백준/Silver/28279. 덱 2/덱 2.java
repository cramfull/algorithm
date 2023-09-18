
import java.io.*;

import java.util.*;
import java.util.Map.Entry;


public class Main {	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Deque<Integer> deq = new LinkedList<>();
		
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			switch(Integer.parseInt(st.nextToken())) {
			case 1 :
				deq.addFirst(Integer.parseInt(st.nextToken()));
				break;
			case 2 :
				deq.addLast(Integer.parseInt(st.nextToken()));
				break;
			case 3:
				if(deq.isEmpty()) {
					bw.write("-1");
				}else {
					bw.write(String.valueOf(deq.pollFirst()));
				}
				bw.newLine();
				break;
			case 4 : 
				if(deq.isEmpty()) {
					bw.write("-1");

				}else {
					bw.write(String.valueOf(deq.pollLast()));

				}
				bw.newLine();
				break;
			case 5 :
				bw.write(String.valueOf(deq.size()));
				bw.newLine();
				break;
			case 6:
				if(deq.isEmpty()) {
					bw.write("1");
				}else {
					bw.write("0");
				}
				bw.newLine();
				break;
			case 7:
				if(deq.isEmpty()) {
					bw.write("-1");
				}else {
					bw.write(String.valueOf(deq.peekFirst()));
				}
				bw.newLine();

				break;
			case 8:
				if(deq.isEmpty()) {
					bw.write("-1");
				}else {
					bw.write(String.valueOf(deq.peekLast()));
				}
				bw.newLine();

				break;
			
			}
		}
		bw.flush();
		bw.close();
		
	}
}