

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		Stack stack;
		for(int i=0; i<T; i++) {
			String str = br.readLine()+" ";
			stack = new Stack();
			for(int j =0; j<str.length(); j++) {
				stack.push(str.charAt(j));
				if(str.charAt(j)==' ') {
					stack.pop();
					while(!stack.isEmpty()) {
						bw.write(String.valueOf(stack.peek()));
						stack.pop();
					}
					bw.write(" ");
				}

			}
		}
		bw.flush();
		bw.close();
	}
	
}