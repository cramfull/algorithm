
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer str = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(str.nextToken());
        int b = Integer.parseInt(str.nextToken());

        int k = gcd(Math.max(a, b), Math.min(a, b));
        StringBuilder sb = new StringBuilder();
        sb.append(k).append("\n").append((a/k)*k*(b/k));
        System.out.println(sb);
    }

    static int gcd(int a, int b){
        if(b==0){
            return a;
        }
        return gcd(b, a%b);
    }
}
