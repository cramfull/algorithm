import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	// Edge 클래스는 기존과 동일합니다.
	static class Edge implements Comparable<Edge> {
		int to; // 목적지 정점
		long cost; // 비용 (거리의 제곱)

		Edge(int to, long cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			// 비용을 기준으로 오름차순 정렬
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

			// 좌표 입력 (0-based indexing)
			StringTokenizer stX = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				points[i][0] = Integer.parseInt(stX.nextToken());
			}

			StringTokenizer stY = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				points[i][1] = Integer.parseInt(stY.nextToken());
			}

			double E = Double.parseDouble(br.readLine());

			// 인접 리스트로 그래프 구성 (모든 섬 간의 거리 계산)
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


			// 1. minEdge 배열과 visited 배열 초기화
			long[] minEdge = new long[N];
			boolean[] visited = new boolean[N];
			Arrays.fill(minEdge, Long.MAX_VALUE); // 모든 비용을 무한대로 초기화

			PriorityQueue<Edge> pq = new PriorityQueue<>();

			// 2. 0번 섬을 시작점으로 설정
			minEdge[0] = 0;
			pq.add(new Edge(0, 0));

			double totalCost = 0; // 총 환경 부담금 (L^2)
			int connectedCount = 0; // 연결된 섬의 개수

			while (!pq.isEmpty()) {
				Edge now = pq.poll();
				int currentNode = now.to;
				long currentCost = now.cost;

				// 이미 방문한 곳이면 건너뜀 (PQ에 있는 더 비싼 경로 무시)
				if (visited[currentNode]) {
					continue;
				}
				
				visited[currentNode] = true;
				totalCost += currentCost;
				connectedCount++;
				
				// 모든 섬이 연결되면 종료
				if (connectedCount == N) {
					break;
				}

				// 3. 현재 섬과 연결된 다른 섬들의 최소 비용 갱신
				for (Edge next : graph.get(currentNode)) {
					// 아직 방문하지 않았고, 기존 비용보다 더 저렴한 경로를 발견했다면
					if (!visited[next.to] && next.cost < minEdge[next.to]) {
						minEdge[next.to] = next.cost; // 최소 비용 갱신
						pq.add(new Edge(next.to, next.cost)); // 더 저렴한 경로를 PQ에 추가
					}
				}
			}
			// --- 최적화된 프림 알고리즘 종료 ---

			sb.append('#').append(testcase).append(' ');
			sb.append(Math.round(totalCost * E));
			sb.append('\n');
		}
		System.out.println(sb);
	}
}