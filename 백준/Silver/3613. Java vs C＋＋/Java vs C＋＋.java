
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String [] n = s.split("");
		
		StringBuilder sb = new StringBuilder();
		boolean detectJ = false;
		boolean detectC = false;
		
		if((int)n[0].charAt(0)>=65 && (int)n[0].charAt(0)<=90 || n[0].equals("_")){
			System.out.println("Error!");
			return;
		}
		
		for(int i=0;i<n.length;i++) {
			String c= n[i];
			if(c.equals("_")) {
				if(detectJ) {
					System.out.println("Error!");
					return;
				}
				if(i+1<n.length) {
					if(n[i+1].charAt(0)>=65 && n[i+1].charAt(0)<=90 || n[i+1].equals("_")) {
						detectC = false;
						System.out.println("Error!");
						return;
					}
					detectC = true;
					n[i+1] = n[i+1].toUpperCase();	
				}else {
					detectC = false;
					System.out.println("Error!");
					return;
				}
			}else if((int)c.charAt(0)>=65 && (int)c.charAt(0)<=90) {
				if(detectC) {
					if(n[i-1].equals("_")) {
						sb.append(c);
					}else {
						System.out.println("Error!");
						return;
					}
				}else {
					detectJ=true;
					sb.append("_");
					sb.append(c.toLowerCase());
				}

			}else {
				sb.append(c);
			}
		}
		if(detectJ && detectC) {
			System.out.println("Error!");
		}else if(detectJ || detectC){
			System.out.println(sb.toString());
		}else {
			System.out.println(s);
		}
		
		
//		System.out.println((int)'A'+" "+(int)'Z');
//		65, 90
		
		
		
	}

}
