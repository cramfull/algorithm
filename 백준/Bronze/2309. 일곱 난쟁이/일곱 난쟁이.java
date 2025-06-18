
import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Main {
    //    static ArrayList<Integer> arr = new ArrayList<>();
    static HashSet<Integer> set = new HashSet<>();
    static int sum;
    public static void main(String [] args) throws IOException {
        inputs();
        solving();
    }

    public static void inputs() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sum = 0;
        for(int i=0; i<9; i++){
            int n = Integer.parseInt(br.readLine());
            set.add(n);
//            arr.add(n);
            sum+=n;
        }
    }

    public static void solving() throws IOException{
        // deleteSum = sum - 100
        //
        // deleteSum - now  == now

        // deleteSum - now  set.contains
        // set.remove( now, deleteSum-now )

        int deleteSum = sum - 100;
        Iterator<Integer> it = set.iterator();
        for(int i=0;i<9;i++){
            int now = it.next();
            int tmp = deleteSum - now;
            if (tmp == now) {
                continue;
            }
            if (set.contains(tmp)) {
                set.remove(now);
                set.remove(tmp);
                break;
            }
        }

        Integer [] answer = set.stream().sorted().toArray(Integer[]::new);

//        List<Integer> list = set.stream().sorted().toList();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (Integer a : answer) {
            bw.write(String.valueOf(a));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
