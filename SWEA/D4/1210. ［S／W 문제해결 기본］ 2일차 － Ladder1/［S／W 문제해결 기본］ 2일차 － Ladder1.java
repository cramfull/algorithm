import java.util.*;
import java.io.*;

class Solution {
    static int [][] ladder;
    static boolean [][] visited;
     
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=10; tc++) {
            ladder = new int[100][100];
            visited = new boolean[100][100];
            // 입력 
            br.readLine();
            for(int i=0;i<100;i++) {
                ladder[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            // 마지막 줄에서 2 찾기
            int nx = 99;
            int ny = findEndPoint();
            visited[nx][ny] = true;
            // 사다리 타기 역순
            int result = climbLadder(nx, ny);
            // 출력
            sb.append(String.format("#%d %d", tc, result)).append("\n");
        }
        System.out.println(sb.toString());
    }
     
    // 마지막 줄에서 2 찾기
    static int findEndPoint() {
        int ny = 0;
        for(;ny<100;ny++) {
            if(ladder[99][ny]==2) return ny;
        }
        return ny;
    }
     
    // 사다리 타기 역순
    static int climbLadder(int x, int y) {
        while(x>0) {
            // go left
            while(y>=1 && y<100 && !visited[x][y-1] && ladder[x][y-1]==1) {
                y-=1;
                visited[x][y] = true;
            }
            // go right
            while(y>=0 && y<99 && !visited[x][y+1] && ladder[x][y+1]==1) {
                y+=1;
                visited[x][y] = true;
            }
            // go up
            if(x>0) {
                x-=1;
                visited[x][y] = true;
            }
        }    
        return y;
    }
}
