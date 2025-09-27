import java.io.*;
import java.util.*;

/* 0924 20:51
 * 무게만큼의 배열
 * 보장이 안되네..
 * 보니까 우선순위 큐..?
 * PQ로 어떻게 하지 가격 순으로 pq에 넣고 빼가면서 가방에 최대한으로 넣는다?
 * 
 * 가방에 최대한으로 넣는다 -> 크기가 작은 가방부터 최대한으로 채운다
 */
public class Main {

	static int N,K;
	static PriorityQueue<Jewel> pq;
	static Jewel [] jewels;
	static int [] bags;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(str.nextToken());
		K = Integer.parseInt(str.nextToken());
		
		jewels = new Jewel[N];
		bags = new int[K];
		
		for(int i=0;i<N;i++) {
			str = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(str.nextToken());
			int value = Integer.parseInt(str.nextToken());
			jewels[i] = new Jewel(weight, value);
		}

		for(int i=0;i<K;i++) {
			bags[i]=Integer.parseInt(br.readLine());
		}
		
		// 가방, 보석 무게 오름차순 정렬 
		// 해당 가방보다 작은 무게만큼 pq에 삽입 
		// 가장 큰값 결과에 포함
		
		Arrays.sort(jewels, new Comparator<Jewel>() {
			@Override
			public int compare(Jewel o1, Jewel o2) {
				return o1.weight - o2.weight;
			}
		});
		Arrays.sort(bags);
		
		pq = new PriorityQueue<>((o1, o2)-> (o2.value-o1.value));

		int idx = 0;
		long result = 0;
		
		for(int i=0;i<bags.length;i++) {
			int bag = bags[i];
			while(idx<jewels.length && jewels[idx].weight<=bag) {
				pq.offer(jewels[idx++]);
			}
			if(!pq.isEmpty())result+=pq.poll().value;
		}
		
		System.out.println(result);
		
	}

	static class Jewel {
		int weight, value;
		public Jewel(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}
	}
}
