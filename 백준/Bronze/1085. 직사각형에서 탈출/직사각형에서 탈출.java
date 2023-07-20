
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int [] point = new int[4];
		for(int i=0; i<4; i++) {
			point[i]=Integer.parseInt(str.nextToken());
		}
		point[2] -= point[0];
		point[3] -= point[1];
		
		Arrays.sort(point);
		
		System.out.println(point[0]);
		
		
		
	}
}