
import java.util.*;
import java.io.*;
import java.math.*;


public class Main {
	static int [][] arr;
	static int [][] arrSum;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		
		arr = new int[N+1][M+1];
		arrSum = new int[N+1][M+1];
		for(int i=1;i<=N;i++) {
			String tmp [] = br.readLine().split(" ");
			int sum =0;
			for(int j=1;j<=M;j++) {
				arr[i][j] = Integer.parseInt(tmp[j-1]);
				sum+=arr[i][j];
				arrSum[i][j]=sum;
			}
		}
		int K = Integer.parseInt(br.readLine());
		for(int i=0;i<K;i++) {
			str = new StringTokenizer(br.readLine());
			int st_x = Integer.parseInt(str.nextToken());
			int st_y = Integer.parseInt(str.nextToken());
			int ed_x = Integer.parseInt(str.nextToken());
			int ed_y = Integer.parseInt(str.nextToken());
			if(st_x==ed_x && st_y==ed_y) {
				bw.write(String.valueOf(arr[st_x][st_y]));
			}else {
				int result=0;
				for(int j=st_x;j<=ed_x;j++) {
					result += arrSum[j][ed_y] - arrSum[j][st_y-1];
				}
				bw.write(String.valueOf(result));
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
		
		
		
	}
}

