
import java.util.*;
import java.io.*;

public class Main {
    // 합집합 연산
    // 같은 집합에 포함되어 있는지 확인 연산

    static int n, m;
    static int set [];
    static ArrayList<String> lines = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String [] args) throws IOException{
        init();
        solution();
        System.out.println(sb);
    }

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        n = Integer.parseInt(str.nextToken());
        m = Integer.parseInt(str.nextToken());

        set = new int[n + 1];
        for (int i = 0; i < set.length; i++) {
            set[i]=i;
        }
        for (int i = 0; i < m; i++) {
            lines.add(br.readLine());
        }

    }

    static void solution(){
        String [] input;
        int modify;
        int a, b;

        for(int i=0;i<m;i++){
            input = lines.get(i).split(" ");
            modify = Integer.parseInt(input[0]);
            a = Integer.parseInt(input[1]);
            b = Integer.parseInt(input[2]);

            if (modify == 0) {
                union(a, b);
            }else{
                if (isInclude(a, b)) {
                    sb.append("YES");
                }else{
                    sb.append("NO");
                }
                sb.append("\n");
            }
        }

    }

    // 압축 부모 찾기
    // 자기 자신인 경우 => 초기값 (합집합 x 상태)
    // 자기 자신이 아닌 경우 -> 최상위 노드 찾고, 해당 수에 최상위 노드 값 저장
    static int find(int x) {
        if (x == set[x]) {
            return x;
        }else{
            return set[x] = find(set[x]);
        }
    }

    // 두 수 부모를 찾음, 비교, 다를 경우 작은 수를 해로 가짐
    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            int bigNum = (int) Math.max(rootA, rootB);
            int smallNum = (int) Math.min(rootA, rootB);
            set[bigNum] = smallNum;
        }
    }

    // 재귀로 최고 부모의 해를 찾음(최상위 노드가 될 때)
    // 해당 두 최고 부모가 같음 => 집합에 포함됨 or not -> 포함 x
    static boolean isInclude(int a, int b) {
        return find(a) == find(b);
    }

}
