import java.io.*;
import java.util.*;

public class Solution {
	
	static int N;
	static ArrayList<Atom> list;
	
	public static void main(String [] args) throws IOException{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(in.readLine());
			list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				int x = Integer.parseInt(st.nextToken())*2;
				int y = Integer.parseInt(st.nextToken())*2;
				int d = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				list.add(new Atom(x,y,d,e));
			}
			System.out.println("#"+tc+" "+solving());
		}
	}
	
	static int solving() {
		Collections.sort(list);
		ArrayList<Point> boomList = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			for(int j=i+1;j<N;j++) {
				Atom a = list.get(i);
				Atom b = list.get(j);
				
				if(a.x==b.x) {
					if(a.dir==0 && b.dir==1) {
						boomList.add(new Point(i,j,Math.abs(a.y-b.y)/2));
					}
				}
				
				if(a.y==b.y) {
					if(a.dir==3 && b.dir==2) {
						boomList.add(new Point(i,j,Math.abs(a.x-b.x)/2));
					}
				}
				
				if(a.x-a.y==b.x-b.y) {
					if(a.dir==3 && b.dir==1 || a.dir==0 && b.dir==2) {
						boomList.add(new Point(i,j,Math.abs(a.x-b.x)));
					}
				}
				
				if(a.x+a.y==b.x+b.y) {
					if(a.dir==1 && b.dir==2 || a.dir==3 && b.dir==0) {
						boomList.add(new Point(i,j,Math.abs(a.x-b.x)));
					}
				}
			}
		}
		
		return getTotalEnergy(boomList);
	}
	
	static int getTotalEnergy(ArrayList<Point> boomList) {
		Collections.sort(boomList); // 터지는 시간 기준 오름차순 정렬
		int INF = Integer.MAX_VALUE;
		int boomTimes[] = new int[N];
		Arrays.fill(boomTimes, INF);
		int sum = 0;
		
		for (Point p : boomList) {
			
			if(boomTimes[p.x] < p.time || boomTimes[p.y] < p.time) continue;
			
			if(boomTimes[p.x] == INF) {
				boomTimes[p.x] = p.time;
				sum += list.get(p.x).energy;
			}
			if(boomTimes[p.y] == INF) {
				boomTimes[p.y] = p.time;
				sum += list.get(p.y).energy;
			}
		}
		return sum;
	}
	
	
	static class Atom implements Comparable<Atom>{
		int x,y,dir,energy;
		public Atom(int x, int y, int dir, int energy) {
			this.x=x;
			this.y=y;
			this.dir=dir;
			this.energy=energy;
		}
		
		@Override
		public int compareTo(Atom o) {
			return (this.x<o.x)?-1:(this.x != o.x ? Integer.compare(this.x, o.x) : Integer.compare(this.y,o.y));
		}
	}
	
	static class Point implements Comparable<Point>{
		int x,y,time;
		public Point(int x, int y, int time) {
			this.x=x;
			this.y=y;
			this.time=time;
		}
		
		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.time, o.time);
		}
	}
}
