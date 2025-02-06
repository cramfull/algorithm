
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, S, cnt;
    static String [] array;
    static boolean [] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer str = new StringTokenizer(br.readLine());

        N = Integer.parseInt(str.nextToken());
        S = Integer.parseInt(str.nextToken());

        array = br.readLine().split(" ");
        visited = new boolean[N];

        dfs(0, 0);

        System.out.println((S==0)?cnt-1:cnt);
    }

    static void dfs(int depth, int sum) {
        if (depth == N) {
            if (sum == S) {
                cnt++;
            }
            return;
        }
        dfs(depth + 1, sum + Integer.parseInt(array[depth]));
        dfs(depth + 1, sum);
    }

}

