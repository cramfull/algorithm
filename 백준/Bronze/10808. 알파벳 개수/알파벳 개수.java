
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char [] str = br.readLine().toCharArray();
		char c = 97;

		
		int [] charList = new int[26];
		for(int i=0; i<charList.length; i++) {
			charList[i] = 0;
		}
		
		for(int i=0; i<str.length; i++) {
			charList[str[i]-c]++;
		}
		
		for(int i=0; i<charList.length; i++) {
			if(i<charList.length-1) {
			System.out.printf(charList[i]+" ");
			} else {
				System.out.print(charList[i]);
			}
		}
		
				
	}
}