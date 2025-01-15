
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String code = br.readLine();
        int N = Integer.parseInt(br.readLine());
        String[] pureWords = new String[N];
        for (int i = 0; i < N; i++) {
            pureWords[i] = br.readLine();
        }

        System.out.println(checkingCode(code, pureWords));
    }

    static String checkingCode(String code, String [] pureWords){
        for (int i = 0; i < 26; i++) {
            String result = decoding(code, i);
            for (String pureWord : pureWords) {
                if (result.contains(pureWord)) {
                    return result;
                }
            }
        }
        return null;
    }

    static String decoding(String code, int gap) {
        char[] codeArr = code.toCharArray();
        for (int i = 0; i < codeArr.length; i++) {
            codeArr[i] = (char) ((codeArr[i]-'a' + gap)%26 + 'a');
        }
        return new String(codeArr);
    }

}
