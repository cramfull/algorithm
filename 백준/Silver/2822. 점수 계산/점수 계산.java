
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Integer score [] = new Integer[8];
		Integer idx [] = new Integer[8];
		
		for(int i=0; i<8; i++) {
			int k = Integer.parseInt(br.readLine());
			score[i]=k;
			idx[i]=k;
		}
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(score));
		ArrayList<Integer> id = new ArrayList<>(Arrays.asList(idx));
		arr.sort(Comparator.reverseOrder());
		int sum =0;
		for(int i=0; i<5; i++) {
			sum+=arr.get(i);
		}
		bw.write(String.valueOf(sum));
		bw.newLine();
		int resultIdx [] = new int [5];
		for(int i=0; i<5; i++) {
			resultIdx[i] = id.indexOf(arr.get(i));;
			}
		Arrays.sort(resultIdx);
		for(int i=0; i<5; i++) {
			bw.write(String.valueOf(resultIdx[i]+1));
			if(i<5) {
				bw.write(" ");
			}
		}
		bw.flush();
		bw.close();
		
		
	}
}
