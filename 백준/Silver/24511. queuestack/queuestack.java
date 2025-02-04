
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    static int N, M;
    static String [] modify, inside, nums;
    static Deque<Integer> deque;

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        deque = new LinkedList<>();
        N = Integer.parseInt(br.readLine());
        modify = br.readLine().split(" ");
        inside = br.readLine().split(" ");
        for (int i=0;i<modify.length; i++) {
            if(modify[i].equals("0")){
                deque.addFirst(Integer.parseInt(inside[i]));
            }
        }
        M = Integer.parseInt(br.readLine());
        nums = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            int num = Integer.parseInt(nums[i]);
            sb.append(doingQueueStack(num)).append(" ");
        }

        System.out.println(sb);
    }

    // 0 일 경우 Queue -> 수 바꾸기
    static int doingQueueStack(int input){
        deque.addLast(input);
        int output = deque.pollFirst();
        return output;
    }

    //  1 2 3 4
    //  4 1 2

}
