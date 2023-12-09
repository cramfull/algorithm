
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long multiple = 0;
		String value = "";
		int tmp = 0;
		String [] input = new String[3];
		for(int i=0;i<3;i++) {
			input[i] = br.readLine();
		}
		for(int i=0;i<3;i++) {
			switch(input[i]) {
			case "black":
				tmp = 0;
				break;
			case "brown":
				tmp = 1;
				break;
			case "red":
				tmp = 2;
				break;
			case "orange":
				tmp = 3;
				break;
			case "yellow":
				tmp =4;
				break;
			case "green":
				tmp =5;
				break;
			case "blue":
				tmp = 6;
				break;
			case "violet":
				tmp = 7;
				break;
			case "grey":
				tmp =8;
				break;
			case "white":
				tmp = 9;
				break;
			}
			if(i<2) {
				value+=String.valueOf(tmp);
			}else {
				multiple = (long)Math.pow(10, tmp);
			}
			
		}
		
		multiple *= Long.parseLong(value);
		System.out.println(multiple);
	}
}