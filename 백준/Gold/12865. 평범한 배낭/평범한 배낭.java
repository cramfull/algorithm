
import java.util.*;
import java.io.*;

public class Main {

    // i=현재 물건 idx, j=남은 무게, 해 = 가치 합
    // if( j < weight[i] )

    // dp[i][j] = max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i])

    static int N, K;
    static int [] weight;
    static int [] value;
    static int [][] dp;

    public static void main(String [] args) throws IOException{
        init();
        solution();
        System.out.println(dp[N][K]);
    }

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken());
        weight = new int[N + 1];
        value = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            str = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(str.nextToken());
            value[i] = Integer.parseInt(str.nextToken());
        }

        dp = new int[N+1][K+1];
    }

    static void solution(){
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if(j < weight[i]){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
    }















}
