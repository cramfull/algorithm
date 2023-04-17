
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;



	
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//N을 5로 나눈 최대치와 남은 나머지를 3으로 나눴을 때
		//5와3으로 나누어 떨어지지 않을 때 -1
		
		int N = Integer.parseInt(br.readLine());
		
		int i= N/5;
		int j=0;// = (N- 5*i)/3;;
		j = (N- 5*i)/3;
		// (5 * i) + (3 * j) = N
		// i의 최대값일 때, j
		// 나누어 떨어지지 않을 때, i-- 후 다시 검사
		if(N ==3) {
			System.out.println(1);
		}else if(N==4 || N==7) {
			System.out.println(-1);
		}
		else if(N%(5*i) == 0) {
			System.out.println(i+j);
		} else if( N%(5*i) != 0) {
			
			while(i>0) {
					if(5*i + 3*j == N) {
						break;
					} else {
						i--;
						j = (N- 5*i)/3;
						
					}
				}
			System.out.println(i+j);
			}else {
		System.out.println("-1");
		}
	}
}











