
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;





	
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 0;
		
		for(int i=0; i<4; i++) {
			N+= Integer.parseInt(br.readLine());
		}
		
		
		System.out.println(N/60);
		System.out.println(N%60);
		
	}
	
}















