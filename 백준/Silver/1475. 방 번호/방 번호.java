
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	static long result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int [] arr = new int[11];
		int maxValue = 0;
		int maxIdx = 0;
		String num = String.valueOf(N);
		
		for(int i=0;i<num.length();i++) {
			char tmp = num.charAt(i);
			int k = Character.getNumericValue(tmp);
			arr[k]+=1;
			if(maxValue<arr[k]) {
				maxValue = arr[k];
				maxIdx = k;
			}
			if(maxValue == arr[k]) {
				if(maxIdx==6||maxIdx==9) {
					maxValue = arr[k];
					maxIdx = k;
				}
			}
		}
		arr[10] = arr[6]+arr[9];
		
		if(maxIdx==6||maxIdx==9) {
			if(arr[10]!=arr[maxIdx]) {
				if(arr[10]%2==0) {
					maxValue = arr[10]/2;

				}else {
					maxValue = arr[10]/2+1;

				}
			}else {
				if(arr[6]==0||arr[9]==0) {
					if(arr[maxIdx]%2==0) {
						maxValue = arr[10]/2;
					}else {
						maxValue = arr[10]/2+1;
					}
				}
			}
		}
		System.out.println(maxValue);
		
	}
}