
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		Set<String> set = new HashSet<>();
		for(int i=0;i<N;i++) {
			String s = st.nextToken();
			
			if(s.endsWith("Cheese")){
				set.add(s);
			}
		}
		
		if(set.size()>=4) {
			System.out.println("yummy");
		}else {
			System.out.println("sad");
		}
		
		
		
	}
	
}