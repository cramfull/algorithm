import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
	
//	static int N,M,K,A,B, result;
//	static int [] receptionTime, repairTime, arriveTime;
//	static int [] counter, receptionCounter, repairCounter;
//	static Customer [] customers;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());

		for(int tc=1;tc<=TC;tc++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(str.nextToken());
			int M = Integer.parseInt(str.nextToken());
			int K = Integer.parseInt(str.nextToken());
			int A = Integer.parseInt(str.nextToken());
			int B = Integer.parseInt(str.nextToken());
			int result = 0;
			
			int [] receptionTime = new int[N+1];
			str = new StringTokenizer(br.readLine());
			for(int i=1;i<=N;i++) {
				receptionTime[i] = Integer.parseInt(str.nextToken());
			}
			
			int [] repairTime = new int[M+1];
			str = new StringTokenizer(br.readLine());
			for(int i=1;i<=M;i++) {
				repairTime[i] = Integer.parseInt(str.nextToken());
			}
			
			int [] arriveTime = new int[K+1];
			Customer [] customers = new Customer[K+1];
			customers[0] = new Customer(0,0);
			str = new StringTokenizer(br.readLine());
			for(int i=1;i<=K;i++) {
				int time = Integer.parseInt(str.nextToken());
				arriveTime [i] = time;
				customers[i]=new Customer(i,time);
			}
			
			int [] receptionCounter = new int [N+1];
			int [] repairCounter = new int[M+1];
			
			for(int i=1;i<=K;i++) {
				Customer prevCustomer = customers[i-1];
				Customer customer = customers[i];
				
				int timeGap = arriveTime[customer.id] - arriveTime[prevCustomer.id];
				for(int j=1;j<=N;j++) {
					receptionCounter[j]-=timeGap;
					if(receptionCounter[j]<0) receptionCounter[j]=0;
				}
				
				int minIdx = 1;
				int minValue = receptionCounter[1];
				for(int j=1;j<=N;j++) {
					if(minValue>receptionCounter[j]) {
						minValue = receptionCounter[j];
						minIdx = j;
					}
				}
				
				receptionCounter[minIdx]+=receptionTime[minIdx];
				customer.receptionID=minIdx;
				customer.time+=receptionTime[minIdx]+minValue;
			}
			
		// 	 다 끝나고  customer의 시간으로 오름차순 정렬(같은 경우는 고객 id가 높은 순으로)
			Arrays.sort(customers, new Comparator<Customer>() {
				@Override
				public int compare(Customer o1, Customer o2) {
					if(o1.time==o2.time) return o1.receptionID - o2.receptionID;
					return o1.time - o2.time;
				}
			});
			
		/*  정비 창구도 똑같이 돌림
		 *  
		 *  for 고객 한명씩
		 * 	for 창구 개수
		 * 	  제일 작은 값인 idx구하기 (같은 경우는 갱신  x)
		 * 	for 이전 고객과의 시간 갭차이를 전부 빼기 (idx일때는 해당 창구 소요시간 더하기)
		 *  해당 고객의 창구 번호 저장
		 *  
		 *  창구가 A,B와 같은경우 result에 더함
		 */
			customers[0].time=customers[1].time;
			for(int i=1;i<=K;i++) {
				Customer prevCustomer = customers[i-1];
				Customer customer = customers[i];

				int timeGap = customer.time-prevCustomer.time;
				for(int j=1;j<=M;j++) {
					repairCounter[j]-=timeGap;
					if(repairCounter[j]<0) repairCounter[j]=0;
				}
				
				int minIdx = 1;
				int minValue = repairCounter[1];
				for(int j=1;j<=M;j++) {
					if(minValue>repairCounter[j]) {
						minValue = repairCounter[j];
						minIdx = j;
					}
				}
				
				repairCounter[minIdx]+=repairTime[minIdx];
				customer.repairID=minIdx;
//				customer.time+=repairTime[minIdx]+minValue;
				
				if(customer.receptionID == A && customer.repairID==B) result+=customer.id;
			}
			
			sb.append("#").append(tc).append(" ").append((result==0)? -1 : result).append("\n");
		}
		System.out.println(sb.toString());
	}
//	static void solving() {
//		receptionCounter = new int [N+1];
//		repairCounter = new int[M+1];
//		
//		for(int i=1;i<=K;i++) {
//			Customer prevCustomer = customers[i-1];
//			Customer customer = customers[i];
//			
//			int timeGap = arriveTime[customer.id] - arriveTime[prevCustomer.id];
//			for(int j=1;j<=N;j++) {
//				receptionCounter[j]-=timeGap;
//				if(receptionCounter[j]<0) receptionCounter[j]=0;
//			}
//			
//			int minIdx = 1;
//			int minValue = receptionCounter[1];
//			for(int j=1;j<=N;j++) {
//				if(minValue>receptionCounter[j]) {
//					minValue = receptionCounter[j];
//					minIdx = j;
//				}
//			}
//			
//			receptionCounter[minIdx]+=receptionTime[minIdx];
//			customer.receptionID=minIdx;
//			customer.time+=receptionTime[minIdx]+minValue;
//		}
//		
//	// 	 다 끝나고  customer의 시간으로 오름차순 정렬(같은 경우는 고객 id가 높은 순으로)
//		Arrays.sort(customers, new Comparator<Customer>() {
//			@Override
//			public int compare(Customer o1, Customer o2) {
//				if(o1.time==o2.time) return o1.receptionID - o2.receptionID;
//				return o1.time - o2.time;
//			}
//		});
//		
//	/*  정비 창구도 똑같이 돌림
//	 *  
//	 *  for 고객 한명씩
//	 * 	for 창구 개수
//	 * 	  제일 작은 값인 idx구하기 (같은 경우는 갱신  x)
//	 * 	for 이전 고객과의 시간 갭차이를 전부 빼기 (idx일때는 해당 창구 소요시간 더하기)
//	 *  해당 고객의 창구 번호 저장
//	 *  
//	 *  창구가 A,B와 같은경우 result에 더함
//	 */
//		customers[0].time=customers[1].time;
//		for(int i=1;i<=K;i++) {
//			Customer prevCustomer = customers[i-1];
//			Customer customer = customers[i];
//
//			int timeGap = customer.time-prevCustomer.time;
//			for(int j=1;j<=M;j++) {
//				repairCounter[j]-=timeGap;
//				if(repairCounter[j]<0) repairCounter[j]=0;
//			}
//			
//			int minIdx = 1;
//			int minValue = repairCounter[1];
//			for(int j=1;j<=M;j++) {
//				if(minValue>repairCounter[j]) {
//					minValue = repairCounter[j];
//					minIdx = j;
//				}
//			}
//			
//			repairCounter[minIdx]+=repairTime[minIdx];
//			customer.repairID=minIdx;
////			customer.time+=repairTime[minIdx]+minValue;
//			
//			if(customer.receptionID == A && customer.repairID==B) result+=customer.id;
//		}
//	}
	
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
