
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;



public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int [] order = new int[N];
		String list = br.readLine();
		StringTokenizer str = new StringTokenizer(list);
		for(int i=0; i<N; i++) {
			order[i] = Integer.parseInt(str.nextToken());
		}
		Stack<Integer> stack = new Stack<>();
		
		String check = "";
		
		int stu = 1;
		int idx = 0;
		while(idx<N) {
			if(order[idx]==stu) {
				check += order[idx];
				check+=" ";
				stu++;
				idx++;
			}else {
				if(!(stack.isEmpty())&&stack.peek().equals(stu)) {
					check+=stack.pop();
					check+=" ";
					stu++;
				}else {
					stack.push(order[idx]);
					idx++;
				}
			}
			
		}
		while(!stack.isEmpty()) {
			check += stack.pop();
			if(stack.size()>0) {
				check+= " ";
			}
		}
		String [] checkArr = check.split(" ");
		Arrays.sort(order);
		
		if(Arrays.toString(checkArr).equals(Arrays.toString(order))) {
			System.out.println("Nice");
		}else {
			System.out.println("Sad");
		}
		
		
		
		
	}
}