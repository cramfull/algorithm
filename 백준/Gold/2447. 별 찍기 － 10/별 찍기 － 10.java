
import java.util.*;
import java.io.*;
import java.math.*;


public class Main {
	static String [][] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		arr = new String [N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				arr[i][j]=" ";
			}
		}
		star(0,0,N);
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	
	
	static void star(int x,int y,int size) {
		if(size==1) {
			arr[x][y] = "*";
			return;
		}
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(!(i==1&&j==1)) {
					star(x+i*(size/3),y+j*(size/3),size/3);
				}
			}
		}
		
		
		
	}
}