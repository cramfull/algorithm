/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.io.*;
import java.util.*;

/*

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static int height;
	static int width;
	static char [][] map;
	static Tank tank;
	static HashMap<Character, Integer[]> dir = new HashMap<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		dir.put('<', new Integer[] {0,-1});
		dir.put('>', new Integer[] {0,1});
		dir.put('^', new Integer[] {-1,0});
		dir.put('v', new Integer[] {1,0});
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=TC;tc++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			
			height = Integer.parseInt(str.nextToken());
			width = Integer.parseInt(str.nextToken());
			
			map = new char[height][width];
			
			for(int i=0;i<height;i++) {
				String line = br.readLine();
				for(int j=0;j<width;j++) {
					map[i][j]=line.charAt(j);
					if(map[i][j]=='<') {
						tank = new Tank(i,j,dir.get('<'));
					}else if(map[i][j]=='>') {
						tank = new Tank(i,j,dir.get('>'));
					}else if(map[i][j]=='^') {
						tank = new Tank(i,j,dir.get('^'));
					}else if(map[i][j]=='v') {
						tank = new Tank(i,j,dir.get('v'));
					}
				}
			}
			
			int N = Integer.parseInt(br.readLine());
			String line = br.readLine();
			for(int i=0;i<N;i++) {
				char operation = line.charAt(i);
				if(operation == 'S') {
					shot();
				}else if(operation == 'U') {
					goUp();
				}else if(operation == 'D') {
					goDown();
				}else if(operation == 'L') {
					goLeft();
				}else if(operation == 'R') {
					goRight();
				}
			}
			
			sb.append("#").append(tc).append(" ");
			for(int i=0;i<height;i++) {
				for(int j=0;j<width;j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}

	static boolean isInRangeWidth(int x, int ny) {
		return (ny>=0 && ny<width);
	}
	
	static boolean isInRangeHeight(int nx, int y) {
		return (nx>=0 && nx<height);
	}
	
	static void upToDateTank(int x, int y, Integer[] dir) {
		tank.x=x;
		tank.y=y;
		tank.dir = dir;
	}
	
	static void goLeft() {
		int x = tank.x;
		int y = tank.y;
		tank.dir = dir.get('<');
		
		if(isInRangeWidth(x,y-1)) {
			map[x][y] = '<';
			if(map[x][y-1]=='.') {
				map[x][y] = '.';
				map[x][y-1] = '<';
				upToDateTank(x,y-1,dir.get('<'));
			}
		}else {
			map[x][y] = '<';
		}
	}
	
	static void goRight() {
		int x = tank.x;
		int y = tank.y;
		tank.dir = dir.get('>');

		if(isInRangeWidth(x,y+1)) {
			map[x][y] = '>';
			if(map[x][y+1]=='.') {
				map[x][y] = '.';
				map[x][y+1] = '>';
				upToDateTank(x,y+1,dir.get('>'));
			}
		}else {
			map[x][y] = '>';
		}
	}
		
	static void goUp() {
		int x = tank.x;
		int y = tank.y;
		tank.dir = dir.get('^');
		
		if(isInRangeHeight(x-1,y)) {
			map[x][y] = '^';
			if(map[x-1][y]=='.') {
				map[x][y] = '.';
				map[x-1][y] = '^';
				upToDateTank(x-1,y,dir.get('^'));
			}
		}else {
			map[x][y] = '^';

		}
	}
	
	static void goDown() {
		int x = tank.x;
		int y = tank.y;
		tank.dir = dir.get('v');

		
		if(isInRangeHeight(x+1,y)) {
			map[x][y] = 'v';
			if(map[x+1][y]=='.') {
				map[x][y] = '.';
				map[x+1][y] = 'v';
				upToDateTank(x+1,y,dir.get('v'));
			}
		}else {
			map[x][y] = 'v';
		}
	}
	
	static void shot() {
		int x = tank.x;
		int y = tank.y;
		Integer [] dir = tank.dir;
		int nx = x+dir[0];
		int ny = y+dir[1];
		while(nx>=0 && ny>=0 && nx<height && ny<width) {
			if(map[nx][ny]=='#') return;
			if(map[nx][ny]=='*') {
				map[nx][ny]='.';
				return;
			}
			nx+=dir[0];
			ny+=dir[1];
		}
	}
	
	
	static class Tank{
		int x, y;
		Integer [] dir;
		
		public Tank(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public Tank(int x, int y, Integer [] dir) {
			this(x,y);
			this.dir = dir;
		}
		
	}

}
