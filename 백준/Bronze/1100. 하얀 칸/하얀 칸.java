
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;



	
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = 0;
		for(int i = 1; i<=8;i++) {
			String [] str = br.readLine().split("");
			if(i%2 != 0) {
				for(int j = 0; j<4; j++) {
					if(str[2*j].equals("F")) {
						count+=1;
					}
				}
			} else {
				for(int j = 0; j<4; j++) {
					if(str[2*j+1].equals("F")) {
						count+=1;
					}
			}
			}
		}
		System.out.println(count);
	}
}











