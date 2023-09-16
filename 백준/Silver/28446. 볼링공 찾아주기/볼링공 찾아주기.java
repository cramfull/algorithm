

import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int N = Integer.parseInt(br.readLine());
		
		Map<Integer, Integer> map = new HashMap<>();
		StringTokenizer st ;
		int locker = 0;
		int ballWeight =0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			if(Integer.parseInt(st.nextToken())==1) {
				locker = Integer.parseInt(st.nextToken());
				ballWeight = Integer.parseInt(st.nextToken());
				map.put(ballWeight, locker);
			}else {
				int target = Integer.parseInt(st.nextToken());
				bw.write(String.valueOf(map.get(target)));
				bw.newLine();
			}
		}
		bw.flush();
		bw.close();
		
		
		
	}
}