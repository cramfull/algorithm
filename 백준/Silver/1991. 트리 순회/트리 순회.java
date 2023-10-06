
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.Map.Entry;



public class Main {
	static LinkedList<Node> tree = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	static class Node{
		int idx;
		String item;
		Node left;
		Node right;
		
		public Node(String item) {
			this.item = item;
			left = null;
			right = null;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			
			String tmpI = str.nextToken();
			String tmpL = str.nextToken();
			String tmpR = str.nextToken();
			Node nowNode = isFind(tmpI);
			if(nowNode==null) {
				 nowNode = new Node(tmpI);
				 nowNode.idx=tree.size();
				tree.add(nowNode);
			}
			if(!tmpL.equals(".")) {
				Node LNode = isFind(tmpL);
				if(LNode==null) {
					LNode = new Node(tmpL);
					LNode.idx=tree.size();
					tree.add(LNode);
				}
				tree.get(nowNode.idx).left = LNode;
			}
			if(!tmpR.equals(".")) {
				Node RNode = isFind(tmpR);
				if(RNode==null) {
					RNode = new Node(tmpR);
					RNode.idx=tree.size();
					tree.add(RNode);
				}
				tree.get(nowNode.idx).right = RNode;
			}
			
			
			
			
		}
		
	
		
		/*
		for(int i=0;i<tree.size();i++) {
				System.out.print(tree.get(i).item+" ");
				try {
					System.out.print(tree.get(i).left.item+" ");
				}catch(Exception e){
					System.out.print(". ");
				}
				try {
					System.out.print(tree.get(i).right.item+" ");
				}catch(Exception e){
					System.out.print(". ");
				}
				
				System.out.println();
		}
		*/
		
		VLR(tree.get(0));
		sb.append("\n");
		LVR(tree.get(0));
		sb.append("\n");
		LRV(tree.get(0));
		System.out.println(sb.toString());
	}
	
	static void VLR(Node t) {
		sb.append(t.item);
		if(t.left!=null) {
			Node nxt = t.left;
			VLR(nxt);
		}
		if(t.right!=null) {
			Node nxt = t.right;

			VLR(nxt);
		}
	}
	static void LVR(Node t) {
		if(t.left !=null) {
			LVR(t.left);
		}
		sb.append(t.item);
		if(t.right !=null) {
			LVR(t.right);
		}
		
		
	}
	static void LRV(Node t) {
		if(t.left !=null) {
			LRV(t.left);
		}
		if(t.right !=null) {
			LRV(t.right);
		}
		sb.append(t.item);
	}
	
	
	
	
	static Node isFind(String tmpI) {
		boolean ex = false;
		Node tmpNode=null;
		for(int j=0;j<tree.size();j++) {
			tmpNode = tree.get(j);
			if(tmpNode.item.equals(tmpI)) {
				ex = true;
				break;
				}
			}
		if(ex) {
			return tmpNode;
		}else {
			return null;
		}
		
		
	}
}















