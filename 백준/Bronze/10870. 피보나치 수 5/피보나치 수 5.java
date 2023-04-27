
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

	
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Fibo myFibo = new Fibo();
		
		int result;
		result = myFibo.getFibo(N);
		
		System.out.println(result);
		
		
	}
}


class Fibo{
	int result;
	int getFibo(int x) {
		// 0과 1일 경우 예외처
		if(x==0) {
			return 0;
		} else if(x==1) {
			return 1;
		} else {
			result = getFibo(x-1) + getFibo(x-2);
		}
		
		
		
		return result;
	}
}










