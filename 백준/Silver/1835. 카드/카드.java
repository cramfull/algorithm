
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;



	
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N=Integer.parseInt(br.readLine());
		Deque<Integer> deq = new LinkedList<>();
		
		
		for(int i=N; i>0; i--) {
			deq.offerFirst(i);
			
			for(int j=0; j<i; j++) {
				int tmp = deq.pollLast();
				deq.offerFirst(tmp);

			}

			
		}
		for(int i=0; i<N; i++) {
			bw.write(String.valueOf(deq.pollFirst()));
			if(i<N) {
				bw.write(" ");
			}
		}
		bw.flush();
		bw.close();

	}	

}
