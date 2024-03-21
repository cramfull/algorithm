import java.util.*;


class Solution {

    static int M,N;
    static int [] dx = new int[]{-1,1,0,0};
    static int [] dy = new int[]{0,0,-1,1};
    static String [][] graph;
    static boolean visited [][];
    static ArrayList<Integer> arr;
    
    public int[] solution(String[] maps) {
        
        M = maps[0].length();
        N = maps.length;
        
        graph = new String[N][M];
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                graph[i][j]=String.valueOf(maps[i].charAt(j));
            }
        }

        
        visited = new boolean[N][M];
        arr = new ArrayList<>();
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(graph[i][j].equals("X")){
                    visited[i][j]=true;
                }else{
                    if(!visited[i][j]){
                        bfs(new Point(i,j));
                    }
                }
            }
        }
        int [] answer = {};
        if(arr.size()==0){
            answer = new int[]{-1};
        }else{
            answer = new int[arr.size()];
            for(int i=0;i<arr.size();i++) {
            	answer[i]=arr.get(i);
            }
            Arrays.sort(answer);
        }
        return answer;

    }
    
    public void bfs(Point p){
        Queue<Point> que = new LinkedList<>();
        que.offer(p);
        visited[p.x][p.y]=true;
        int sum=0;
        while(!que.isEmpty()){
            Point now = que.poll();
            sum+=Integer.parseInt(graph[now.x][now.y]);
            for(int i=0;i<4;i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny] && !graph[nx][ny].equals("X")){
                    que.offer(new Point(nx,ny));
                    visited[nx][ny]=true;
                }
            }
        }
        if(sum!=0) {
            arr.add(sum);
        }
    }
}

class Point{
    int x;
    int y;
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}