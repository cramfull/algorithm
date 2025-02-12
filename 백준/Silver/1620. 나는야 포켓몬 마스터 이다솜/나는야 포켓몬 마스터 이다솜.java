
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static Map<Integer, String> pocketMonNums = new HashMap<>();
    static Map<String, Integer> pocketMonNames = new HashMap<>();
    static ArrayList<String> inputs = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String [] args) throws IOException{
        // 입력 받기
        // Map 1에 Key, Value (순서, 포켓몬이름) 저장
        // Map 2에 Key, Value (포켓몬이름, 순서) 저장
        init();
        // int 입력 -> Value 리턴
        // String 입력 -> Key 리턴
        solution();

        System.out.println(sb);
    }


    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            pocketMonNums.put(i, line);
            pocketMonNames.put(line, i);
        }
        for(int i=1; i<=M; i++){
            inputs.add(br.readLine());
        }
    }

    private static void solution(){
        for(String s : inputs){
            try{
                int n = Integer.parseInt(s);
                sb.append(pocketMonNums.get(n));
            }catch(NumberFormatException e){
                sb.append(pocketMonNames.get(s));
            }
            sb.append("\n");
        }
    }

    @Deprecated
    private static int getKeyFromValue(String s){
        Set<Map.Entry<Integer, String>> entries = pocketMonNums.entrySet();
        for(Map.Entry<Integer, String> entry : entries){
            if (entry.getValue().equals(s)) {
                return entry.getKey();
            }
        }
        return -1; // 에러
    }

}
