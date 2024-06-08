
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(str.nextToken());
		int r = Integer.parseInt(str.nextToken());
		int c = Integer.parseInt(str.nextToken());
		
		Point target = new Point(r,c);
		int len = (int)Math.pow(2, N);
		int total =(int)Math.pow(Math.pow(2, N), 2);
		int sum = 0;
		
		
		
		while(total!=1) {
			total/=4;
			len/=2;
			int tmp = 0;
			int quot = target.x/len;
			int rem = target.y/len;
			if(quot==0 && rem==0) {
				tmp = 0;
			}else if(quot==0 && rem == 1) {
				tmp = 1;
			}else if(quot ==1 && rem == 0) {
				tmp = 2;
			}else {
				tmp = 3;
			}
			target = new Point(target.x%len, target.y%len);
			
			sum += total * tmp;
			
			// tmp -> 포인트/len  (0,0),(0,1),(1,0),(1,1)
			// 포인트 -> len으로 나눈 나머지
			// total * tmp 더하기

			
		}
		System.out.println(sum);
		
	}
	static class Point{
		int x;
		int y;
		public Point(int x,int y) {
			this.x=x;
			this.y=y;
		}
	}

}
