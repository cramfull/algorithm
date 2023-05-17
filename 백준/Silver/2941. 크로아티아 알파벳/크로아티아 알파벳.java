

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		int result = str.length();
		for(int i=0; i<str.length(); i++) {
			if(i>0) {
				switch(str.charAt(i)) {
				case '=':
					if(str.charAt(i-1)=='c') {
						result--;
					} else if(str.charAt(i-1)=='s') {
						result--;
					} else if(str.charAt(i-1)=='z') {
						if(i>1) {
							if(str.charAt(i-2)=='d') {
								result--;
							}
						}
						result--;
					}
					break;
				case '-':
					if(str.charAt(i-1)=='c') {
						result--;
					}else if(str.charAt(i-1)=='d') {
						result--;
					}
					break;
				case 'j':
					if(str.charAt(i-1)=='l') {
						result--;
					}else if(str.charAt(i-1)=='n') {
						result--;
					}
					break;
				}
			}
		}
		System.out.println(result);
		
		
	}
}