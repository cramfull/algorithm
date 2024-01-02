
import java.io.*;
import java.util.*;

public class Main {
	static String st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = br.readLine();
		
		int k = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<k;i++){
			StringTokenizer str = new StringTokenizer(br.readLine());
			char target = str.nextToken().charAt(0);
			member temp = new member(target);

			int start = Integer.parseInt(str.nextToken());
			int end = Integer.parseInt(str.nextToken());
			
			if(start == 0) {
				sb.append(temp.arrSum[end]).append("\n");
			}else {
				sb.append(temp.arrSum[end]-temp.arrSum[start-1]).append("\n");
			}
			
			
		}
		System.out.println(sb.toString());
		
		
	}

	static class member{
		char target;
		int [] arr;
		int [] arrSum;
		
		public member(char a) {
			this.target = a;
			arr = new int[st.length()];
			arrSum = new int [st.length()];
			
			int sumtemp = 0;
			for(int i=0;i<st.length();i++) {
				if(target==st.charAt(i)) {
					arr[i] = 1;
				}
				sumtemp+=arr[i];
				arrSum[i]=sumtemp;
				
				
			}
			
			
		}
		
	}
	
	
	
}
