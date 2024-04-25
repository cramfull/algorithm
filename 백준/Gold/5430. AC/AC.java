
import java.util.*;
import java.io.*;

public class Main {
	static boolean err = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for(int i=0;i<T;i++) {
			err = false;
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			StringTokenizer str = new StringTokenizer(br.readLine(),",|[|]");
			Deque<Integer> deq = new LinkedList<>();
			
			
			for(int j=0; j<n;j++) {
				deq.add(Integer.parseInt(str.nextToken()));
			}
			
			
			boolean fb = false;
			
			
			for(int j=0;j<p.length();j++) {
				char c = p.charAt(j);
				if(c=='R') {
					fb = !fb;
				}else {
					deqD(fb, deq);
				}
			}
			


			if(err) {
				sb.append("error");
			}else {
				int g = deq.size();
				if(g==0) {
					sb.append("[]");
				}else {
					sb.append("[");
					if(fb) {
						for(int j=0;j<g;j++) {
							sb.append(deq.removeLast());
							sb.append(",");
						}
					}else {
						for(int j=0;j<g;j++) {
							sb.append(deq.removeFirst());
							sb.append(",");
						}
					}
					sb.deleteCharAt(sb.length()-1);
					sb.append("]");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void deqD(boolean fb, Deque<Integer> deq) {
		if(deq.size()==0) {
			err = true;
			return;
		}
		
		if(fb) {
			deq.removeLast();
		}else {
			deq.removeFirst();
		}
	}

}
