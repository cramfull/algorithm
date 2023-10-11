
import java.io.*;
import java.util.*;
	
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int [] arr = new int[N];
		int [] tmp = new int[N];
		StringTokenizer str = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int k = Integer.parseInt(str.nextToken());
			arr[i]=k;
			tmp[i]=k;
		}
		Arrays.sort(arr);
		int idx=0;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<N;i++) {
			if(map.containsKey(arr[i])) {
				idx++;
				continue;
			}
			map.put(arr[i], i-idx);
		}
		for(int i=0;i<N;i++) {
			sb.append(map.get(tmp[i])+" ");
		}
		System.out.println(sb.toString());
		//정렬 후 맵에 인덱스와 put, containskey -> continue; 
		
		
	}
}