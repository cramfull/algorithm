
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;



	
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		
		int [][] A = new int[N][M];
		
		
		
		for(int i=0; i<N; i++) {
			str = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				A[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			str = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				A[i][j] += Integer.parseInt(str.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j =0; j<M; j++) {
				bw.write(String.valueOf(A[i][j]));
				if(j<M) {
					bw.write(" ");
				}
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}	

}
