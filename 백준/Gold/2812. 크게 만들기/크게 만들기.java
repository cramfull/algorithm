
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, K, result;
    static String[] num;
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    // stack에 넣음
    // while K>0
    // 1. stack.peek < k(다음 수)
    //              a. k > 0  -> pop , push
    //              b. k = 0  -> push

    // 2. stack.peek >= k(다음 수)  -> push
    //              a. k > 0  -> push
    //              b. k = 0  -> push


    public static void main(String[] args) throws IOException {
        init();
        solution();

        System.out.println(sb);
    }


    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken());
        num = br.readLine().split("");
    }

    static void solution() {
        int idx = 0;
        // 초기 idx 0번째 stack에 삽입
        stack.push(Integer.parseInt(num[idx++]));
        // 이후 idx > 1
        while (idx < num.length) {
            int value = Integer.parseInt(num[idx++]);
            while (!stack.isEmpty() && K > 0) {
                if(stack.peek() < value) {
                    K--;
                    stack.pop();
                }else{
                    break;
                }
            }
            stack.push(value);
        }
        // 남은 K만큼 뒤에서부터 빼주기
        while(K>0){
            K--;
            stack.pop();
        }

        Iterator<Integer> it = stack.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
    }
}
