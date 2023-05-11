

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		str = str.toUpperCase();
		
		// A~Z까지의 인트형 배열 생성, char로 해당 값 인덱스 위치의 값 증가
		int [] alp = new int[26];
		
		for(int i=0; i<str.length(); i++) {
			alp[str.charAt(i) - 'A']++;
		}
		
		int tmp =0;
		int manyAlp =0;
		for(int i=0; i<alp.length; i++) {
			if(tmp<alp[i]){
				tmp = alp[i];
				manyAlp = i;
			}
		}
		int result =0;
		for(int i=0; i<alp.length; i++) {
			if(alp[i]==tmp) {
				result++;
			}
		}
		if(result!=1) {
			System.out.println("?");
		}else {
			System.out.println((char)(manyAlp+'A'));
		}
		
		
		// 'A'는 65
		// 인덱스가 같은 값이 있는지 검사
		// 있다면 ? 출력 없다면 해당 값 인덱스 char로 변환하여 출력
		
		
		
		
		
		
		
	}
}
