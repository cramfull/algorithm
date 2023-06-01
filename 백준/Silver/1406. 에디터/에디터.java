
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;



public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String st = br.readLine();
		int M = Integer.parseInt(br.readLine());
		Stack<String> stack1 = new Stack<>();
		for(int i=0; i<st.length(); i++) {
			stack1.push(String.valueOf(st.charAt(i)));
		}
		Stack<String> stack2 = new Stack<>();
		
		StringTokenizer str;
		for(int i=0; i<M; i++) {
			str = new StringTokenizer(br.readLine());
			switch(str.nextToken()) {
			case "L":
				if(!stack1.isEmpty()) {
					stack2.push(stack1.pop());
				}
				break;
			case "D":
				if(!stack2.isEmpty()) {
					stack1.push(stack2.pop());
				}
				break;
			case "B":
				if(!stack1.isEmpty()) {
					stack1.pop();
				}
				break;
			case "P":
				String tmp = str.nextToken();
				stack1.push(tmp);
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!stack1.isEmpty()) {
			sb.append(stack1.pop());
		}
		sb.reverse();
		while(!stack2.isEmpty()) {
			sb.append(stack2.pop());
		}
		System.out.println(sb);
	}
	
	
	
}