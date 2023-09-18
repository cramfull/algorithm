
import java.io.*;
import java.util.*;


public class Main {	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int arr [] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int target = Integer.parseInt(st.nextToken());
			try {
				boolean bi = target == arr[Arrays.binarySearch(arr, target)];
				if(bi == true) {
					bw.write("1");}
			}catch(Exception e) {
				bw.write("0");
			}
			bw.newLine();
			
		}
		bw.flush();
		bw.close();
		
		
	}
}