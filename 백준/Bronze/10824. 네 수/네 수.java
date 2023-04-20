
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;



	
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] str = br.readLine().split(" ");
		String AB = str[0]+str[1];
		String CD = str[2]+str[3];
		System.out.println(Long.parseLong(AB)+Long.parseLong(CD));
	}
}











