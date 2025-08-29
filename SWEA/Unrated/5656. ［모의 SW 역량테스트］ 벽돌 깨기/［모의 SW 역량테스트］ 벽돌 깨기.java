import java.io.*;
import java.util.*;

public class Solution {

	static int N,W,H,result;
	static int [] beads;
	static int [][] board;
	static int [] height;
	static int [][] copyBoard;
	static int [] copyHeight;
	
	static int [] dx = {-1,1,0,0}, dy= {0,0,-1,1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =  new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=TC;tc++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(str.nextToken());
			W = Integer.parseInt(str.nextToken());
			H = Integer.parseInt(str.nextToken());
			
			board = new int[H][W];
			height = new int[W];
			Arrays.fill(height,H-1);
			beads = new int[N];
			result = Integer.MAX_VALUE;
			
			
			for(int i=0;i<H;i++) {
				String [] line = br.readLine().split(" ");
				for(int j=0;j<W;j++) {
					board[i][j]=Integer.parseInt(line[j]);
					if(height[j] == H-1 && board[i][j]!=0) height[j]=i;
				}
			}
			
			permutation(0);
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void permutation(int depth) {
        if(result==0) return;

		if(depth==N) {
			copyBoard();
			int count = Integer.MAX_VALUE;
			for(int i=0;i<beads.length;i++) {
				if(copyHeight[beads[i]]==H) continue;
				bfs(beads[i]);
				count = Math.min(count, doGravitation());
			}
			result = Math.min(result, count);
			return;
		}
		
		for(int i=0;i<W;i++) {
			beads[depth] = i;
			permutation(depth+1);
		}
	}
	
	static void copyBoard(){
		copyBoard = new int [H][W];
		copyHeight = new int[W];
		for(int i=0;i<H;i++) {
			copyBoard[i] = board[i].clone();
		}
		copyHeight = height.clone();
	}
	
	static void bfs(int y) {
		Queue<Point> que = new LinkedList<>();
		int x = copyHeight[y];
		que.offer(new Point(x, y, copyBoard[x][y]));
		
		while(!que.isEmpty()) {
			Point now = que.poll();
			copyBoard[now.x][now.y] = 0;
			for(int i=0;i<4;i++) {
				for(int j=1;j<now.value;j++) {
					int nx = now.x+dx[i]*j;
					int ny = now.y+dy[i]*j;
					
					if(nx<0 || ny<0 || nx>=H || ny>=W || copyBoard[nx][ny]==0) continue;
					
					int tmp = copyBoard[nx][ny];
					copyBoard[nx][ny] = 0;
					que.offer(new Point(nx,ny, tmp));
				}
			}
		}
	}
	
	static int doGravitation() {
		int count = 0;
		
		for(int i=0;i<W;i++) {
			if(copyHeight[i] == H) continue;
			
			int idx = H-1;
			for(int j= H-1;j>=0;j--) {
				if(copyBoard[j][i]!=0) {
					copyBoard[idx--][i] = copyBoard[j][i];
					count++;
				}
			}
			copyHeight[i]=idx+1;
			
			while(idx>=0) copyBoard[idx--][i]=0;
		}
			
		return count;
	}
	
	static class Point{
		int x,y,value;
		public Point(int x, int y, int value) {
			this.x=x;
			this.y=y;
			this.value=value;
		}
	}
}
