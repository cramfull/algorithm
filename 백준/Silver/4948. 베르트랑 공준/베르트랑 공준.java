
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 일정 범위에서 소수 찾기

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n;
        StringBuilder sb = new StringBuilder();
        while ((n = Integer.parseInt(br.readLine()))!=0) {
            sb.append(vertrang(n)).append("\n");
        }
        System.out.println(sb);

    }

    static int vertrang(int n){
        int cnt = 0;
        for (int i = n+1; i <= 2 * n; i++) {
            if (isPrime(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
