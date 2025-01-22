
import java.io.*;
import java.util.*;

public class Main {
    // 두 노드 사이의 거리 중 최댓값 = 트리의 지름

    // dfs 메서드, 트리 저장 list, 클래스(연결정점, 가중치), 값 저장 array
    static ArrayList<ArrayList<Edge>> tree = new ArrayList<>();
    static int [] arr;

    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        Arrays.fill(arr, -1);

        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<Edge>());
        }

        for (int i = 0; i < N - 1; i++) {
            String[] line = br.readLine().split(" ");
            int vertex1 = Integer.parseInt(line[0]);
            int vertex2 = Integer.parseInt(line[1]);
            int dist = Integer.parseInt(line[2]);

            tree.get(vertex1).add(new Edge(vertex2, dist));
            tree.get(vertex2).add(new Edge(vertex1, dist));
        }

        // 임의의 노드에서 dfs로 가장 먼 노드를 찾는다
        arr[1] = 0;
        dfs(1);
        int furthestVertex = getFurthestIndex();

        // 해당 노드에서 dfs로 가장 먼 노드를 찾는다.
        arr = new int[N + 1];
        Arrays.fill(arr, -1);
        arr[furthestVertex] = 0;
        dfs(furthestVertex);
        int maxTreeDiameterIdx = getFurthestIndex();

        System.out.println(arr[maxTreeDiameterIdx]);
    }

    static void dfs(int vertex) {

        for (int i = 0; i < tree.get(vertex).size(); i++) {
            Edge edge = tree.get(vertex).get(i);
            int nextVertex = edge.getNode();
            int dist = edge.getDist();
            if (arr[nextVertex] == -1) {
                arr[nextVertex] = arr[vertex] + dist;
                dfs(nextVertex);
            }
        }
    }

    static int getFurthestIndex(){
        int idx = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[idx] < arr[i]) {
                idx = i;
            }
        }
        return idx;
    }

    static class Edge {
        private int node;
        private int dist;

        public Edge(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        public int getNode(){
            return this.node;
        }
        public int getDist(){
            return this.dist;
        }
    }


}
