
import java.io.*;

public class Main {

    // 골드바흐의 추측 => 짝수를 두 소수의 합으로 나타내기
    // 두 소수의 차이가 가장 작은 것으로
    // N/2로 두 수 만들기
    // N/2, N/2 한쪽은 -1, 한쪽은 +1 하면서 소수판별
    static StringBuilder sb = new StringBuilder();

    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            getGoldBach(N);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static boolean isPrime(int N){
        for(int i=2; i<=Math.sqrt(N); i++){
            if(N%i==0){
                return false;
            }
        }
        return true;
    }

    static void getGoldBach(int N){
        int x = N/2;
        int y = N/2;

        while (x > 0) {
            boolean left = isPrime(x);
            boolean right = isPrime(y);
            if (left && right) {
                sb.append(x).append(" ").append(y);
                return;
            }else{
                x--;
                y++;
            }
        }
    }
}
