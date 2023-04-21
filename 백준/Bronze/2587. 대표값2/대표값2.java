
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;





	
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int [] grade = new int [5];
		int sum=0;
		for(int i=0; i<5; i++) {
			grade[i]= Integer.parseInt(br.readLine());
			sum+= grade[i];
		}
		int tmp=0;
		for(int j=0; j<5; j++) {
			for(int k=j+1; k<5; k++) {
				if(grade[j]>grade[k]) {
					tmp=grade[j];
					grade[j]=grade[k];
					grade[k]=tmp;
				}
			}
		}
		System.out.printf(sum/5+"\n"+grade[2]);
		
		
	}
}















