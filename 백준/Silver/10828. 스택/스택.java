
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;






	
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		myStack st = new myStack(N);
		StringTokenizer str;
		
		for(int i=0; i<N; i++) {
			str = new StringTokenizer(br.readLine());
			switch(str.nextToken()){
			case "push" :
				st.push(Integer.parseInt(str.nextToken()));
				break;
			case "pop" :
				System.out.println(st.pop());
				break;
			case "size" :
				System.out.println(st.size());
				break;
			case "empty" :
				System.out.println(st.empty());
				break;
			case "top" :
				System.out.println(st.top());
				break;
			}
			
		}
		
	}
}



interface mymyStack{
	public void push(int x);
	public int pop();
	public int size();
	public int empty();
	public int top();
}


class myStack implements mymyStack{
	private int [] stack;
	private int topIndex;
	
	public myStack(int N) {
		stack = new int[N];
		topIndex = -1;
	}
	
	public void push(int x) {
		stack[++topIndex]=x;
	}
	public int pop() {
		if(topIndex==-1) {
			return -1;
		}else {
		return stack[topIndex--];
		}
	}
	public int size() {
		return topIndex+1;
	}
	public int empty() {
		if(topIndex==-1) {
			return 1;
		} else {
			return 0;
		}
	}
	public int top() {
		if(topIndex==-1) {
			return -1;
		}else {
		return stack[topIndex];
		}
	}
}
