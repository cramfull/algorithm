
import java.util.*;
import java.io.*;


public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		int sum=0;
		
		for(int i=M; i<=N; i++) {
			primeNumber(arr, i);
		}
		if(arr.size()!=0) {
			for(int i=0; i<arr.size(); i++) {
				sum += arr.get(i);
			}
			bw.write(String.valueOf(sum));
			bw.newLine();
			bw.write(String.valueOf(arr.get(0)));
			
		}else {
			bw.write("-1");
		}
		bw.flush();
		bw.close();
		
	}
	
	static void primeNumber(ArrayList<Integer> arr, int i) {
		boolean isFind = false;
		if(i==1) {
			isFind = true;
		}
		
		for(int j=2; j<i; j++) {
			
			if(i%j==0) {
				isFind = true;
			}
			
		}
		if(!isFind) {
			arr.add(i);
		}
		
	}
}