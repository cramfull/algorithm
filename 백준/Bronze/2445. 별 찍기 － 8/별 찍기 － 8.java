
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;



public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		
		for(int i=0; i<N; i++) {
			for(int k=0; k<i+1; k++) {
				System.out.print("*");
			}
			for(int j=N-i; j>1; j--) {
				System.out.print(" ");
			}
			for(int x=N-i; x>1; x--) {
				System.out.print(" ");
			}
			for(int y=0; y<i+1; y++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int a=0; a<N; a++) {
			for(int b=N-1-a; b>0; b--) {
				System.out.print("*");
			}
			for(int c=0; c<a+1; c++) {
				System.out.print(" ");
			}
			for(int d=0; d<a+1; d++) {
				System.out.print(" ");
			}
			for(int e=N-1-a; e>0; e--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		
	}
	
	
	
}