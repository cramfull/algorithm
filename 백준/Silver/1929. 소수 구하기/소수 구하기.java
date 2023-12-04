
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	static int N, M;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(str.nextToken());
		int N = Integer.parseInt(str.nextToken());
		boolean isFind = false;
		
		for(int i=M; i<=N;i++) {
			int rangeM = (int)Math.sqrt(i);
			isFind = false;
			for(int j=2; j<=rangeM;j++) {
				if(i%j==0) {
					isFind = true;
					break;
				}
			}
			if(isFind == false && i!=1) {
				bw.write(String.valueOf(i)+"\n");
			}
		}
		bw.flush();
		bw.close();
		
	
		
	}
	
}
