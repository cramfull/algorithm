
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    // 배열 시프트 연산 총 카운트하기
    // 0번은 그냥입력, 1번부터 시작

    // 입력 배열에서
    // 해당 원소보다 큰 것 중 가장 작은 것의 위치 찾기

    // 찾은 원소부터 제일 끝까지 시프트연산, 총 걸음 수 카운트++

    static int cnt;
;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] arr;
        int [] result;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            arr = br.readLine().split(" ");
            result = new int[20];
            int TC = Integer.parseInt(arr[0]);
            result[0] = Integer.parseInt(arr[1]);
            cnt = 0;
            for (int j = 2; j < arr.length; j++) {
                // 위치 찾기
                int nowValue = Integer.parseInt(arr[j]);
                int idx = findBigValue(result, nowValue, j-1);
                // 시프트 연산, 카운트
                shiftArray(result, idx, nowValue, j-2);
            }
            sb.append(String.format("%d %d", TC, cnt)).append("\n");
        }
        System.out.println(sb);

    }

    static int findBigValue(int [] arr, int nowValue, int size){
        for (int i = 0; i < size; i++) {
            if (nowValue < arr[i]) {
                return i;
            }
        }
        return size;
    }

    static void shiftArray(int [] arr, int idx, int nowValue, int lastIdx){
        for(int i=lastIdx; i>=idx; i--){
            arr[i + 1] = arr[i];
            cnt++;
        }
        arr[idx] = nowValue;
    }
}
