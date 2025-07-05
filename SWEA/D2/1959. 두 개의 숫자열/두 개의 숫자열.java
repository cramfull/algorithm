
import java.util.*;
import java.io.*;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(str.nextToken());
            int M = Integer.parseInt(str.nextToken());
            int [] arrN = new int[N];
            int [] arrM = new int[M];
            
            str = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++){
                arrN[i] = Integer.parseInt(str.nextToken());
            }
            str = new StringTokenizer(br.readLine());
            for(int i=0;i<M;i++){
                arrM[i] = Integer.parseInt(str.nextToken());
            }
            
            System.out.print("#"+test_case+" ");
            if(N>M){
                solving(M, arrM, N, arrN);
            }else{
                solving(N, arrN, M, arrM);
            }
            
		}
	}
    
    public static void solving(int smallSize, int [] smallArray, int bigSize, int [] bigArray){
        int result = 0;
        for(int i=0; i<=bigSize-smallSize; i++){            
            int [] tmpArray = new int[bigSize];

            for(int j=0;j<smallSize;j++){
             	tmpArray[i+j] = smallArray[j];   
            }

            int sum = 0;
            for(int j=0; j<bigSize; j++){
                 sum += tmpArray[j] * bigArray[j];
            }
            result = Math.max(result, sum);   
        }
        System.out.println(result);
    }
    
}