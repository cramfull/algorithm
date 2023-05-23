
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;



	
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//N을 받고, 666이 포함된 N번 째 순서(작은 순)
		int N = Integer.parseInt(br.readLine());
		int i = 665;
		int count = 0;
		String result = "";
        //666 포함 시 count++, count==N일 때 루프 끝.
		while(!(count==N)){
			i++;
			result = String.valueOf(i);
			if(result.contains("666")) {
				count++;
			}
		}
        //출력
		bw.write(result);
		bw.flush();
		bw.close();	
	}	
}
