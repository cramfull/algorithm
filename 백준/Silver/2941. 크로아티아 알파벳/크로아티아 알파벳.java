
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int count = 0;
        boolean check = false;
        String[] strArr = new String[]{"c=","c-","dz=","d-","lj","nj","s=","z="};

        for(int i = 0; i<s.length(); i++){
            for(int j = 0; j<strArr.length; j++){
                if(s.charAt(i) == 'd' && i <= s.length()-3) {
                    if (s.charAt(i + 1) == strArr[2].charAt(1) && s.charAt(i + 2) == strArr[2].charAt(2)) {
                        i += 2;
                        count++;
                        check = true;
                        break;
                    }
                }
                if(i != s.length()-1) {
                    if (s.charAt(i) == strArr[j].charAt(0) &&
                            s.charAt(i + 1) == strArr[j].charAt(1) && j != 2) {
                        i += 1;
                        count++;
                        check = true;
                        break;
                    }
                }else{
                    break;
                }
            }
            if(!check){
                count++;
            }else{
                check = false;
            }
        }
        System.out.print(count);
    }
}