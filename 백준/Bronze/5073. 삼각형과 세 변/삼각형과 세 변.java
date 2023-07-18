
import java.io.*;
import java.util.*;
	
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String st = br.readLine();
		
		int [] arr = new int[3];
		
		while(!st.equals("0 0 0")) {
			
			StringTokenizer str = new StringTokenizer(st);
			for(int i=0; i<3; i++) {
				arr[i] = Integer.parseInt(str.nextToken());
			}
			Arrays.sort(arr);
			if(arr[2]<arr[0]+arr[1]) {
				if(arr[0]==arr[1] && arr[1]==arr[2] && arr[0]==arr[2]) {
					System.out.println("Equilateral");
				}else if(arr[0]==arr[1] || arr[1]==arr[2] || arr[0]==arr[2]) {
					System.out.println("Isosceles");
				}else {
					System.out.println("Scalene");
				}
			}else {
				System.out.println("Invalid");
			}
			
			st = br.readLine();
			
		}
		
		
	
	}	

}



