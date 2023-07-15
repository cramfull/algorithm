
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer str;
		int [] arrX = new int[3];
		int [] arrY = new int[3];
		for(int i=0; i<3; i++) {
			str = new StringTokenizer(br.readLine());
			arrX[i] = Integer.parseInt(str.nextToken());
			arrY[i] = Integer.parseInt(str.nextToken());
		}
		int resultX =0;
		int resultY =0;
		if(arrX[0]==arrX[1]) {
			resultX = arrX[2];
		}else if(arrX[0]==arrX[2]) {
			resultX = arrX[1];
		}else {
			resultX = arrX[0];
		}
		if(arrY[0]==arrY[1]) {
			resultY = arrY[2];
		}else if(arrY[0]==arrY[2]) {
			resultY = arrY[1];
		}else {
			resultY = arrY[0];
		}
		System.out.println(resultX+" "+resultY);
	}
}