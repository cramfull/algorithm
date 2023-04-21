
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;




	
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] N = br.readLine().split("");
		
		
		String tmp="";
		for(int i=0; i<N.length-1; i++) {
			for(int j=i+1; j<N.length; j++) {
				if(Integer.parseInt(N[i])<Integer.parseInt(N[j])) {
					tmp = N[i];
					N[i]=N[j];
					N[j]=tmp;
				}
			}
		}
		String result="";
		for(int k=0; k<N.length; k++) {
			result+=N[k];
		}
		System.out.println(result);
		
		
		
	}
}











