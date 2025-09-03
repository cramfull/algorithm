import java.io.*;
import java.util.*;

public class Solution {
	
	static int N,M,L,result;
	static int [][] map;
	static boolean [][] visited;
	
	static HashMap<Integer,Set<Delta>> deltaMap;
	
	static int [][][] delta = new int[][][] {
		{},
		{{-1,0},{1,0},{0,-1},{0,1}},
		{{-1,0},{1,0}},
		{{0,-1},{0,1}},
		{{-1,0},{0,1}},
		{{1,0},{0,1}},
		{{1,0},{0,-1}},
		{{-1,0},{0,-1}}};
		
	static {
		deltaMap = new HashMap<>();
		for(int i=1;i<=7;i++) {
			deltaMap.put(i,new HashSet<>());
			for(int j=0;j<delta[i].length;j++) {
				deltaMap.get(i).add(new Delta(delta[i][j][0],delta[i][j][1]));
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=TC;tc++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(str.nextToken());
			M = Integer.parseInt(str.nextToken());
			int R = Integer.parseInt(str.nextToken());
			int C = Integer.parseInt(str.nextToken());
			L = Integer.parseInt(str.nextToken());
			
			map = new int[N][M];
			visited = new boolean[N][M];
			
			for(int i=0;i<N;i++) {
				String [] line = br.readLine().split(" ");
				for(int j=0;j<M;j++) {
					map[i][j]=Integer.parseInt(line[j]);
				}
			}
			
			result = 1;
			
			bfs(new Point(R,C,0,0));
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void bfs(Point start) {
		Queue<Point> que = new ArrayDeque<>();
		que.offer(start);
		visited[start.x][start.y]=true;
		
		int time = 1;
		
		while(time<L) {
			int size = que.size();
			time++;
			while(size-->0) {
				Point now = que.poll();
				int [][] deltaArr = delta[map[now.x][now.y]];
				for(int i=0;i<deltaArr.length;i++) {
					int deltaX = deltaArr[i][0];
					int deltaY = deltaArr[i][1];
					int nx = now.x+deltaX;
					int ny = now.y+deltaY;
					
					if(nx<0 || ny<0 || nx>=N || ny>=M || visited[nx][ny] || map[nx][ny]==0) continue;
//					if(!(now.deltaX==0 && now.deltaY==0)) {
//						if(!(deltaMap.get(map[nx][ny]).contains(new Delta(deltaX*-1,deltaY*-1)))) continue;
////						int [][] checkDeltaArr = delta[map[nx][ny]];
////						for(int j=0;j<checkDeltaArr.length;j++) {
////							int checkDeltaX = checkDeltaArr[j][0];
////							int checkDeltaY = checkDeltaArr[j][1];
////							if(deltaX*-1==checkDeltaX && deltaY*-1==checkDeltaY) flag=true;
////						}
//		
//					}
					if(deltaX==0 && deltaY==-1){
						if(map[nx][ny]==6 || map[nx][ny]==7 || map[nx][ny]==2) continue;
					}else if(deltaX==0 && deltaY==1) {
						if(map[nx][ny]==4 || map[nx][ny]==5 || map[nx][ny]==2) continue;
					}else if(deltaX==1 && deltaY==0) {
						if(map[nx][ny]==5 || map[nx][ny]==6 || map[nx][ny]==3) continue;
					}else if(deltaX==-1 && deltaY==0) {
						if(map[nx][ny]==4 || map[nx][ny]==7 || map[nx][ny]==3) continue;
					}
					
					
					visited[nx][ny] = true;
					result++;
					que.offer(new Point(nx,ny,deltaX,deltaY));
				}
			}
		}
	}

	static class Delta{
		int x,y;
		public Delta(int x, int y) {
			this.x=x;
			this.y=y;
		}
		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Delta other = (Delta) obj;
			return x == other.x && y == other.y;
		}
	}
	
	static class Point{
		int x,y,deltaX,deltaY;
		public Point(int x, int y, int deltaX, int deltaY) {
			this.x=x;
			this.y=y;
			this.deltaX = deltaX;
			this.deltaY = deltaY;
		}
	}
}
