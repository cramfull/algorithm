import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;



	
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//N 값 입력받기 
		int N = Integer.parseInt(br.readLine());
		//새로운 수 생성 
		int tmp = 0;
		//새로운 수와 N값 비교하며 반복하여 횟수 저장 
		int count = 0;
		if(N==0) {
			count=1;
		}
		while(N!=tmp) {
			if(count==0) {
				tmp= (N%10)*10 + (((N/10)+(N%10))%10);
				count+=1;
			} else {
				tmp = (tmp%10)*10 + (((tmp/10)+(tmp%10))%10);
				count+=1;
			}
		}
		System.out.println(count);
	}
}











