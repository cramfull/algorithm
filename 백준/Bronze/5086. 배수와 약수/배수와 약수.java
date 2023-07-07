
import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean isClear = false;
		while(!isClear) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			if(a==0 && b==0) {
				isClear = true;
				break;
			}
			if(a<b) {
				if(b%a==0) {
					bw.write("factor");
				}else {
					bw.write("neither");
				}
			}else {
				if(a%b==0) {
					bw.write("multiple");
				}else {
					bw.write("neither");
				}
			}
			bw.newLine();
			
		
		}
		bw.flush();
		bw.close();
		
		
		
		
	}
}