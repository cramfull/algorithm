
import java.io.*;
import java.math.*;
import java.util.*;

public class Main {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Set<String> setN = new TreeSet<>();
		for(int i=0; i<n; i++) {
			setN.add(br.readLine());
		}
		Set<String> setM = new HashSet<>();
		for(int i=0; i<m; i++) {
			setM.add(br.readLine());
		}
		setN.retainAll(setM);
		System.out.println(setN.size());
		for(String s : setN) {
			System.out.println(s);
		}
		
	}
	

	
}