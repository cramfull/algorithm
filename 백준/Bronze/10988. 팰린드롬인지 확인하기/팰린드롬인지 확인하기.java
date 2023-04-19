
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;



	
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int result = 0;
		char [] pelin = str.toCharArray();
		for(int i =0; i<pelin.length;  i++) {
			int j=((pelin.length-1) -i);
			
			if(pelin[i] == pelin[j]) {
				result += 1;
			}else {
				result +=0;

			}
		
		
		}
		if(result==pelin.length) {
			System.out.println("1");
		}else {
			System.out.println("0");
		}

	}
}
