
import java.util.*;
import java.io.*;


public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str;
		
		int [] arr = new int[5];
		int max_index = 0;
		int max_value = 0;
		for(int i=0; i<arr.length; i++) {
			str = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++) {
				arr[i] += Integer.parseInt(str.nextToken());
			}
			if(arr[i]>max_value) {
				max_value = arr[i];
				max_index = i;
			}
		}

		System.out.println((max_index+1)+" "+max_value);
		
		
		
		
		
	}
}