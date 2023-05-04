
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str;
		int N = Integer.parseInt(br.readLine());
		IntegerQueue myQ = new IntegerQueue(N);
		for(int i=0; i<N; i++) {
			str = new StringTokenizer(br.readLine());
			switch(str.nextToken()){
			case "push" :
				myQ.push(Integer.parseInt(str.nextToken()));
				break;
			case "pop" :
				System.out.println(myQ.pop());
				break;
			case "size" :
				System.out.println(myQ.size());
				break;
			case "empty" :
				System.out.println(myQ.empty());
				break;
			case "front" :
				System.out.println(myQ.front());
				break;
			case "back" :
				System.out.println(myQ.back());
				break;
			}
		}
	}

}


interface Queue{
	public void push(int x);
	public int pop();
	public int size();
	public int empty();
	public int front();
	public int back();
}

class IntegerQueue implements Queue{
	int [] queue;
	int front, back, numItems;
	
	public IntegerQueue() {
	}
	public IntegerQueue(int size) {
		queue = new int [size];
		front = 0;
		back = queue.length -1;
		numItems = 0;
	}
	
	
	public void push(int x) {
		back = (back+1)%queue.length;
		queue[back] = x;
		numItems++;
	}
	
	public int pop() {
		int queueTemp;
		if(numItems == 0) {
			return -1;
		}else {
			queueTemp = queue[front];
			front = (front+1)%queue.length;
			numItems--;
			return queueTemp;
		}
	}
	
	public int size() {
		return numItems;
	}
	
	public int empty() {
		if(numItems == 0) {
			return 1;
		}else {
			return 0;
		}
	}
	
	public int front() {
		if(numItems ==0) {
			return -1;
		}else {
			return queue[front];
		}
	}
	
	public int back() {
		if(numItems ==0) {
			return -1;
		}else {
			return queue[back];
		}
		
	}
}

