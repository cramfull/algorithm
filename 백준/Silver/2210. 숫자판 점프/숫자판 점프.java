
import java.util.*;
import java.io.*;

public class Main {

    static String[][] graph = new String[5][5];
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        init();
        solution();
        System.out.println(set.size());
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                graph[i][j] = str.nextToken();
            }
        }
    }

    static void solution() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(new Point(i, j), 0, graph[i][j]);
            }
        }
    }

    static void dfs(Point point, int depth, String nums){
        if (depth == 5) {
            set.add(nums);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = point.x + dx[i];
            int ny = point.y + dy[i];
            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                dfs(new Point(nx, ny), depth + 1, nums+graph[nx][ny]);
            }
        }


    }

    static class Point{
        int x,y;
        public Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

}
