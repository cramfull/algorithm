
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		Integer [] tree = new Integer [N];
		
		for(int i=0; i<tree.length; i++) {
			tree[i] = Integer.parseInt(str.nextToken());
		}
		Arrays.sort(tree, Collections.reverseOrder());
		
		int max_value = tree[0];
		for(int i=0; i<tree.length; i++) {
			int j = i+1;
			tree[i] += j;
			
			if(max_value<tree[i]) {
				max_value = tree[i];
			}
			
		}
		
		System.out.println(max_value+1);
		
	}
}