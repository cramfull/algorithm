

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<String> stack = new Stack<>();
		String str = br.readLine();
		
		String result = "";
		
		
		int i =0;
		while(i<str.length()) {
			if(str.charAt(i)=='<') {
				if(!(stack.isEmpty())) {
					while(!(stack.isEmpty())) {
					result += stack.pop();
					}
				}
				while(str.charAt(i)!='>') {
				result+=str.charAt(i);
				i++;
				continue;
				}
				result+=str.charAt(i);
				i++;
				continue;
			}else {
				if(str.charAt(i)==' ') {
					while(!(stack.isEmpty())) {
						result += stack.pop();
						}
					result+= " ";
					i++;
					continue;
				}
				stack.push(String.valueOf(str.charAt(i)));
				i++;
				continue;
			}
		}
		
		if(!(stack.isEmpty())) {
			while(!(stack.isEmpty())) {
				result +=stack.pop();
			}
		}
		System.out.println(result);
		
		
	}
}