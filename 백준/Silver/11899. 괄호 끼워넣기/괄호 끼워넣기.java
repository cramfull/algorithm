
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;



public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String [] str = br.readLine().split("");
		Stack<String> stack = new Stack<>();
		for(int j=0; j<str.length; j++) {
			switch(str[j]) {
			case "(":
				stack.push(str[j]);
				continue;
			case ")":
				if(stack.isEmpty()) {
					stack.push(str[j]);
					continue;
				}
				if(stack.peek().equals("(")) {
					stack.pop();
					continue;
				}else {
					stack.push(str[j]);
				}
			}
		}
		System.out.println(stack.size());
		
	}
}