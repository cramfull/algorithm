
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;



public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			String [] str = br.readLine().split(" ");
			int mid = (int)(str[0].charAt(0));
			Deque<Character> deq = new LinkedList<>();
			deq.offer(str[0].charAt(0));
			for(int j=1; j<str.length; j++) {
				int target = (int)str[j].charAt(0);
				int first = (int)deq.peekFirst();
				if(target <= first ) {
					deq.offerFirst((char)target);
					continue;
				}else if(first < target && target<mid) {
					deq.offerLast((char)target);
				}else {
					deq.offerLast((char)target);
				}
			}
			String result = "";
			while(!(deq.isEmpty())) {
				result += deq.pollFirst();
			}
			bw.write(result);
			if(i<T-1) {
				bw.newLine();
			}
		}
		bw.flush();
		bw.close();
		
		
		
	}
	
	
	
}