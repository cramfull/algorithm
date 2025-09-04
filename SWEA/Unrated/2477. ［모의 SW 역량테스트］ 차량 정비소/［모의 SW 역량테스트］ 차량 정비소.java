import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
 
public class Solution {
	    static int [] receptionIDs;
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
	            receptionIDs = new int[K+1];
	             
	            for(int i=1;i<=K;i++) {
	                Customer prevCustomer = customers[i-1];
	                Customer customer = customers[i];
	                 
	                int timeGap = arriveTime[customer.id] - arriveTime[prevCustomer.id];
	                int minIdx = 1;
	                int minValue = receptionCounter[1];
	                
	                for(int j=1;j<=N;j++) {
	                    receptionCounter[j]-=timeGap;
	                    if(receptionCounter[j]<0) receptionCounter[j]=0;
	                    
	                    if(minValue>receptionCounter[j]) {
	                        minValue = receptionCounter[j];
	                        minIdx = j;
	                    }
	                }
	                 
	                receptionCounter[minIdx]+=receptionTime[minIdx];
	                receptionIDs[customer.id]=minIdx;
	                customer.time+=receptionTime[minIdx]+minValue;
	            }
	             
	        //   다 끝나고  customer의 시간으로 오름차순 정렬(같은 경우는 고객 id가 높은 순으로)
	            Arrays.sort(customers, new Comparator<Customer>() {
	                @Override
	                public int compare(Customer o1, Customer o2) {
	                    if(o1.time==o2.time) return receptionIDs[o1.id] - receptionIDs[o2.id];
	                    return o1.time - o2.time;
	                }
	            });
	             
	            int [] repairCounter = new int[M+1];
	            int [] repairIDs = new int[K+1];
	 
	            customers[0].time=customers[1].time;
	            for(int i=1;i<=K;i++) {
	                Customer prevCustomer = customers[i-1];
	                Customer customer = customers[i];
	 
	                int timeGap = customer.time-prevCustomer.time;
	                int minIdx = 1;
	                int minValue = repairCounter[1];
	                
	                for(int j=1;j<=M;j++) {
	                    repairCounter[j]-=timeGap;
	                    if(repairCounter[j]<0) repairCounter[j]=0;
	                    
	                    if(minValue>repairCounter[j]) {
	                        minValue = repairCounter[j];
	                        minIdx = j;
	                    }
	                }
	                    
	                repairCounter[minIdx]+=repairTime[minIdx];
	                repairIDs[customer.id]=minIdx;
	                 
	                if(receptionIDs[customer.id] == A && repairIDs[customer.id]==B) result+=customer.id;
	            }
	             
	            sb.append("#").append(tc).append(" ").append((result==0)? -1 : result).append("\n");
	        }
	        System.out.println(sb.toString());
	    }
	     
	    static class Customer{ 
//	    implements Comparable<Customer> {
	        int id, time;
	         
	        public Customer(int id, int time) {
	            this.id = id;
	            this.time = time;
	        }
	 
//	        @Override
//	        public int compareTo(Customer o) {
//	            if(this.time==o.time) return receptionIDs[this.id] - receptionIDs[o.id];
//	            return this.time - o.time;
//	        }
	    }
}