import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
				
		Map<Integer, Integer> map = new TreeMap<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			map.put(Integer.parseInt(st.nextToken()), null);
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int k = Integer.parseInt(st.nextToken());
			
			if(map.containsKey(k)) {
				map.remove(k);
			}
		}
		
		if(map.size()==0) {
			bw.write("0");
		}else {
			bw.write(String.valueOf(map.size()));
			bw.newLine();
			for(int k : map.keySet()) {
				bw.write(String.valueOf(k)+" ");
				
			}
		}
		
		bw.flush();
		bw.close();
		
	}
}