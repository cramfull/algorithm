
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		
		String inputA = br.readLine();
		String inputB = br.readLine();
		
		int [] arr = new int[inputA.length()+inputB.length()];
		int [] num = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

		for(int i=0; i<arr.length/2; i++) {
			int x = 2*i;
			int y = 2*i+1;
			arr[x] = num[inputA.charAt(i)-'A'];
			arr[y] = num[inputB.charAt(i)-'A'];
		}
		
		int [] arr2 = new int[arr.length-1];
		
		while(!((arr2.length==1)||(arr.length)==1)) {
			if(arr.length>arr2.length) {
				for(int i=0; i<arr.length-1; i++) {
					arr2[i]=arr[i]+arr[i+1];
					if(arr2[i]>=10) {
						arr2[i]%=10;
					}
				}
				arr=new int[arr2.length-1];
			}else {
				for(int i=0; i<arr2.length-1; i++) {
					arr[i]=arr2[i]+arr2[i+1];
					if(arr[i]>=10) {
						arr[i]%=10;
					}
				}
				arr2=new int[arr.length-1];
			}
		}
		if(arr.length>arr2.length) {
			System.out.println(arr[0]+""+arr[1]);
		}else {
		System.out.println(arr[0]+""+arr[1]);
		}
	}
	
}