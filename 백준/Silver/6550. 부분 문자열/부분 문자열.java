
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력 받기
        String readLine;
        while ((readLine = br.readLine()) !=null) {

            String [] arr = readLine.split(" ");
            String s = arr[0];
//            if (s.isEmpty()) {
//                System.out.println("Yes");
//                continue;
//            }
            String t = arr[1];



            int idx = 0;
            // t 문자열 length 만큼 반복
            for (int i = 0; i < t.length(); i++) {
                char sChar = s.charAt(idx);
                char tChar = t.charAt(i);
            // t 문자열 s의 idx 문자열 일치 시 ++
                if (sChar==tChar){
                   idx++;
                    if (idx == s.length()) {
                        break;
                    }
                }
            }
            // idx == s.length + 1 인 경우
            if (idx == s.length()) {
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
}