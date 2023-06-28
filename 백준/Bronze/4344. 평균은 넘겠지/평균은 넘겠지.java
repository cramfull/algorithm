
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.Integer;

	
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str;
		int C = Integer.parseInt(br.readLine());
		for(int i =0; i<C; i++) {
			str= new StringTokenizer(br.readLine());
			int student = Integer.parseInt(str.nextToken());
			
			
			int [] grade = new int [student];
			for(int j=0; j<student; j++) {
				grade[j]=Integer.parseInt(str.nextToken());
			}
			int sum=0;
			for(int k=0; k<grade.length; k++) {
				sum += grade[k];
			}
			int mid = sum/student;
						
			int count =0;
			for(int l=0; l<grade.length; l++) {
				if(mid<grade[l]) {
					count++;
				} else {
					continue;
				}
			}
			
			
			float midOver = ((float)count)/((float)student)*100;
			System.out.printf("%.3f"+"%%"+"\n",midOver);
			
			
		}
		
	}
}
