
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int [] arr = new int[3];
		
		for(int i=0; i<3; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
		}
		Arrays.sort(arr);
		
		int two = arr[0] + arr[1];

		while(arr[2]>=two) {
				arr[2]--;
		}
		
		System.out.println(arr[2]+two);
		
		
	}
}