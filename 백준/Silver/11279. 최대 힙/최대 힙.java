

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		int N = Integer.parseInt(br.readLine());
		int k=0;
		for(int i=0; i<N; i++) {
			k = Integer.parseInt(br.readLine());
			
			if(k==0) {
				if(pq.size()==0) {
					bw.write(String.valueOf(0));
				}else {
					bw.write(String.valueOf(pq.poll()));
				}
				bw.newLine();

			}else {
				pq.add(k);
			}
			
		}
		bw.flush();
		bw.close();
	}
}