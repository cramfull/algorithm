
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int input1 = Integer.parseInt(str.nextToken());
		int input2 = Integer.parseInt(str.nextToken());
		
		int maxV = 0;
		int minV = 0;
		if(input1<input2) {
			maxV = input2;
			minV = input1;
		}else{
			maxV = input1;
			minV = input2;
		}
		
		int gongY = gcd(maxV,minV);
		int gongB = gongY*(maxV/gongY)*(minV/gongY);
		
		System.out.println(gongY);
		System.out.println(gongB);

	}

	static int gcd(int a, int b) {
		
		if(b==0) {
			return a;
		}
		
		int r = a%b;
		int na = b;
		int nb = r;
		
		return gcd(na,nb);
	}
	
}
