import java.io.*;
import java.util.*;

/* 1일, 1달, 3달, 1년
 * 
 * 1일권 1달권 비교
 * i==3부터는 3달권이랑도 비교
 * 마지막에 1년권과 비교 
 * 
 */
public class Solution {

	static int D,M,M3,Y;
	static int [] months;
	static int [] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=TC;tc++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			D=Integer.parseInt(str.nextToken());
			M=Integer.parseInt(str.nextToken());
			M3=Integer.parseInt(str.nextToken());
			Y=Integer.parseInt(str.nextToken());
			
			months = new int[13];
			dp = new int[13];
			String [] line = br.readLine().split(" ");
			for(int i=1;i<=12;i++) {
				months[i]=Integer.parseInt(line[i-1]);
			}
			solving();
			
			sb.append("#").append(tc).append(" ").append(dp[12]).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void solving() {
		for(int i=1;i<=12;i++) {
			dp[i]=Math.min(dp[i-1]+D*months[i], dp[i-1]+M);
			if(i>=3) {
				dp[i]=Math.min(dp[i],dp[i-3]+M3);
			}
		}
		dp[12]=Math.min(dp[12],Y);
	}
}
