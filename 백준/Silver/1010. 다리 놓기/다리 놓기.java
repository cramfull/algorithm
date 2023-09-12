

import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
	
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			BigInteger bi = combi(m,n);
			bw.write(String.valueOf(bi.toString()));
			bw.newLine();
		}
		bw.flush();
		bw.close();
		
		
		
		
	}
	public static BigInteger combi(int m, int n) {
		BigInteger b1 = new BigInteger("1");
		BigInteger bN = new BigInteger("1");
		BigInteger bigNum;
		for(long i=m-n+1; i<=m; i++) {
			bigNum = BigInteger.valueOf(i);
			b1 = b1.multiply(bigNum);
		}
		BigInteger bigN;
		for(long i=1; i<=n; i++) {
			bigN = BigInteger.valueOf(i);
			bN = bN.multiply(bigN);
		}
		return b1.divide(bN);
	}
	
}