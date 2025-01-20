
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] tree;
    static boolean[][] visited;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());

        tree = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];

        for (int i = 0; i < N - 1; i++) {
            str = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(str.nextToken());
            int end = Integer.parseInt(str.nextToken());
            int value = Integer.parseInt(str.nextToken());

            tree[start][end] = value;
            tree[end][start] = value;
        }

        for (int i = 0; i < M; i++) {
            str = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(str.nextToken());
            int end = Integer.parseInt(str.nextToken());
            if (tree[start][end] != 0) {
                System.out.println(tree[start][end]);
            } else {
                dfs(start, end);
                System.out.println(cnt);
            }
        }
    }

    static void dfs(int x, int target){
        if(x==target){
            cnt = 0;
            for(int i=1;i<tree.length;i++){
                for(int j=i; j<tree.length;j++){
                    if(visited[i][j]){
                        cnt += tree[i][j];
                    }
                }
            }
        }else{
            for (int i = 1; i < tree.length; i++) {
                int nextValue = tree[i][x];
                if(nextValue!=0 && !visited[i][x]){
                    visited[i][x] = true;
                    visited[x][i] = true;
                    dfs(i, target);
                    visited[i][x] = false;
                    visited[x][i] = false;
                }
            }
        }
    }
}
