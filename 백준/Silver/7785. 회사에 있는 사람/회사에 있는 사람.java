
import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Set<String> set = new HashSet<>();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String log = st.nextToken();
			solv(set, name, log);
		}
		List<String> list = new ArrayList<>(set);
		
		list.sort(Comparator.reverseOrder());
		for(String str : list) {
			System.out.println(str);
		}
		
	}
	public static void solv(Set<String> set, String name, String log) {
		if(log.equals("enter")) {
		set.add(name);
	    }else {
		set.remove(name);
	    }
    }
	

}