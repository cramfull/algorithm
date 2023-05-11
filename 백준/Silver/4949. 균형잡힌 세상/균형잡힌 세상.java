

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character>stack;
		String input = "";
		
		while(!((input=br.readLine()).equals("."))) {
			stack = new Stack<>();
			for(int m =0; m<input.length(); m++) {
				if(input.charAt(m)=='(') {
					stack.push('(');
				}else if(input.charAt(m)=='[') {
					stack.push('[');
				}else if(input.charAt(m)==')') {
					if(stack.isEmpty()) {
						stack.push(')');
					}else {
						if(stack.peek() =='(') {
							stack.pop();
						}else {
							stack.push(')');
						}
					}
				}else if(input.charAt(m)==']') {
					if(stack.isEmpty()) {
						stack.push(']');
					}else {
						if(stack.peek() == '[') {
							stack.pop();
						}else {
							stack.push(']');
						}
					}
				}
				if(input.charAt(m)=='.') {
					if(stack.isEmpty()) {
						System.out.println("yes");
					}else {
						System.out.println("no");
					}
				}
			}
			
		}
		
		
		
		
	}
}