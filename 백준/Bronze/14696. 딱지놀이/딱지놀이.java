
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int[] cardA = new int[5];
            int count = Integer.parseInt(str.nextToken());
            for (int j = 0; j < count; j++) {
                int shape = Integer.parseInt(str.nextToken());
                cardA[shape] += 1;
            }

            str = new StringTokenizer(br.readLine());
            int[] cardB = new int[5];
            count = Integer.parseInt(str.nextToken());
            for (int j = 0; j < count; j++) {
                int shape = Integer.parseInt(str.nextToken());
                cardB[shape] += 1;
            }

            for (int j = 4; j > 0; j--) {
                // 같을 때
                if (cardA[j] == cardB[j]) {
                    if (j == 1) {
                        System.out.println("D");
                        break;
                    }
                    continue;
                }
                // 다를 때
                if (cardA[j] > cardB[j]) {
                    System.out.println("A");
                }else{
                    System.out.println("B");
                }
                break;
            }
        }

    }


}




















