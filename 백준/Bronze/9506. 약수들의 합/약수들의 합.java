import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		while(N != -1) {
			int sum =0;
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i=1; i<N; i++) {
				if(N%i==0) {
					sum+=i;
					arr.add(i);
				}
			}
			if(N==sum) {
				bw.write(String.valueOf(N)+" = ");
				for(int i=0; i<arr.size(); i++) {
					bw.write(String.valueOf(arr.get(i)));
					if(i<arr.size()-1) {
						bw.write(" + ");
					}
				}
			}else {
				bw.write(String.valueOf(N)+" is NOT perfect.");
			}
			bw.newLine();
			N = Integer.parseInt(br.readLine());
		}
		bw.flush();
		bw.newLine();
		
		
	}
}