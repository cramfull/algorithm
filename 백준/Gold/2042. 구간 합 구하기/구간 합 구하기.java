import java.io.*;
import java.util.*;

public class Main {

	static int N,M,K;
	static long [] inputs, tree;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		K = Integer.parseInt(str.nextToken());
		
		inputs = new long[N];
		tree = new long[4*N];
		
		for(int i=0;i<N;i++) {
			inputs[i]=Long.parseLong(br.readLine());
		}
		
		build(1,0,N-1);

		for(int i=0;i<M+K;i++) {
			str = new StringTokenizer(br.readLine());
			int mode = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			long c = Long.parseLong(str.nextToken());
			
			if(mode==1) {
				updateTree(1, 0, N-1, b-1, c-inputs[b-1]);
				// 반드시 입력 값을 저장하는 배열도 최신화를 시켜줘야한다.
				inputs[b-1] = c;
			}else if(mode==2) {
				sb.append(prefixSum(1, 0, N-1, b-1, c-1)).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	/**
	 * 세그먼트 트리 구성
	 * 재귀적으로 트리를 구성해 나감
	 * 리프노드에 도달할 경우 원 값을 저장 
	 * 하위 노드의 값이 모두 채워졌다면, 해당 위치의 상위 노드에 합을 저장함
	 * @param node 노드 번호
	 * @param start 트리 범위 시작점
	 * @param end 트리 범위 끝점
	 */
	static void build(int node, int start, int end) {
		// 쪼개진 범위가 같음 => 리프노드에 도달함
		if(start == end) {
			// 리프노드 위치에 원 값 저장
			tree[node] = inputs[start];		
		}else {
			// 범위가 더 쪼개질 수 있다면, 좌측, 우측으로 범위를 쪼갬
			int mid = (start+end)/2;
			build(node*2, start, mid);
			build(node*2+1, mid+1, end);
			// 하위 노드들의 계산을 마쳤다면, 해당 노드들의 상위노드 값(두 노드의 합)을 갱신 
			tree[node] = tree[node*2]+tree[node*2+1];
		}
	}

	/**
	 * 세그먼트 트리를 활용해 구간합을 구함 
	 * 구간을 쪼개어 나가면서
	 * 	탐색 구간에서 벗어난 경우 -> 0 반환
	 * 	탐색 구간이 현재 범위 내인 경우 -> 현재 노드 값 반환
	 * 	범위가 일부만 겹치는 경우 -> 범위를 쪼개어 탐색하고, 탐색된 결과의 합을 반환
	 * @param node 노드 번호
	 * @param start 트리 범위 시작점 
	 * @param end 트리 범위 끝점
	 * @param i 탐색 범위 시작점
	 * @param j 탐색 범위 끝점 
	 * @return
	 */
	static long prefixSum(int node, int start, int end, int i, long j) {
		// 탐색 구간이 범위를 벗어난 경우
		if(j<start || end<i) return 0;
		
		// 탐색 구간이 범위 내에 존재하는 경우
		if(i<=start && end<=j) return tree[node];
		
		// 범위에 일부만 겹치는 경우 범위를 쪼갬
		int mid = (start+end)/2;
		long left = prefixSum(node*2, start, mid, i, j);
		long right = prefixSum(node*2+1, mid+1, end, i, j);
		// 쪼개서 재귀적으로 계산을 마친 합을 반환함
		return left+right;
	}
	
	/**
	 * 생성된 트리의 일부 값을 변경 
	 * 관여된 모든 부분에 해당 내용을 갱신해야 함.
	 * 탐색 구간을 벗어난 경우 -> return
	 * 변화량을 해당 노드에 적용시키면서 내려감
	 * 리프노드에 도달하지 못한 경우
	 * 	범위를 쪼개어 계산을 이어가고
	 * 리프노드에 도달한 경우
	 * 	return
	 * @param node 노드 번호 
	 * @param start 트리 범위 시작점
	 * @param end 트리 범위 끝점 
	 * @param idx 변경할 값 target index
	 * @param diff 변경할 값의 변화량 (리프노드를 변경하기 위해 탐색하는 과정 전체에 이를 적용하기 위해)
	 */
	static void updateTree(int node, int start, int end, int idx, long diff) {
		// 탐색 구간이 범위를 벗어난 경우
		if(idx<start || end<idx) return;
		// 변화량을 해당 노드에 적용시킴
		tree[node] += diff;
		// 리프 노드가 아닌 경우에는 범위를 쪼개어 계산을 이어가고
		// 리프 노드인 경우에는 계산을 종료하게 된다.
		if(start!=end) {
			int mid = (start+end)/2;
			updateTree(node*2, start, mid, idx, diff);
			updateTree(node*2+1, mid+1, end, idx, diff);
		}
	}
}
