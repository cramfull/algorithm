
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int M = Integer.parseInt(br.readLine());
		StringTokenizer str;
		
		int ball = 1;
		for(int i=0; i<M; i++) {
			str = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(str.nextToken());
			int Y = Integer.parseInt(str.nextToken());
			if(X==ball) {
				ball = Y;
				continue;
			}
			if(Y==ball) {
				ball = X;
			}
		}
		System.out.println(ball);
		
		
		
	}
}