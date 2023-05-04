
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		zeroGame zero = new zeroGame(K);
		
		for(int i=0; i<K; i++) {
			int money = Integer.parseInt(br.readLine());
			if(money ==0) {
				zero.pop();
			}else {
				zero.push(money);
			}
		}
		System.out.println(zero.sum());
	}
}


interface Stack{
	public void push(int x);
	public void pop();
}

class zeroGame implements Stack{
	int [] list;
	int topIndex;
	
	zeroGame(){}
	
	zeroGame(int size){
		list = new int[size];
		topIndex = -1;
	}
	
	public void push(int x) {
		list[++topIndex] = x;
		
	}
	public void pop() {
		if(topIndex!=-1) {
			list[topIndex--]=0;
		}
	}
	
	public int sum() {
		int listSum=0;
		for(int i=0; i<=topIndex; i++) {
			listSum+=list[i];
		}
		return listSum;
	}
}