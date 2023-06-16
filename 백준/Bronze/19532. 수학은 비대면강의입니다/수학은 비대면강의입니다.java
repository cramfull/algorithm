
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(str.nextToken());
		int b = Integer.parseInt(str.nextToken());
		int c = Integer.parseInt(str.nextToken());
		int d = Integer.parseInt(str.nextToken());
		int e = Integer.parseInt(str.nextToken());
		int f = Integer.parseInt(str.nextToken());

		
		int x=-999;
		int y = -999;
		
		for(int i=x; i<=999; i++) {
			for(int j=y; j<=999; j++) {
				if((a*i+b*j==c) && (d*i+e*j==f)) {
					System.out.println(i+" "+j);
					break;
				}
			}
		}
		
		
		
	}
}