
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.io.*;
import java.math.*;


public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// Map<Integer,Integer> note1 = new HashMap<>();			
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			int M1 = Integer.parseInt(br.readLine());
			String [] note1 = br.readLine().split(" ");
			int M2 = Integer.parseInt(br.readLine());
			Map<String,Integer> note2 = new LinkedHashMap<>();		
			String [] tmp = br.readLine().split(" ");
			for(int j=0;j<M2;j++) {
				note2.put(tmp[j], 0);
			}
			for(int j=0;j<M1;j++) {
				if(note2.containsKey(note1[j])) {
					note2.put(note1[j], 1);
				}
			}
			for(int j=0;j<M2;j++) {
				bw.write(String.valueOf(note2.get(tmp[j])));
				bw.newLine();
			}
			
			
			
			
		}
		bw.flush();
		bw.close();
		
		
		
	}
}

