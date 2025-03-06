
import java.util.*;
import java.io.*;

public class Main {

    static int V, E, start;
    static boolean [] visited;
    static int [] distance;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String [] args) throws IOException{
        init();
        solution();
        System.out.println(sb);
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] inputs  = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        V = inputs[0];
        E = inputs[1];
        start = Integer.parseInt(br.readLine());

        visited = new boolean[V + 1];
        distance = new int[V + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.get(inputs[0]).add(new Node(inputs[1], inputs[2]));
        }
    }

    private static void solution(){
        dijkstra(start);

        for (int i = 1; i < distance.length; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            }else{
                sb.append(distance[i]).append("\n");
            }
        }
    }

    private static void dijkstra(int index){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        distance[index] = 0;

        pq.offer(new Node(index, 0));

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();

            if(visited[currentNode.index]){
                continue;
            }
            visited[currentNode.index] = true;

            for (Node node : graph.get(currentNode.index)) {
                if (!visited[node.index]
                        && distance[node.index] > node.distance + distance[currentNode.index]) {
                    distance[node.index] = node.distance + distance[currentNode.index];
                    pq.add(new Node(node.index, distance[node.index]));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        //
        int index;
        int distance;

        public Node(int index, int distance){
            this.index = index;
            this.distance = distance;
        }

        public int compareTo(Node o){
            return Integer.compare(this.distance, o.distance);
        }

    }
}
