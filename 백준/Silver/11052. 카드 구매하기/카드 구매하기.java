
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

    static int N;
    static int [] array, dp;


    public static void main(String [] args) throws IOException {
        // 백트래킹으로 부분집합을 구함 -> 해당 집합의 합  -> 완전탐색, 시간 부족
        // dp 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        array = new int[N + 1];
        dp = new int[N + 1];
        StringTokenizer str = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            array[i] = Integer.parseInt(str.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], array[j] + dp[i-j]);
            }
        }

        System.out.println(dp[N]);

    }
}
