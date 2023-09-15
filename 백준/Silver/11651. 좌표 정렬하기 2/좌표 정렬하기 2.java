

import java.io.*;
import java.math.*;
import java.util.*;

public class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Point [] arr = new Point[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i] = new Point(x, y);
		}
		StringBuilder sb = new StringBuilder();
		Arrays.sort(arr);
		for(int i=0; i<N; i++) {
			sb.append(arr[i].x+" "+arr[i].y+"\n");
		}
		System.out.println(sb.toString());
	}
}


class Point implements Comparable<Point>{
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Point o) {
		// TODO Auto-generated method stub
		if(y - o.y == 0) {
			return x - o.x;
		}
		return y - o.y;
	}
	
	
}