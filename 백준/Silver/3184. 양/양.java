
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // !visited[i][j]일 경우 탐색
    // .일 경우 이동 가능, #일 경우 이동 불가
    // 탐색하는 범위 내에서 o,v cnt
    // 탐색 끝난 경우 if o>v  resultO+= o, else resultV+=v
    public static final String sheep = "o";
    public static final String wolf = "v";
    public static final String fence = "#";
    public static final String yard = ".";

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static String[][] board;
    static boolean[][] visited;
    static int R, C;
    static int sheepCnt, wolfCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        R = Integer.parseInt(str.nextToken());
        C = Integer.parseInt(str.nextToken());
        board = new String[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().split("");
        }

        int totalCountSheep = 0;
        int totalCountWolf = 0;

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(!visited[i][j] && !board[i][j].equals(fence)){
                    sheepCnt = 0;
                    wolfCnt = 0;
                    visited[i][j] = true;
                    dfs(new Point(i,j));
                    // 여기서 각 카운트 비교 후 result에 결과 저장
                    if(sheepCnt>wolfCnt){
                        totalCountSheep +=sheepCnt;
                    }else{
                        totalCountWolf+=wolfCnt;
                    }
                }
            }
        }
        System.out.println(totalCountSheep + " " + totalCountWolf);
    }

    static void dfs(Point now) {
        String mark = board[now.x][now.y];
        if(mark.equals(sheep)){
            sheepCnt++;
        } else if (mark.equals(wolf)) {
            wolfCnt++;
        }
        for(int i=0;i<4;i++){
            int nx = now.x + dx[i];
            int ny = now.y + dy[i];
            if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny]) {
                String nextMark = board[nx][ny];
                if(!nextMark.equals(fence)){
                    visited[nx][ny] = true;
                    dfs(new Point(nx, ny));
                }
            }
        }
    }

    static class Point{
        int x, y;
        public Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}
