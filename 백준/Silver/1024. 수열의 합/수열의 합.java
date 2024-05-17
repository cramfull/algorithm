
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(str.nextToken());
		int L = Integer.parseInt(str.nextToken());
		
		int sum = 0;
		int k = 0;
		
		for(int i=0;i<L;i++) {
			sum+=i;
		}
		
		while(N-sum>0 && L<=100) {
			if(((N-sum)%L==0)&& N-sum/L>0 ) {
				k = (N-sum)/L;
//				System.out.println("!!"+k+" "+(N-sum)+" "+L);
				break;
			}
			sum+=L;
			L+=1;
		}
		
		if(L>100||N-sum<0) {
			System.out.println(-1);
		}else {
//			System.out.println(k+" "+(N-sum)+" "+L);
			for(int i=0;i<L;i++) {
				System.out.print(k+i+" ");
			}
		}
		
		
	}

}
