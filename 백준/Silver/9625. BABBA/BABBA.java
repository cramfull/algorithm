
import java.util.*;
import java.io.*;
import java.math.*;


public class Main {
	static int N;
	static Point[] arr;
	public static void main(String[] args) throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	N = Integer.parseInt(br.readLine());
	arr = new Point[N+2];
	arr[0] = new Point(1,0);
	arr[1] = new Point(0,1);
	Point result = dp(N);
	
	System.out.println(result.toString());
	
	}
	
	
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x=x;
			this.y=y;
		}
		@Override
		public String toString() {
			return x + " " + y;
		}
		
	}
	static Point dp(int n) {
		if(n<=1) {
			return arr[n];
		}else {
			for(int i=2;i<=n;i++) {
				arr[i]=new Point(arr[i-1].x+arr[i-2].x, arr[i-1].y+arr[i-2].y);
			}
			return arr[n];
		}
	}
}

