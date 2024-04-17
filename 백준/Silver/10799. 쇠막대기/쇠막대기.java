
import java.util.*;
import java.io.*;


public class Main {
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String steal = br.readLine();
		Stack<Character> st = new Stack<>();
		int sum =0;
		for(int i=0;i<steal.length();i++) {
			char c = steal.charAt(i);
			if(c=='(') {
				st.push(c);
				sum+=1;
			}else {
				if(steal.charAt(i-1)==')') {
					// 레이저를 안쏠 
					st.pop();
				}else {
					// 레이저를 쏨
					// 쇠막대기 처음 부분 더하는거.. 생각해봐 
					sum-=1;
					st.pop();
					sum+=st.size();
					
				}
			}

			
			
		}
		System.out.println(sum);
	}

}
