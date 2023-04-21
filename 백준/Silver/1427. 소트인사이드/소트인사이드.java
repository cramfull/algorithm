
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Arrays;



	
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String []N = (br.readLine()).split("");
		ArrayList als = new ArrayList(Arrays.asList(N));
		int max;
		
		als.sort(Comparator.reverseOrder());
		
		String result="";
		for(int i=0; i<als.size(); i++) {
			result+=als.get(i);
		}
		System.out.println(result);
    }
}