
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Set<Integer> set = new HashSet<>();
		Set<Integer> set_tmp = new HashSet<>();
		for(int i=1;i<=20;i++) {
			set_tmp.add(i);
		}
		for(int i=0;i<n;i++) {
			String [] tmp = br.readLine().split(" ");
			switch(tmp[0]) {
			case "add" : 
				set.add(Integer.parseInt(tmp[1]));
				break;
			case "remove" : 
				//if(set.contains(tmp[1])) {
					set.remove(Integer.parseInt(tmp[1]));
				//}
				break;
			case "check" :
				if(set.contains(Integer.parseInt(tmp[1]))) {
					sb.append("1").append("\n");
				}else {
					sb.append("0").append("\n");
				}
				break;
			case "toggle" :
				if(set.contains(Integer.parseInt(tmp[1]))) {
					set.remove(Integer.parseInt(tmp[1]));
				}else {
					set.add(Integer.parseInt(tmp[1]));
				}
				break;
				
			case "all" :
				set.addAll(set_tmp);
				break;
			case "empty":
				set.clear();
				break;
			}
		}
		System.out.println(sb.toString());
		
	}
}