// 최단거리 -> BFS
// 초기값 -1, 탐색 실패시 -1

import java.util.*;

class Solution {
    
    static int [] dx = new int[]{-1, 1, 0, 0};
    static int [] dy = new int[]{0, 0, -1, 1};
    
    static int [][] distance ;
    
    public int solution(int[][] maps) {
        int answer = 0;
        distance = new int[maps.length][maps[0].length];
        for(int i=0;i<maps.length;i++){
            Arrays.fill(distance[i], -1);    
        }
        
        bfs(new Point(0,0), maps);
        
        return distance[maps.length-1][maps[0].length-1];
    }
    
    
    
    public void bfs(Point p, int [][] graph){
        Queue<Point> que = new LinkedList<>();
        distance[p.x][p.y]=1;
        que.offer(new Point(p.x, p.y));
        while(!que.isEmpty()){
            Point now = que.poll();
            for(int i=0;i<4;i++){
                int nx = now.x+dx[i];
                int ny = now.y+dy[i];
                if(nx>=0 && nx<graph.length && ny>=0 && ny<graph[0].length && distance[nx][ny] == -1 && graph[nx][ny]==1){
                    distance[nx][ny] = distance[now.x][now.y]+1;
                    que.offer(new Point(nx, ny));
                }
            }
        }
        
    }
    
    
    
    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}