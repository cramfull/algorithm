import java.io.*;
import java.util.*;

public class Solution {
	
	static int N, sumX, sumY;
	static long results;
	static Point [] points;
	
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=TC;tc++) {
			N = Integer.parseInt(br.readLine());
			points = new Point[N];
			sumX = 0;
			sumY = 0;
			results = Long.MAX_VALUE;
			for(int i=0;i<N;i++) {
				StringTokenizer str = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(str.nextToken());
				int y = Integer.parseInt(str.nextToken());
				sumX+=x;
				sumY+=y;
				points[i] = new Point(x,y);
			}
			dfs(0,0,0,0);
			sb.append("#").append(tc).append(" ").append(results).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void dfs(int depth, int start, int x, int y) {
		if(depth == N/2) {
			int otherX = sumX-x;
			int otherY = sumY-y;
			
			results = (long) Math.min(results, Math.pow(x-otherX,2)+Math.pow(y-otherY,2));
			return;
		}
		
		for(int i=start;i<N;i++) {			
			dfs(depth+1, i+1, x + points[i].x, y + points[i].y);
		}
	}
	
	
	static class Point{
		int x,y;
		public Point(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
}
