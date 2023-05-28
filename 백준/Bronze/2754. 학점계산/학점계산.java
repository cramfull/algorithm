
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String [] input = br.readLine().split("");
		
		String alp = input[0];
		String opr = "0";
		if(alp.equals("F")) {
			opr="0";
		}else {
			opr = input[1];
		}
		float grade=0;
		
		
		switch(alp) {
		case "A":
			grade+=4;
			break;
		case "B":
			grade+=3;
			break;
		case "C":
			grade+=2;
			break;
		case "D":
			grade+=1;
			break;
		case "F":
			
			break;
		
		}
		
		switch(opr) {
		case "+":
			grade+=0.3;
			break;
		case "0":
			break;
		case "-":
			grade-=0.3;
			break;
		}
		
		bw.write(String.valueOf(grade));
		bw.flush();
		bw.close();
	}
}