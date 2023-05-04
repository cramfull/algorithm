
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			String Line = "";
			Line = br.readLine();
			vpsStack vps = new vpsStack(Line);
			vps.push(Line);
			System.out.println(vps.isEmpty());
		}
		
		
	}

}



interface Stack{
	
	public void push(String a);
	
	public void pop();
	
	public String isEmpty();
	
}

class vpsStack implements Stack{
	int topIndex;
	String [] str;
	
	public vpsStack(){
		
	}
	public vpsStack(String str) {
		this.str = new String [str.length()];
		
		topIndex = -1;
	}
	
	public void push(String a) {
		for(int j =0; j<a.length(); j++) {
			if(a.charAt(j)=='(') {
				str[++topIndex]="(";
			}else {
				if(topIndex!=-1&&str[topIndex].equals("(")) {
					pop();
				} else {
					str[++topIndex]=")";
				}
			}
		}
		
	}
	
	public void pop() {
		str[topIndex--]=null;
	}
	
	public String isEmpty() {
		if(topIndex == -1) {
			return "YES";
		}else{
			return "NO";
		}
	}
}





