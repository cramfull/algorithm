
import java.math.*;
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		BigInteger factorial = new BigInteger("1");
		BigInteger tmp;
		for(int i=N; i>0; i--) {
			tmp = new BigInteger(String.valueOf(i));
			factorial = factorial.multiply(tmp);
		}
		
		String fac = factorial.toString();
		int result = 0;
		boolean isFind = false;
		for(int i=fac.length()-1; i>0; i--) {
			char c = fac.charAt(i);
			

			if(c!='0') {
				if(isFind) {
					break;
				}
			}else {
				isFind = true;
				result++;
			}
			
		}
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		
		
		
		
		
		
	}

}
