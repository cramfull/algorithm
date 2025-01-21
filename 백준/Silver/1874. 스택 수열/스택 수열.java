
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    // 1/ 2/ 3 4 5/ 4<- NO
    // 4 3 6 8 7 5 2 1

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> inStack = new Stack<>();
        Stack<Integer> outStack = new Stack<>();

        for (int i = N; i>0; i--) {
            outStack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        int idx = 0;

        while (idx < arr.length) {
            int target = arr[idx];
            if (!outStack.isEmpty()) {
                while (target > outStack.peek()) {
                    inStack.push(outStack.pop());
                    sb.append("+").append("\n");
                }
            }
            if(!outStack.isEmpty()){
                if (outStack.peek() == target) {
                    outStack.pop();
                    sb.append("+").append("\n").append("-").append("\n");
                    idx++;
                    continue;
                }
            }
            if (!inStack.isEmpty()) {
                if (inStack.peek() == target) {
                    inStack.pop();
                    sb.append("-").append("\n");
                    idx++;
                } else {
                    sb = new StringBuilder("NO");
                    System.out.println(sb);
                    return;
                }
            }
        }
        System.out.println(sb);
    }

}
