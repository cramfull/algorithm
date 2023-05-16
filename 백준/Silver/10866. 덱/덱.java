

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
		DequeI deq = new DequeI(N);
		StringTokenizer str;
		
		for(int i=0; i<N; i++) {
			str = new StringTokenizer(br.readLine());
			switch(str.nextToken()) {
			case "push_front":
				deq.push_front(Integer.parseInt(str.nextToken()));
				break;
			case "push_back":
				deq.push_back(Integer.parseInt(str.nextToken()));
				break;	
			case "pop_front":
				bw.write(String.valueOf(deq.pop_front()));;
				bw.newLine();
				break;
			case "pop_back":
				bw.write(String.valueOf(deq.pop_back()));
				bw.newLine();
				break;
			case "size":
				bw.write(String.valueOf(deq.size()));
				bw.newLine();
				break;
			case "empty":
				bw.write(String.valueOf(deq.empty()));
				bw.newLine();
				break;
			case "front":
				bw.write(String.valueOf(deq.front()));
				bw.newLine();
				break;
			case "back":
				bw.write(String.valueOf(deq.back()));
				bw.newLine();
				break;
			}
		}
		bw.flush();
		bw.close(); br.close();
		
		
		
		}
	
}

interface DequeG<Integer>{
	public void push_front(int x);
	public void push_back(int x);
	public int pop_front();
	public int pop_back();
	public int size();
	public int empty();
	public int front();
	public int back();
}



class DequeI<Integer> implements DequeG<Integer>{
	private int [] array;
	private int numItems;
	private int front , back ;
	
	DequeI(){
	}
	DequeI(int N) {
		array = new int[N];
		numItems = front = back = 0;
	}
	
	
	
	public void push_front(int x) {
		array[front] = x;
		front = (front-1+array.length)%array.length;
		numItems++;
	}
	public void push_back(int x) {
		back = (back+1)%array.length;
		array[back] = x;
		numItems++;
	}
	public int pop_front() {
		if(numItems == 0) {
			return -1;
		}else {
			front = (front+1)%array.length;
			int frontTmp = array[front];
			array[front]=0;
			numItems--;
			return frontTmp;
		}
		
	}
	public int pop_back() {
		if(numItems == 0) {
			return -1;
		}else {
			int backTmp = array[back];
			array[back] = 0;
			back = (back-1+array.length)%array.length;
			numItems--;
			return backTmp;
		}
	}
	public int size() {
		return numItems;
	}
	public int empty() {
		if(numItems ==0) {
			return 1;
		}else {
			return 0;
		}
	}
	public int front() {
		if(numItems==0) {
			return -1;
		}else {
			return array[(front+1)%array.length];
		}
	}
	public int back() {
		if(numItems==0) {
			return -1;
		}else {
			return array[back];
		}
	}
}














