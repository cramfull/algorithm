
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		while(str != null) {
			int a=0;
			int b=0;
			int c=0;
			int d=0;
			for(int i=0; i<str.length(); i++) {
				int k = (int)str.charAt(i);
				if(k>=97 && k<=122) {
					a++;
				}else if(k>=65 && k<=90) {
					b++;
				}else if(k>=48 && k<=57) {
					c++;
				}else {
					d++;
				}
			}
			System.out.println(a+" "+b+" "+c+" "+d);
			str = br.readLine();
		}
		
		
		
	}
}