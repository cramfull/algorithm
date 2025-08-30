import java.io.*;
import java.util.*;

/* 활주로 건설 가능 조건 판별 
 * 해당 라인의 길이가 같은 경우는 안됨 (건설할 필요 없음)
 * 
 * 길이 체크 배열을 두면 어떨까?
 * 	같은 수라면 누적해서 카운팅
 * 		다른 수면 새로 1부터 카운팅, 좌표점 list에 저장
 *  
 * 진행방향보다 수가 커지는 경우
 * 		좌측 => 좌측 현재-X칸이 >= 0 && 1보다크거나 같아야함 ,현재-1 칸이 X보다 크거나 같아야함 
 * 		설치한 칸은 -1로 최신화 
 * 
 * 진행방향보다 수가 작아지는 경우 
 * 		우측 => 우측 현재 + X-1칸이 <N && 우측 X-1칸이 X보다 크거나 같아야 함
 * 		설치한 칸은 -1로 최신화 
 * 
 * 이제 관건은 x,y 어느 쪽이든 검사 가능해야한건데 
 *   -> 좌표점 바꿔서 주면 되지않을까 
 *  
 * 
 */
public class Solution {

	static int N, X, count;
	static int [][] map;
	static int [] airStrip;
	static boolean [] available;
	static ArrayList<Pair> checkArray;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC;tc++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			N = Integer.parseInt(str.nextToken());
			X = Integer.parseInt(str.nextToken());
			map = new int[N][N];
			count = 0;
			for(int i=0;i<N;i++) {
				String [] line = br.readLine().split(" ");
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(line[j]);
				}
			}
			
			for(int i=0;i<N;i++) {
				airStrip = new int[N];
				airStrip[0] = 1;
				available = new boolean[N];
				available[0] = true;
				checkArray = new ArrayList<>();
				
				for(int j=1;j<N;j++) {
					int prev = map[i][j-1];
					int curr = map[i][j];
					saveAirStripPoint(j, prev, curr);
				}
				buildAirStrip();
				canUseAirStrip();
			}
			
			for(int i=0;i<N;i++) {
				airStrip = new int[N];
				airStrip[0] = 1;
				available = new boolean[N];
				available[0] = true;
				checkArray = new ArrayList<>();
				
				for(int j=1;j<N;j++) {
					int prev = map[j-1][i];
					int curr = map[j][i];
					saveAirStripPoint(j, prev, curr);
				}
				buildAirStrip();
				canUseAirStrip();
			}
			
			sb.append("#").append(tc).append(" ").append(count).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void saveAirStripPoint(int idx, int prev, int curr) {
			if(prev==curr) {
				airStrip[idx] = airStrip[idx-1]+1;
				available[idx] = true;
			}else if(prev<curr){
				airStrip[idx]=1;
				checkArray.add(new Pair(idx, Math.abs(prev-curr),false));
				available[idx] = false;
			}else if(prev>curr) {
				airStrip[idx]=1;
				checkArray.add(new Pair(idx, Math.abs(prev-curr), true));
				available[idx] = false;
			}
	}
	
	static void buildAirStrip() {
		for(int i=0;i<checkArray.size();i++) {
			Pair pair = checkArray.get(i);
			int idx = pair.idx;
			if(pair.isFall) {
//				 * 진행방향보다 수가 작아지는 경우 
//				 * 		우측 => 우측 현재 + X-1칸이 <N && 우측 X-1칸이 X보다 크거나 같아야 함
//				 * 		설치한 칸은 -1로 최신화
				if(idx+X-1<N && airStrip[idx]>=1 &&airStrip[idx+X-1]>=X) {
					for(int j=idx;j<idx+X;j++) {
						airStrip[j]=-1;
						if(pair.delta==1) available[idx] = true;
					}
				}else {
					available[idx] = false;
				}
			}else {
//				 * 진행방향보다 수가 커지는 경우
//				 * 		좌측 => 좌측 현재-X칸이 >= 0 && 1보다크거나 같아야함 ,현재-1 칸이 X보다 크거나 같아야함 
//				 * 		설치한 칸은 -1로 최신화 
				if(idx-X>=0 && airStrip[idx-X]>=1 &&airStrip[idx-1]>=X) {
					for(int j=idx-X;j<idx;j++) {
						airStrip[j]=-1;
						if(pair.delta==1) available[idx] = true;
					}
				}else {
					available[idx] = false;
				}
			}
		}
	}
	
	static void canUseAirStrip() {
		boolean flag = true;
		for(int i=0;i<N;i++) {
			if(!available[i]) flag=false;
		}
		if(flag) count++;
	}
	
	static class Pair{
		int idx, delta;
		boolean isFall;
		public Pair(int idx, int delta, boolean isFall) {
			this.idx = idx;
			this.delta = delta;
			this.isFall =isFall;
		}
	}
}
