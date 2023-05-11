

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		HashSet hm;
		ArrayList arr;
		for(int i=0; i<N; i++) {
			int count = 0;
			int countG = 0;
			String str = br.readLine();
			//입력받은 문자열의 문자가 바뀌는 횟수 => 검사문 
			for(int j =0; j<str.length()-1; j++) {
				if(str.charAt(j)!=str.charAt(j+1)) {
					count++;
				}
			}

			arr = new ArrayList(Arrays.asList(str.split("")));
			hm = new HashSet(arr);
			countG = hm.size()-1;

			
			//그룹단어의 문자가 바뀌는 횟수 => 중복제거한 문자의 개수-1
			if(count==countG) {
				result++;
			}
		}
		
		
		System.out.println(result);
		
	}
}
