
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	static long result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int Tc = Integer.parseInt(br.readLine());
		
		for(int i=0;i<Tc;i++) {
			Long input = Long.parseLong(br.readLine());
			primeNum(input);
			bw.write(String.valueOf(result)+"\n");
		}
		bw.flush();
		bw.close();
		
	}
	static void primeNum(long n) {
		// 루트 n
		// 2 <= i <= 루트 n 나누어 떨어지는 수 찾음 
		// 없다면 찾음
		// 있다면 n+1
		if(n<3) {
			result = 2;
			return;
		}
		long k = (long) Math.sqrt(n);
		
		for(int i=2; i<=k; i++) {
			if(n%i==0) {
				primeNum(n+1);
				return;
			}
		}
		result = n;
		return;
		
		
		
	}

}
