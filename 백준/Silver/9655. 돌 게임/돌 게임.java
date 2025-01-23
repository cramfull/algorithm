
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // ㅅ    ㅊ    ㅅ   ㅊ   ㅅ

    // #1   SK
    // 1
    // dp[1] = 1

    // #2   CY
    // 1   1
    // dp[2] = 1

    // #3   SK
    //  1   1     1
    //  3
    // dp[3] = 2

    //  #4  CY
    //  1     1     1     1
    //  1    3
    //  3    1
    // dp[4] = 3

    // #5   SK
    // 1    1     1    1   1
    // 1    1     3
    // 1    3     1
    // 3    1     1
    // dp[5] = 4

    // #6 CY
    // 1   1    1    1   1   1
    // 1   1    1    3
    // 1   1    3    1
    // 1   3    1    1
    // 3   1    1    1
    // 3   3
    // dp[6]= 6

    // #7 SK
    // 1  1   1   1  1  1   1
    // 1  1   1   1  3
    // 1  1   1   3  1
    // 1  1   3   1  1
    // 1  3   1   1  1
    // 3  1   1   1  1
    // 1  3   3
    // 3  1   3
    // 3  3   1

    // 1 2 3 4 5 6 7
    // 1 1 2 3 4 6 9

    // n >= 4
    // dp[n] = dp[n-2] + dp[n-3] +dp[n-4]

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [] dp = new int[N+4];
        if(N%2==0){
            System.out.println("CY");
        }else{
            System.out.println("SK");
        }

    }
}
