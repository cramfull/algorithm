/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{

	static double E, result;
	static int N;
	static Land [] lands;
	static int [] parent;
	static ArrayList<Tunnel> tunnels;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());

		for(int tc=1; tc<=TC; tc++) {
			N = Integer.parseInt(br.readLine());
			lands = new Land[N];
			parent = new int[N];
			tunnels = new ArrayList<>();
			result = 0;
			
			String [] landX = br.readLine().split(" ");
			String [] landY = br.readLine().split(" ");
			E = Double.parseDouble(br.readLine());
			for(int i=0;i<N;i++) {
				parent[i]=i;
				lands[i] = new Land(Integer.parseInt(landX[i]), Integer.parseInt(landY[i]));
				for(int j=i-1;j>=0;j--) {
					tunnels.add(new Tunnel(i,j,getDistance(lands[i], lands[j])));
				}
			}
			
			Collections.sort(tunnels);
			
			kruskal();
			
			sb.append("#").append(tc).append(" ").append(Math.round(result)).append("\n");
		}
		System.out.println(sb.toString());
	}

	static void kruskal() {
		int count = 0;
		for(int i=0;i<tunnels.size();i++) {
			Tunnel tunnel = tunnels.get(i);
			
			if(find(tunnel.start) == find(tunnel.end)) continue;
			
			union(tunnel.start, tunnel.end);
			count+=1;
			result+=tunnel.cost;
			
			if(count == N-1) break;
		}
	}
	
	static void union(int a, int b) {
		int pA = find(a);
		int pB = find(b);
		
		if(pA!=pB) parent[pB] = pA;
	}
	
	static int find(int x) {
		if(x==parent[x]) return x;
		
		return parent[x] = find(parent[x]);
	}
	
	static double getDistance(Land l1, Land l2) {
		return Math.sqrt(Math.pow(l1.x-l2.x, 2) + Math.pow(l1.y-l2.y, 2));
	}
	
	static class Land{
		int x,y;
		public Land(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	
	static class Tunnel implements Comparable<Tunnel>{
		int start, end;
		double cost;
		
		public Tunnel(int start, int end, double distance) {
			this.start = start;
			this.end = end;
			this.cost = E * Math.pow(distance , 2); 
		}
		
		@Override
		public int compareTo(Tunnel t) {
			return Double.compare(this.cost, t.cost);
		}
	}
}
