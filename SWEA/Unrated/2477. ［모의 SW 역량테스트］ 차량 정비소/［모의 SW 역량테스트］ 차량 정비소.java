import java.io.*;
import java.util.*;


public class Solution {
	
	static int N,M,K,A,B, result;
	static int [] receptionTime, repairTime, arriveTime;
	static Customer [] customers;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());

		for(int tc=1;tc<=TC;tc++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(str.nextToken());
			M = Integer.parseInt(str.nextToken());
			K = Integer.parseInt(str.nextToken());
			A = Integer.parseInt(str.nextToken());
			B = Integer.parseInt(str.nextToken());
			result = 0;
			
			receptionTime = new int[N+1];
			str = new StringTokenizer(br.readLine());
			for(int i=1;i<=N;i++) {
				receptionTime[i] = Integer.parseInt(str.nextToken());
			}
			
			repairTime = new int[M+1];
			str = new StringTokenizer(br.readLine());
			for(int i=1;i<=M;i++) {
				repairTime[i] = Integer.parseInt(str.nextToken());
			}
			
			arriveTime = new int[K+1];
			customers = new Customer[K+1];
			customers[0] = new Customer(0,0);
			str = new StringTokenizer(br.readLine());
			for(int i=1;i<=K;i++) {
				int time = Integer.parseInt(str.nextToken());
				arriveTime [i] = time;
				customers[i]=new Customer(i,time);
			}
			
			int [] counter = new int [N+1];
			goCounter(0,counter,receptionTime);
			
			Arrays.sort(customers, ((o1,o2)->((o1.time==o2.time) ? (o1.receptionID - o2.receptionID) : (o1.time - o2.time))));
				
			counter = new int[M+1];
			goCounter(1,counter,repairTime);
			
			for(int i=1;i<=K;i++) {
				if(customers[i].receptionID == A && customers[i].repairID==B) result+=customers[i].id;
			}
			sb.append("#").append(tc).append(" ").append((result==0)? -1 : result).append("\n");
		}
		System.out.println(sb.toString());
	}
		
	static void goCounter(int mode, int [] counter, int [] time) {
		for(int i=1;i<=K;i++) {
			Customer prevCustomer = customers[i-1];
			Customer customer = customers[i];
			
			int timeGap;
			if(mode==0) timeGap = arriveTime[customer.id] - arriveTime[prevCustomer.id];
			else timeGap = customer.time-prevCustomer.time;
			
			for(int j=1;j<counter.length;j++) {
				counter[j]-=timeGap;
				if(counter[j]<0) counter[j]=0;
			}

			int minIdx = 1;
			int minValue = counter[1];
			for(int j=1;j<counter.length;j++) {
				if(minValue>counter[j]) {
					minValue = counter[j];
					minIdx = j;
				}
			}
			
			counter[minIdx]+=time[minIdx];
			if(mode==0) {
				customer.receptionID=minIdx;
				customer.time+=time[minIdx]+minValue;
			}else {
				customer.repairID=minIdx;
			}
		}
	}
	
	static class Customer {
		int id, time, receptionID, repairID;
		
		public Customer(int id, int time) {
			this.id = id;
			this.time = time;
			this.receptionID = -1;
			this.repairID = -1;
		}
	}
}
