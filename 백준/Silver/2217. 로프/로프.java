
import java.util.Arrays;
import java.util.Scanner;

 

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	

    	int n = sc.nextInt();
    	
    	int [] lope = new int[n];
    	for(int i=0;i<lope.length;i++) {
    		lope[i]=sc.nextInt();
    	}
    	Arrays.sort(lope);
    	
    	int [] result = new int[n];
    	
    	for(int i=0;i<result.length;i++) {
    		result[i]=lope[i]*(n-i);
    	}
    	Arrays.sort(result);
    	System.out.println(result[result.length-1]);
    }
}
