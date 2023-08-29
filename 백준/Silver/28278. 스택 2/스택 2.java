
import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			switch(Integer.parseInt(st.nextToken())) {
			case 1:
				int k = Integer.parseInt(st.nextToken());
				stack.push(k);
				break;
			case 2:
				if(stack.isEmpty()) {
					bw.write(String.valueOf(-1));
				}else {
					bw.write(String.valueOf(stack.pop()));
				}
				bw.newLine();
				break;
			case 3:
				bw.write(String.valueOf(stack.size()));
				bw.newLine();
				break;
			case 4:
				if(stack.isEmpty()) {
					bw.write(String.valueOf(1));
				}else {
					bw.write(String.valueOf(0));
				}
				bw.newLine();
				break;
			case 5:
				if(stack.isEmpty()) {
					bw.write(String.valueOf(-1));
				}else {
					bw.write(String.valueOf(stack.peek()));
				}
				bw.newLine();
				break;
			}
		}
		bw.flush();
		bw.close();
	}
}