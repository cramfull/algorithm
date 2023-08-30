
import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int [] arrA = new int[N];
		st = new StringTokenizer(br.readLine());
		arrA = getArray(st, arrA);
		Integer [] arrB = new Integer[N];
		st = new StringTokenizer(br.readLine());
		arrB = getArray(st, arrB);
		ArrayList<Integer> listB = new ArrayList<>(Arrays.asList(arrB));
		Arrays.sort(arrA);
		
		int maxB = 0;
		int tmp =0;
		int sum =0;

		
		for(int i=0; i<N; i++) {
			maxB = listB.get(0);
			tmp =0;
			for(int j=0; j<listB.size(); j++) {
				if(maxB<listB.get(j)) {
					maxB = listB.get(j);
					tmp = j;
				}
			}
			sum += arrA[i]*maxB;
			listB.remove(tmp);

		}
		
		System.out.println(sum);
	}
	
	
	
	
	static int [] getArray(StringTokenizer st, int [] arr) {
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		return arr;
	}
	static Integer [] getArray(StringTokenizer st, Integer [] arr) {
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		return arr;
	}
}