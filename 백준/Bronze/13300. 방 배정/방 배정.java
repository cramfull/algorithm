
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static HashMap<Integer, HashMap<Integer, Integer>> hashMap = new HashMap<Integer, HashMap<Integer, Integer>>();

    public static void main(String [] args) throws IOException{
        // N : 입력 수
        // K : 1 방 최대 인원 수

        // 학년 -> 성별 인원 수 체크
        // 학년 map -> 성별 map -> 명 수
            // 명 수 == 0 -> continue
            // 명 수 % K == 0 -> 몫 그대로 합산
            // else -> 몫 + 1 합산
        for(int i=0;i<6;i++){
            hashMap.put(i, new HashMap<>());
            for (int j = 0; j < 2; j++) {
                hashMap.get(i).put(j, 0);
            }
        }

        inputs();
        int result = solving();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    public static void inputs() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken());

        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(str.nextToken());
            int Y = Integer.parseInt(str.nextToken());

            hashMap.get(Y-1).put(S, hashMap.get(Y-1).get(S) + 1);
        }
    }

    public static int solving() {
        int sum = 0;
        // 학년 map -> 성별 map -> 명 수
        // 명 수 == 0 -> continue
        // 명 수 % K == 0 -> 몫 그대로 합산
        // else -> 몫 + 1 합산
        for (int i = 0; i < hashMap.size(); i++) {
            for (int j = 0; j < hashMap.get(i).size(); j++) {
                int value = hashMap.get(i).get(j);
                if (value == 0) {
                    continue;
                }
                if (value % K == 0) {
                    sum += value / K;
                } else {
                    sum += value / K + 1;
                }
            }
        }
        return sum;
    }
}
