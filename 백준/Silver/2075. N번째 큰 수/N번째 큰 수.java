

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				pq.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		int k=0;
		for(int i=0; i<N; i++) {
			k = pq.poll();
		}
		bw.write(String.valueOf(k));
		bw.flush();
		bw.close();
		
		
	}
}