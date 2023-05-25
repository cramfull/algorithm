
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

public class Main {
	static int count=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer str = new StringTokenizer(br.readLine());
		LinkedList<Integer> deq = new LinkedList<>();
		
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		int [] arr = new int[M];
		str = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
		}
		
		for(int i=1; i<=N; i++) {
			deq.offerLast(i);
		}
		
		
		for(int i=0; i<arr.length; i++) {
			
			move(deq,N,arr[i]);
			deq.pollFirst();
		}
		System.out.println(count);
		
		
	}
	
	static void move(LinkedList<Integer> deq,int N, int x) {
		if(deq.indexOf(x)<=deq.indexOf(deq.get(deq.size()/2))) {
			while(!(deq.peekFirst()==x)) {
				deq.offerLast(deq.pollFirst());
				count++;
			}
		}else {
			while(!(deq.peekFirst()==x)) {
				deq.offerFirst(deq.pollLast());
				count++;
			}
		}
	}
}
