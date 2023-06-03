
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());
		
		Queue<Integer> que = new LinkedList<>();
		int idx = 1;
		
		for(int i=1; i<=N; i++) {
			que.offer(i);
		}
		int [] result = new int[N];
		int i=0;
		while(!que.isEmpty()) {
			if(idx%K==0) {
				result[i]=que.poll();
				i++;
			}else {
				que.offer(que.poll());
			}
			idx++;
		}
		bw.write("<");
		for(int j=0; j<result.length; j++) {
			bw.write(String.valueOf(result[j]));
			if(j<result.length-1) {
				bw.write(", ");
			}
		}
		bw.write(">");
		bw.flush();
		bw.close();
	}
}