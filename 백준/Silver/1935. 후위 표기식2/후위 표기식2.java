
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;



public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Double> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		
		String st = br.readLine();
		
		double [] nums = new double[N];
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		String [] str = st.split("");
		int j=0;

		for(int i=0; i<str.length; i++) {
			switch(st.charAt(i)) {
			case '+':
				continue;
			case '-':
				continue;
			case '*':
				continue;
			case '/':
				continue;			
			}
			str[i]=String.valueOf(nums[st.charAt(i)-'A']);
		}

		for(int i=0; i<str.length; i++) {
			double tmp1 = 0;
			double tmp2 =0;
			switch(str[i]) {
			case "+":
				tmp2 = stack.pop();
				tmp1 = stack.pop();
				stack.add(tmp1+tmp2);
				break;
			case "-":
				tmp2 = stack.pop();
				tmp1 = stack.pop();
				stack.add(tmp1-tmp2);
				break;
			case "*":
				tmp2 = stack.pop();
				tmp1 = stack.pop();
				stack.add(tmp1*tmp2);
				break;
			case "/":
				tmp2 = stack.pop();
				tmp1 = stack.pop();
				stack.add(tmp1/tmp2);
				break;
			default:
				stack.add(Double.parseDouble(str[i]));
			}
		}
		double result = stack.peek();
		System.out.printf("%.2f",result);	
	}
}