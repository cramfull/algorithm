
import java.io.*;
import java.util.ArrayList;

public class Main {
    static int N;
    static String [] arr;
    static ArrayList<Integer> list;
    public static void main(String [] args) throws IOException {
        N = 0;
        arr = new String[N];
        list = new ArrayList<>();

        inputs();
        solving();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int a : list) {
            bw.write(String.valueOf(a)+" ");
        }
        bw.flush();
        bw.close();
    }

    public static void inputs() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = br.readLine().split(" ");
    }

    public static void solving() {
        for (int i = 0; i < N; i++) {
            list.add(i - Integer.parseInt(arr[i]), i + 1);
        }
    }
}















