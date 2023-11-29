
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.Map.Entry;

//20231117 X 

public class Main {
	static int [] arr;
	static boolean [] checked;
	static int N;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        arr = new int[N+1];
        checked = new boolean[N+1];
        backTracking(1);
        bw.flush();
        bw.close();
    }
	
	static void backTracking(int x) throws IOException {
		if(x==N+1) {
			for(int i=1;i<arr.length;i++) {
				bw.write(String.valueOf(arr[i]+" "));
			}
			bw.write("\n");
			return;
		}else {
			for(int i=1;i<=N;i++) {
				if(!checked[i]) {
					arr[x] = i;
					checked[i] = true;
					backTracking(x+1);
					checked[i] = false;
				}
			}
		}
		
		
		
	}
	
	
}