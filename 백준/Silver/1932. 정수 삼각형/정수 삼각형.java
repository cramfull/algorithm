
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int [][] arr = new int[N][N];
		int [][] res = new int[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			int j=0;
			while(str.hasMoreTokens()) {
				arr[i][j++]=Integer.parseInt(str.nextToken());
			}
		}
		
		
		int maxVal = arr[0][0];
		res[0][0]=arr[0][0];
		
		for(int i=0;i<N-1;i++) {
			for(int j=0;j<i+1;j++) {
				if(res[i+1][j]==0) {
					res[i+1][j]=res[i][j]+arr[i+1][j];
					if(maxVal < res[i+1][j]) {
						maxVal = res[i+1][j];
					}
				}else {
					if(res[i+1][j]<res[i][j]+arr[i+1][j]) {
						res[i+1][j]=res[i][j]+arr[i+1][j];
						if(maxVal < res[i+1][j]) {
							maxVal = res[i+1][j];
						}
					}
				}
				res[i+1][j+1]= res[i][j]+arr[i+1][j+1];
				if(maxVal < res[i+1][j+1]) {
					maxVal = res[i+1][j+1];
				}
			}
			
		}
		
		System.out.println(maxVal);
		
		
	}
}