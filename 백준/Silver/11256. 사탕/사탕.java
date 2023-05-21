
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;



	
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			int J = Integer.parseInt(str.nextToken());
			int N = Integer.parseInt(str.nextToken());
			int [] arrN = new int [N];
			for(int a=0; a<N; a++) {
				str = new StringTokenizer(br.readLine());
				int r= Integer.parseInt(str.nextToken());
				int c =Integer.parseInt(str.nextToken());
				arrN[a] = r*c;
			}
			ArrayList<Integer> arr = new ArrayList<>();
			for(int c=0; c<N; c++) {
				arr.add(arrN[c]);
			}
			arr.sort(Comparator.reverseOrder());
			
			int result = 0;
			for(int b=0; b<N; b++) {
				if(J<=0) {
					result = b;
					break;
				}
				J-=arr.get(b);
			}
			bw.write(String.valueOf(result));
			bw.newLine();
		}
		bw.flush();
		bw.close();


	}	

}
