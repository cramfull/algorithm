import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;



	
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer str;
		int [][] arr = new int[9][9];
		
		int max_value = 0;
		int max_index_i =0;
		int max_index_j =0;
		
		for(int i=0; i<9; i++) {
			str = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				arr[i][j]= Integer.parseInt(str.nextToken());
				if(max_value<=arr[i][j]) {
					max_value=arr[i][j];
					max_index_i=i+1;
					max_index_j=j+1;
				}
			}
		}
		
		
		bw.write(String.valueOf(max_value));
		bw.newLine();
		bw.write(String.valueOf(max_index_i+" "+max_index_j));
		bw.flush();
		bw.close();
	}	
}
