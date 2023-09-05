
import java.io.*;
import java.util.*;
import java.util.Map.Entry;


public class Main {	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		Map<String, Integer> map = new HashMap<>();

		
		
		for(int i=0; i<N; i++) {
			map.put(st.nextToken(), 0);
		}
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				String k = st.nextToken();
				map.replace(k, map.get(k)+1);
			}
		}
		
		List<Map.Entry<String, Integer>> entrylist = new LinkedList<>(map.entrySet());
		
		entrylist.sort(new Comparator<Map.Entry<String, Integer>>(){

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				if(o2.getValue()==o1.getValue()) {
					return o1.getKey().compareTo(o2.getKey());
				}
				return o2.getValue()-o1.getValue();
			}
			
		});
		
		for(Map.Entry<String, Integer> entry : entrylist) {
			bw.write(entry.getKey()+" "+String.valueOf(entry.getValue()));
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
		
		
		
		
	}
}