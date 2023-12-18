
import java.io.*;
import java.math.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
       int N = Integer.parseInt(br.readLine());
       Member[] arr = new Member[N];
       for(int i=0;i<N;i++) {
    	   StringTokenizer str = new StringTokenizer(br.readLine());
    	   int country = Integer.parseInt(str.nextToken());
    	   int num = Integer.parseInt(str.nextToken());
    	   int score = Integer.parseInt(str.nextToken());
    	   arr[i] = new Member(country, num, score);
       }
       
       Arrays.sort(arr, new Comparator<Member>() {

		@Override
		public int compare(Member o1, Member o2) {
			// TODO Auto-generated method stub
			return o2.score - o1.score;
		}
       });
       StringBuilder sb = new StringBuilder();
       for(int i=0;i<2; i++) {
    	   sb.append(arr[i].country+" "+arr[i].num+"\n");
       }
       int k = arr[0].country;
	   int l = arr[1].country;
	   if(k==l && l==arr[2].country) {
		   for(int j=2; j<arr.length; j++) {
			   int m = arr[j].country;
			   if(m!=l) {
		    	   sb.append(arr[j].country+" "+arr[j].num+"\n");
		    	   break;
    			   }
		   }
			   
		   }else {
	    	   sb.append(arr[2].country+" "+arr[2].num+"\n");

		   }
		   
	   
       System.out.println(sb.toString());
       
       
       
       
    }
    
    static class Member{
    	int country;
    	int num;
    	int score;
    	
    	public Member(int country, int num, int score) {
    		this.country=country;
    		this.num=num;
    		this.score=score;
    	}
    }
}