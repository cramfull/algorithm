import java.io.*;
import java.util.*;

/*
 * Gear
 * leftIdx, scoreIdx, rightIdx
 * bfs로
 * 
 * 큐에서 꺼내서 
 * 회전 (idx 적용)
 * score 더하기
 * visited true
 * 다음 기어가 나보다 작은 id의 경우
 * 내 왼쪽, 다음거 오른쪽 같은지 검사
 * id가 큰 경우
 * 내 오른쪽, 다음거 왼쪽 같은지 검사
 * 
 * 다른 경우, 방문x인 경우 
 * 큐에 삽입 
 *  
 * 
 */
public class Solution {

	static int K, result;
	static Gear[] gears;
	static boolean [] visited;
	static int [] works;
	static ArrayList<ArrayList<Integer>> edges;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=TC;tc++) {
			K = Integer.parseInt(br.readLine());
			result = 0;
			edges = new ArrayList<>();
			for(int i=0;i<5;i++) {
				edges.add(new ArrayList<>());
				if(1<i) {
					edges.get(i).add(i-1);
				}
				if(0<i && i<4) {
					edges.get(i).add(i+1);
				}
			}
			gears = new Gear[5];
			for(int i=1;i<gears.length;i++) {
				String[] line = br.readLine().split(" ");
				gears[i] = new Gear(i);
				for(int j=0;j<8;j++) {
					gears[i].teeth[j]=Integer.parseInt(line[j]);
				}
			}
			
			for(int i=0;i<K;i++) {
				StringTokenizer str = new StringTokenizer(br.readLine());
				visited = new boolean[5];
				works = new int[5];
				int gearId = Integer.parseInt(str.nextToken());
				int direction = Integer.parseInt(str.nextToken());
				
				bfs(gearId, direction);
				
				for(int j=1;j<=4;j++) {
					int work = works[j];
					if(work==0)continue;
					Gear gear = gears[j];
					gear.spin(work);
				}
			}
			for(int j=1;j<=4;j++) {
				Gear gear = gears[j];
				result+=gear.getScore(j);
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}

	static void bfs(int gearId, int direction) {
		Queue<Integer> que = new LinkedList<>();
		
		que.offer(gearId);
		visited[gearId] = true;
		works[gearId] = direction;
		
		while(!que.isEmpty()) {
			int now = que.poll();
			Gear nowGear = gears[now];
			for(int i=0;i<edges.get(now).size();i++) {
				int next = edges.get(now).get(i);
				if(visited[next]) continue;
				boolean flag = false;
				Gear nextGear = gears[next];
				if(nowGear.id > nextGear.id) {
					if(nowGear.teeth[nowGear.leftIdx]!=nextGear.teeth[nextGear.rightIdx]) flag=true;
				}else {
					if(nowGear.teeth[nowGear.rightIdx]!=nextGear.teeth[nextGear.leftIdx]) flag=true;
				}
				if(flag && !visited[next]) {
					works[nextGear.id] = works[nowGear.id]*-1;
					visited[next] = true;
					que.offer(next);
				}
			}
			
		}
	}
	
	
	static class Gear{
		int [] teeth;
		int id, leftIdx, topIdx, rightIdx;
		
		public Gear(int id) {
			this.id = id;
			this.teeth = new int[8];
			this.topIdx = 0;
			this.leftIdx = 6;
			this.rightIdx = 2;
		}
		
		public void spin(int direction) {			
			if(direction==-1) {
				this.rightIdx = (this.rightIdx+1)%teeth.length;
				this.topIdx = (this.topIdx+1)%teeth.length;
				this.leftIdx = (this.leftIdx+1)%teeth.length;
			}else if(direction==1) {
				this.leftIdx-=1;
				this.topIdx-=1;
				this.rightIdx-=1;
				if(this.leftIdx<0) this.leftIdx+=teeth.length;
				if(this.topIdx<0) this.topIdx+=teeth.length;
				if(this.rightIdx<0) this.rightIdx+=teeth.length;
			}
		}
		
		public int getScore(int i) {
			return (this.teeth[topIdx]==0) ? 0 : (int) Math.pow(2,i-1);
		}
	}
}
