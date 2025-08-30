import java.io.*;
import java.util.*;

/*	수연이 BFS, 악마 이동 
 * 	
 */
public class Solution {

	static int N,M;
	static char [][] board;
	static int [][] dist;
	static boolean [][] visited;
	static Queue<Point> suyeon, demons;
	static Point D;
	
	static int [] dx = {-1,1,0,0}, dy = {0,0,-1,1}; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=TC;tc++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			N = Integer.parseInt(str.nextToken());
			M = Integer.parseInt(str.nextToken());
			
			board = new char[N][M];
			dist = new int[N][M];
			visited = new boolean[N][M];
			
			suyeon = new ArrayDeque<>();
			demons = new ArrayDeque<>();
			
			for(int i=0;i<N;i++) {
				String line = br.readLine();
				for(int j=0;j<M;j++) {
					char input = line.charAt(j);
					board[i][j] = input;
					if(input == 'S') {
						suyeon.add(new Point(i,j));
						visited[i][j]=true;
					}else if(input =='D') {
						D = new Point(i,j);
						dist[i][j]= -1;
					}else if(input == '*') {
						demons.add(new Point(i,j));
					}
				}
			}
			String result = "";
					
			playGame();
			
			result = (dist[D.x][D.y] != -1) ? String.valueOf(dist[D.x][D.y]) : "GAME OVER";
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void playGame() {
		while(true) {
			int size = suyeon.size();
			if(size == 0) return;
			moveSuyeon(size);
			
			size = demons.size();
			demonsHands(size);
		}	
	}
	
	static void moveSuyeon(int size) {
		while(size-->0) {
			Point now = suyeon.poll();
			if(board[now.x][now.y]=='*') continue;
			if(now.x==D.x && now.y==D.y) return;
			for(int i=0;i<4;i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if(nx<0 || ny<0 || nx>=N || ny>=M ) continue;
				if(visited[nx][ny] || board[nx][ny]=='X' || board[nx][ny]=='*') continue;
				
				visited[nx][ny]=true;
				dist[nx][ny]=dist[now.x][now.y]+1;
				suyeon.add(new Point(nx,ny));
			}
		}
	}
	
	static void demonsHands(int size) {
		while(size-->0) {
			Point now = demons.poll();
			
			for(int i=0;i<4;i++) {
				int nx = now.x+dx[i];
				int ny = now.y+dy[i];
				
				if(nx<0 || ny<0 || nx>=N || ny>=M) continue; 
				if(board[nx][ny] == '*' || board[nx][ny] == 'D' || board[nx][ny] == 'X') continue;
				
				board[nx][ny] = '*';
				demons.add(new Point(nx,ny));
			}
		}
	}

	static class Point{
		int x,y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
