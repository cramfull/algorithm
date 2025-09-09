import java.io.*;
import java.util.*;

public class Solution {

static int N, maxValue;
static int [][] board;
static ArrayList<Point> starts;

static int [][] dx = {{-1,0},{1,0},{0,-1},{0,1}};
static ArrayList<ArrayList<Point>> warmHole;

public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb  = new StringBuilder();
    int TC = Integer.parseInt(br.readLine().trim());
    
    for(int tc=1;tc<=TC;tc++) {
        N = Integer.parseInt(br.readLine().trim());
        
        board = new int[N][N];
        starts = new ArrayList<>();
        warmHole = new ArrayList<>();
        for(int i=0;i<5;i++) {
            warmHole.add(new ArrayList<>());
        }
        
        for(int i=0;i<N;i++) {
            String [] line = br.readLine().trim().split(" ");
            for(int j=0;j<N;j++) {
                board[i][j]=Integer.parseInt(line[j]);
                if(board[i][j]==0) starts.add(new Point(i,j));
                if(board[i][j]>=6 && board[i][j]<=10) warmHole.get(board[i][j]-6).add(new Point(i,j));
            }
        }
        
        maxValue=0;
        for(int i=0;i<starts.size();i++) {
            Point start = starts.get(i);
            for(int j=0;j<4;j++) {
                Ball ball = new Ball(start.x, start.y, dx[j]);
                int result = playGame(ball);
                maxValue = Math.max(maxValue, result);
            }
        }
        sb.append("#").append(tc).append(" ").append(maxValue).append("\n");
    }
    System.out.println(sb.toString());
}

static int playGame(Ball start) {
    int score = 0;
    Ball ball = new Ball(start.x,start.y,start.dx);
    while(true) {
        int nx = ball.x + ball.dx[0];
        int ny = ball.y + ball.dx[1];
        
        if(nx<0 || ny<0 || nx>=N || ny>=N) {
            ball.dx[0]*=-1;
            ball.dx[1]*=-1;
            nx=ball.x;
            ny=ball.y;
            score+=1;
        }
        
        if(board[nx][ny]==-1) break;
        if(nx==start.x && ny==start.y) break;
        
        int value = board[nx][ny];
        
        if(6<=value && value<=10) {
	    	for(int i=0;i<warmHole.get(value-6).size();i++) {
	            Point point = warmHole.get(value-6).get(i);
	            if(point.x==nx && point.y==ny) continue;
	            ball.x=point.x;
	            ball.y=point.y;
	            break;
	        }
	    	continue;
        }else {
        	if(value==1) {
                if(ball.dx[0]==1) {
                    ball.dx[0]=0;
                    ball.dx[1]=1;
                }else if(ball.dx[1]==-1){
                    ball.dx[0]=-1;
                    ball.dx[1]=0;
                }else {
                    ball.dx[0]*=-1;
                    ball.dx[1]*=-1;
                }
            }else if(value==2) {
                if(ball.dx[0]==-1) {
                    ball.dx[0]=0;
                    ball.dx[1]=1;
                }else if(ball.dx[1]==-1){
                    ball.dx[0]=1;
                    ball.dx[1]=0;
                }else {
                    ball.dx[0]*=-1;
                    ball.dx[1]*=-1;
                }
            }else if(value==3) {
                if(ball.dx[0]==-1) {
                    ball.dx[0]=0;
                    ball.dx[1]=-1;
                }else if(ball.dx[1]==1){
                    ball.dx[0]=1;
                    ball.dx[1]=0;
                }else {
                    ball.dx[0]*=-1;
                    ball.dx[1]*=-1;
                }
            }else if(value==4) {
                if(ball.dx[0]==1) {
                    ball.dx[0]=0;
                    ball.dx[1]=-1;
                }else if(ball.dx[1]==1){
                    ball.dx[0]=-1;
                    ball.dx[1]=0;
                }else {
                    ball.dx[0]*=-1;
                    ball.dx[1]*=-1;
                }
            }else if(value==5) {
                ball.dx[0]*=-1;
                ball.dx[1]*=-1;
            }
        	
        	if(1<=value && value<=5) score+=1;
        }
        
        ball.x= nx;
        ball.y= ny;
    }
//    System.out.println("##"+start.x+" "+start.y+" "+start.dx[0]+" "+start.dx[1]+" : "+score);
    return score;
}

static class Point{
    int x,y;
    public Point(int x, int y) {
        this.x=x;
        this.y=y;
    }
}

static class Ball{
    int x,y;
    int [] dx;
    
    public Ball(int x, int y, int [] dx) {
        this.x=x;
        this.y=y;
        this.dx=new int[] {dx[0],dx[1]};
    }
}
}