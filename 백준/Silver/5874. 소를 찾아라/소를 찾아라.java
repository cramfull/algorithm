
import java.io.*;
import java.util.*;

public class Main {
    // (( 뒷다리
    // )) 앞다리

    // (( )) 로 나오는 순서 쌍의 개수

    static final String backLeg = "(";
    static final String frontLeg = ")";
    static String[] array;
    static ArrayList<Integer> backLegIndexList = new ArrayList<>();
    static ArrayList<Integer> frontLegIndexList = new ArrayList<>();
    static int result = 0;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        System.out.println(result);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        array = br.readLine().split("");
    }

    static void solution() {
        for (int i = 0; i < array.length - 1; i++) {
            String pointer = array[i];
            if (pointer.equals(backLeg) && array[i + 1].equals(backLeg)) {
                backLegIndexList.add(i);
            }
            if (pointer.equals(frontLeg) && array[i + 1].equals(frontLeg)) {
                frontLegIndexList.add(i);
            }
        }
        for (int i = 0; i < backLegIndexList.size(); i++) {
            int backLegIndex = backLegIndexList.get(i);
            for (int j = 0; j < frontLegIndexList.size(); j++) {
                int frontLegIndex = frontLegIndexList.get(j);
                if (backLegIndex < frontLegIndex) {
                    result += frontLegIndexList.size() - j;
                    break;
                }
            }
        }
    }
}