

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		myLinkQ mq = new myLinkQ();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer str;
		
		for(int i =0; i<N; i++) {
			str = new StringTokenizer(br.readLine());
			switch(str.nextToken()) {
			case "push" :
				mq.push(Integer.parseInt(str.nextToken()));
				break;
			case "pop" :
				bw.write(String.valueOf(mq.pop()));;
				bw.newLine();
				break;
			case "size" :
				bw.write(String.valueOf(mq.size()));;
				bw.newLine();
				break;
			case "empty" :
				bw.write(String.valueOf(mq.empty()));;
				bw.newLine();
				break;
			case "front" :
				bw.write(String.valueOf(mq.front()));;
				bw.newLine();
				break;
			case "back" :
				bw.write(String.valueOf(mq.back()));;
				bw.newLine();
				break;
			}
		}
		bw.flush();
		bw.close();
		
	}
}

class qNode{
	
	public Integer item;
	public qNode next;
	
	qNode(Integer newItem){
		item = newItem;
		next = null;
	}
	qNode(Integer newItem, qNode newNode){
		item = newItem;
		next = newNode;
	}
}

interface linkQ{
	public void push(int newItem);
	public int pop();
	public int size();
	public int empty();
	public int front();
	public int back();
}

class myLinkQ implements linkQ{
	int numItems;
	qNode tail;
	myLinkQ(){
		tail = null;
		numItems=0;
	}
	
	public void push(int newItem) {
		qNode newNode = new qNode(newItem);
		if(numItems==0) {
			newNode.next = newNode;
			tail = newNode;
		}else {
			newNode.next = tail.next;
			tail.next=newNode;
			tail=newNode;
		}
		numItems++;
	}
	public int pop() {
		int frontTmp;
		if(numItems==0) {
			frontTmp = -1;
		}else {
			frontTmp = tail.next.item;
			if(tail.next==tail) {
				tail=null;
			}else {
				tail.next=tail.next.next;
			}
			numItems--;
		}
		return frontTmp;
		
	}
	public int size() {
		
		return numItems;
		
	}
	public int empty() {
		if(numItems==0) {
			return 1;
		}else {
			return 0;
		}
		
	}
	public int front() {
		if(numItems==0) {
			return -1;
		}else {
			return tail.next.item;
		}
		
	
	}
	public int back() {
		if(numItems==0) {
			return -1;
		}else {
			return tail.item;
		}
		
	}
}












