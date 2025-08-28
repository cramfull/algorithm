import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	static class Edge implements Comparable<Edge> {
		int to; 
		long cost; 

		Edge(int to, long cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.cost, o.cost);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int testcase = 1; testcase <= T; testcase++) {
			int N = Integer.parseInt(br.readLine());
			int[][] points = new int[N][2];

			StringTokenizer stX = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				points[i][0] = Integer.parseInt(stX.nextToken());
			}

			StringTokenizer stY = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				points[i][1] = Integer.parseInt(stY.nextToken());
			}

			double E = Double.parseDouble(br.readLine());

			List<List<Edge>> graph = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				graph.add(new ArrayList<>());
			}

			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					long dx = points[i][0] - points[j][0];
					long dy = points[i][1] - points[j][1];
					long cost = dx * dx + dy * dy;
					graph.get(i).add(new Edge(j, cost));
					graph.get(j).add(new Edge(i, cost));
				}
			}

			long[] minEdge = new long[N];
			boolean[] visited = new boolean[N];
			Arrays.fill(minEdge, Long.MAX_VALUE);

			PriorityQueue<Edge> pq = new PriorityQueue<>();

			minEdge[0] = 0;
			pq.add(new Edge(0, 0));

			double totalCost = 0; 
			int connectedCount = 0; 

			while (!pq.isEmpty()) {
				Edge now = pq.poll();
				int currentNode = now.to;
				long currentCost = now.cost;

				if (visited[currentNode]) {
					continue;
				}
				
				visited[currentNode] = true;
				totalCost += currentCost;
				connectedCount++;
				
				if (connectedCount == N) {
					break;
				}

				for (Edge next : graph.get(currentNode)) {
					if (!visited[next.to] && next.cost < minEdge[next.to]) {
						minEdge[next.to] = next.cost; 
						pq.add(new Edge(next.to, next.cost)); 
					}
				}
			}

			sb.append('#').append(testcase).append(' ');
			sb.append(Math.round(totalCost * E));
			sb.append('\n');
		}
		System.out.println(sb);
	}
}