
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
        int current = 1;
        int idx = 0;

        StringBuilder sb = new StringBuilder();
        while (idx < N) {
            int target = arr[idx];
            if (target >= current) {
                inStack.push(current++);
                sb.append("+").append("\n");
            } else if (target == inStack.peek()) {
                inStack.pop();
                sb.append("-").append("\n");
                idx++;
            } else {
                sb = new StringBuilder("NO");
                break;
            }
        }
        System.out.println(sb);
    }
}