import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer str;
    	int N = Integer.parseInt(br.readLine());
    	
    	Stack<Integer> stack = new Stack<>();
    	
    	for(int i=0; i<N; i++) {
    		str = new StringTokenizer(br.readLine());
        	switch(str.nextToken()) {
        	case "push":
        		stack.push(Integer.parseInt(str.nextToken()));
        		break;
        	case "pop":
        		if(stack.empty()) {
        			bw.write("-1");
        			bw.newLine();
        		}else {
        			int tmp = stack.peek();
        			stack.pop();
        			bw.write(String.valueOf(tmp));
        			bw.newLine();
        		}
        		break;
        	case "size":
        		bw.write(String.valueOf(stack.size()));
        		bw.newLine();
        		break;
        	case "empty":
        		if(stack.empty()) {
        			bw.write("1");
        		}else {
        			bw.write("0");
        		}
        		bw.newLine();
        		break;
        	case "top":
        		if(stack.empty()) {
        			bw.write("-1");
        		}else {
        			bw.write(String.valueOf(stack.peek()));
        		}
        		bw.newLine();
        		break;
        	}

    	}
    	
    	bw.flush();
    	bw.close();
    	
    }
}
