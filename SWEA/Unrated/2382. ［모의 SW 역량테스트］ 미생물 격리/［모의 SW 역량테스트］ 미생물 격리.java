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
	static int N, M, K;
	static boolean [] visited;
	static Point [] points;
	static Micro [] micros;
	static int [] parent;
	static HashMap<Point, PriorityQueue<Micro>> cells;
	
	static int [][] row = {{0,-1},{0,1}};
	static int [][] col = {{-1,0},{1,0}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=TC; tc++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			N = Integer.parseInt(str.nextToken());
			M = Integer.parseInt(str.nextToken());
			K = Integer.parseInt(str.nextToken());
			micros = new Micro[K+1];
			points = new Point[K+1];
			parent = new int[K+1];
			
			for(int i=1;i<=K;i++) {
				parent[i]=i;
				str = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(str.nextToken());
				int y = Integer.parseInt(str.nextToken());
				int swarm = Integer.parseInt(str.nextToken());
				int direction = Integer.parseInt(str.nextToken());
				
				micros[i] = new Micro(i,swarm,direction);
				points[i] = new Point(x,y);
			}
			
			for(int time=1; time<=M; time++) {
				cells = new HashMap<>(); 
				visited = new boolean[K+1];
				for(int i=1;i<micros.length;i++) {
					if(i!=find(i)) continue;
					move(i);
				}
				
				for(int i=1;i<micros.length;i++) {
					if(i!=find(i)||visited[i]) continue;
					combine(i);
					detectRedZone(i);
					visited[find(i)] = true;
				}
			}
			
			int result = 0;
			for(int i=1;i<micros.length;i++) {
				if(i!=find(i)) continue;
				Micro nowMicro = micros[i];
				result+=nowMicro.swarm;
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}

	static void detectRedZone(int idx) {
		Point point = points[idx];
		Micro micro = micros[idx];
		if(point.x==0 || point.x==N-1 || point.y==0 || point.y==N-1) {
			micro.swarm/=2;
			micro.directionIdx = (micro.directionIdx+1)%2;
		}
	}
	
	static void move(int idx){
		Point point = points[idx];
		Micro micro = micros[idx];
		point.x +=micro.direction[micro.directionIdx][0];
		point.y +=micro.direction[micro.directionIdx][1];
		
		if(!cells.containsKey(point)) {
			cells.put(point, new PriorityQueue<>());
		}
		cells.get(point).add(micro);
	}
	
	static void combine(int idx) {
		Point point = points[idx];
		PriorityQueue<Micro> pq = cells.get(point);
		
		Micro bigMicro = pq.poll();
		
		while(!pq.isEmpty()) {
			Micro other = pq.poll();
			union(bigMicro.id, other.id);
			bigMicro.swarm += other.swarm;
		}
	}
	
	static class Point{
		int x,y;	
		
		public Point(int x, int y) {
			this.x =x;
			this.y=y;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
	}
	
	static void union(int a, int b) {
		int pA = find(a);
		int pB = find(b);
		if(pA==pB) return;
		
		parent[pB] = pA;
	}
	
	static int find(int x) {
		if(x==parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
	
	static class Micro implements Comparable<Micro>{
		int id, swarm, directionIdx;
		int [][] direction;
		
		public Micro(int id, int swarm, int direction) {
			this.id = id;
			this.swarm = swarm;
			
			if(direction==1) {
				this.direction = col;
				this.directionIdx = 0;
			} else if(direction==2) {
				this.direction = col;
				this.directionIdx = 1;
			} else if(direction==3) {
				this.direction = row;
				this.directionIdx = 0;
			} else if(direction==4) {
				this.direction = row;
				this.directionIdx = 1;
			}
		}

		@Override
		public int compareTo(Micro o) {
			return o.swarm - this.swarm;
		}
	}
}
