
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.Map.Entry;



public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		String bomb = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		boolean isFind = false;
		for(int i=0;i<input.length();i++) {
			stack.push(input.charAt(i));
			if(stack.size()>=bomb.length()) {
				isFind = true;
				for(int j=0; j<bomb.length();j++) {
					if(stack.get(stack.size()-bomb.length()+j)!=bomb.charAt(j)) {
						isFind = false;
						break;
					}
				}
				if(isFind) {
					for(int k=0;k<bomb.length();k++) {
						stack.pop();
					}
					
				}
				
				
				
					
			}	
		}
		StringBuilder sb = new StringBuilder();
		for(char c : stack) {
			sb.append(c);
		}
		if(sb.length()==0) {
			sb.append("FRULA");
		}
		
		System.out.println(sb.toString());
		
		
	}
}