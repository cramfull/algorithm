import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String key = br.readLine();
        String code = br.readLine();

        char [] keyArr = key.toCharArray();
        Arrays.sort(keyArr);

        ArrayList<String> arr = new ArrayList<>();
        int len = code.length() / key.length();
        for (int i = 0; i < key.length(); i++) {
            arr.add(keyArr[i] + code.substring(i*len, (i+1)*len));
        }
        char [][] result = new char[(code.length() / key.length())+1][key.length()];
        for (int i = 0; i < key.length(); i++) {
            char firstWord = key.charAt(i);
            int j=0;
            while(j<arr.size()){
                String lastCode = arr.get(j++);
                if (lastCode.charAt(0) == firstWord) {
                    for (int k = 0; k < lastCode.length(); k++) {
                        result[k][i] = lastCode.charAt(k);
                    }
                    arr.remove(lastCode);
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < len+1; i++) {
            sb.append(new String(result[i]));
        }

        System.out.println(sb);

    }
}
