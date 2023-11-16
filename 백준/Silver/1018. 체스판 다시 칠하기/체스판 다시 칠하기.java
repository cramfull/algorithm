import java.io.*;
import java.math.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
	static int N,M;
	static char [][] board;
	static char [][] checker1= new char[][] {
		{'W','B','W','B','W','B','W','B'},
		{'B','W','B','W','B','W','B','W'},
		{'W','B','W','B','W','B','W','B'},
		{'B','W','B','W','B','W','B','W'},
		{'W','B','W','B','W','B','W','B'},
		{'B','W','B','W','B','W','B','W'},
		{'W','B','W','B','W','B','W','B'},
		{'B','W','B','W','B','W','B','W'}
	};
	static char [][] checker2= new char[][] {
		{'B','W','B','W','B','W','B','W'},
		{'W','B','W','B','W','B','W','B'},
		{'B','W','B','W','B','W','B','W'},
		{'W','B','W','B','W','B','W','B'},
		{'B','W','B','W','B','W','B','W'},
		{'W','B','W','B','W','B','W','B'},
		{'B','W','B','W','B','W','B','W'},
		{'W','B','W','B','W','B','W','B'}
	};
	static ArrayList<Integer> arr = new ArrayList<>();
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer str = new StringTokenizer(br.readLine());
    	M = Integer.parseInt(str.nextToken());
    	N = Integer.parseInt(str.nextToken());
    	
    	board = new char[M+1][N+1];
    	for(int i=0;i<M;i++) {
    		String [] tmp = br.readLine().split("");
    		for(int j=0;j<N;j++) {
    			board[i][j]=tmp[j].charAt(0);
    		}
    	}
    	
    	for(int i=0;i<=M-8;i++) {
    		for(int j=0;j<=N-8;j++) {
    			checkBoard(i,j);
    		}
    	}
    	Collections.sort(arr);
    	System.out.println(arr.get(0));
    }
    static void checkBoard(int x, int y) {
    	int count1 =0;
    	int count2 = 0;
    	for(int i=x;i<x+8;i++) {
    		for(int j=y;j<y+8;j++) {
    			if(board[i][j]!=checker1[i-x][j-y]) {
    				count1++;
    			}
    			if(board[i][j]!=checker2[i-x][j-y]) {
    				count2++;
    			}
    		}
    	}
    	arr.add(count1);
    	arr.add(count2);
    }
    
    
    static class Point{
    	int x,y;
    	public Point(int x,int y) {
    		this.x=x;
    		this.y=y;
    	}
    }
}
