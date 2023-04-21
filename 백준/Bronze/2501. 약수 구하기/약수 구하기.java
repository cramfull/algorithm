
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;




	
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(str.nextToken());
		int k = Integer.parseInt(str.nextToken());
		
		ArrayList<Integer> arr = new ArrayList<>(); 
		for(int i=1; i<=N; i++) {
			if(N%i == 0) {
				arr.add(i);
			}
		}
		if(arr.size()<k) {
			System.out.println("0");
		} else {
			System.out.println(arr.get(k-1));
		}
		
		
	}
}















