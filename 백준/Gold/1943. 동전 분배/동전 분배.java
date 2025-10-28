import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < 3; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] price = new int[N];
            int[] count = new int[N];
            int sum = 0;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                price[i] = v;
                count[i] = c;
                sum += v * c;
            }

            if ((sum & 1) == 1) { // 합이 홀수면 불가능
                sb.append(0).append('\n');
                continue;
            }

            int target = sum / 2;
            boolean[] dp = new boolean[target + 1];
            dp[0] = true;

            boolean ok = false;
            for (int i = 0; i < N; i++) {
                int v = price[i];
                int c = count[i];
                if (v > target) continue; // 이 동전 하나만으로도 타겟 초과 -> 의미 없음
                c = Math.min(c, target / v); // 필요 이상 개수는 잘라내기

                int[] used = new int[target + 1];
                Arrays.fill(used, -1);

                for (int s = 0; s <= target; s++) {
                    if (dp[s]) {
                        used[s] = 0; // 이번 종류 0개로 도달 가능
                    } else if (s >= v && used[s - v] >= 0 && used[s - v] < c) {
                        dp[s] = true;
                        used[s] = used[s - v] + 1;
                    }
                }

                if (dp[target]) { // 일찍 끝내기
                    ok = true;
                    break;
                }
            }

            sb.append(ok ? 1 : 0).append('\n');
        }

        System.out.print(sb.toString());
    }
}
